package es.agustruiz.solarforecast.controller;

import es.agustruiz.solarforecast.bean.OpenWeatherMapBean;
import es.agustruiz.solarforecast.bean.TiempoComBean;
import es.agustruiz.solarforecast.exception.ExceptionExportCSV;
import es.agustruiz.solarforecast.model.AbstractResponse;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastProvider;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;
import es.agustruiz.solarforecast.model.manager.ForecastPlaceManager;
import es.agustruiz.solarforecast.model.manager.ForecastProviderManager;
import es.agustruiz.solarforecast.model.manager.ForecastQueryRegistryManager;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.model.openweathermap.OWM_Forecast5Response;
import es.agustruiz.solarforecast.model.tiempocom.TiempoComR3_Report;
import es.agustruiz.solarforecast.service.ForecastService;
import es.agustruiz.solarforecast.service.GenerateExportCSV;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Controller
public class ExportController {

    private static final String LOG_TAG = ExportController.class.getName();

    @Autowired
    protected LogLineManager log;

    @Autowired
    protected ForecastService fService;

    @Autowired
    private ForecastPlaceManager fPlaceManager;

    @Autowired
    private ForecastProviderManager fProviderManager;

    @Autowired
    private ForecastQueryRegistryManager fQueryRegistryManager;

    @Autowired
    private GenerateExportCSV exporterCSV;

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String export(Model model) {
        configureModel(model);
        model.addAttribute("fPlaces", fPlaceManager.readAllForecastPlace());
        model.addAttribute("placeId", "-1");
        return ("export");
    }

    private static final String PARAM_PLACE = "selPlace";
    private static final String PARAM_PROVIDER = "selProvider";
    private static final String PARAM_FROM = "selFromDate";
    private static final String PARAM_TO = "selToDate";
    private static final String PARAM_ATTR_CHECKS = "paramCheck[]";
    private static final String PARAM_ATTR_VALUES = "paramValue[]";
    private static final String PARAM_ATTR_ORDER = "paramOrder[]";

    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public String exportSubmit(Model model, HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();

        int placeId = -1;
        int providerId = -1;

        if (parameterMap.containsKey(PARAM_PLACE)) {
            placeId = Integer.parseInt(parameterMap.get(PARAM_PLACE)[0]);
            if (parameterMap.containsKey(PARAM_PROVIDER)) {
                providerId = Integer.parseInt(parameterMap.get(PARAM_PROVIDER)[0]);

                ForecastPlace fPlace = fPlaceManager.readForecastPlace(placeId);
                ForecastProvider fProvider = fProviderManager.readById(providerId);

                List<ForecastQueryRegistry> fqrList = fQueryRegistryManager
                        .readAllByPlaceAndProvider(fPlace, fProvider);
                Map<Long, String> dateTime = new TreeMap<>();

                Map<String, String> paramTitleMap = null;
                switch (fProvider.getProviderName()) {
                    // OPEN WEATHER MAP
                    case OpenWeatherMapBean.FORECAST_PROVIDER_TAG:
                        paramTitleMap = OWM_Forecast5Response
                                .getParamList(AbstractResponse.PARAM_QUERY_TIMESTAMP_TAG,
                                        "Forecast Query Request Timestamp");
                        fqrList.stream().forEach((fqr) -> {
                            fqr.getOWM_list().stream().forEach((item) -> {
                                // Warning: item.getDt() are seconds!!!
                                dateTime.put(item.getDt().longValue(),
                                        timeInMillisToString(item.getDt().longValue() * 1000));
                            });
                        });
                        break;
                    // TIEMPO.COM
                    case TiempoComBean.FORECAST_PROVIDER_TAG:
                        paramTitleMap = TiempoComR3_Report
                                .getParamList(AbstractResponse.PARAM_QUERY_TIMESTAMP_TAG,
                                        "Forecast Query Request Timestamp");
                        fqrList.stream().forEach((fqr) -> {
                            fqr.getTiempoCom_list().stream().forEach((item) -> {
                                dateTime.put(item.getfTimestamp(),
                                        timeInMillisToString(item.getfTimestamp()));
                            });
                        });
                        break;
                    default:
                }

                model.addAttribute("dateTimeList", dateTime.entrySet());
                if (paramTitleMap != null) {
                    model.addAttribute("paramTitleMap", paramTitleMap.entrySet());
                    model.addAttribute("paramTitleMapSize", paramTitleMap.size());
                }

                if (parameterMap.containsKey(PARAM_FROM) && parameterMap.containsKey(PARAM_TO)
                        && parameterMap.containsKey(PARAM_ATTR_CHECKS)
                        && parameterMap.containsKey(PARAM_ATTR_VALUES)
                        && parameterMap.containsKey(PARAM_ATTR_ORDER)) {
                    // Received data to generate CSV file
                    //
                    long fromDate = Long.parseLong(parameterMap.get(PARAM_FROM)[0]);
                    long toDate = Long.parseLong(parameterMap.get(PARAM_TO)[0]);
                    String[] paramCheck = parameterMap.get(PARAM_ATTR_CHECKS);
                    String[] paramValues = parameterMap.get(PARAM_ATTR_VALUES);
                    String[] paramOrder = parameterMap.get(PARAM_ATTR_ORDER);

                    // Sort parameters
                    //
                    Map<Integer, String> sortedAttrs = new TreeMap<>();
                    for (int i = 0; i < paramCheck.length; ++i) {
                        if (paramCheck[i].equals("true")) {
                            sortedAttrs.put(
                                    Integer.parseInt(paramOrder[i]), paramValues[i]);
                        }
                    }

                    // Get lines deppending on the provider
                    //
                    Map<Long, AbstractResponse> fullLinesTree = new TreeMap<>();
                    switch (fProvider.getProviderName()) {
                        // OPEN WEATHER MAP
                        case OpenWeatherMapBean.FORECAST_PROVIDER_TAG:
                            fqrList.stream().forEach((collection) -> {
                                collection.getOWM_list().stream().forEach((item) -> {
                                    if (longIsBetween(item.getDt().longValue(), fromDate, toDate)) {
                                        item.setQueryTimestamp(collection.getTimeInMillis());
                                        fullLinesTree.put(item.getDt().longValue(), item);
                                    }
                                });
                            });
                            break;
                        // TIEMPO.COM
                        case TiempoComBean.FORECAST_PROVIDER_TAG:
                            fqrList.stream().forEach((collection) -> {
                                collection.getTiempoCom_list().stream().forEach((item) -> {
                                    item.setQueryTimestamp(collection.getTimeInMillis());
                                    if (longIsBetween(item.getfTimestamp(), fromDate, toDate)) {
                                        item.setQueryTimestamp(collection.getTimeInMillis());
                                        fullLinesTree.put(item.getfTimestamp(), item);
                                    }
                                });
                            });
                            break;
                    }

                    // Build output for csv file
                    //
                    List<List<String>> output = new ArrayList<>();
                    List<String> header = new ArrayList<>();
                    sortedAttrs.entrySet().stream().forEach((entry) -> {
                        header.add(entry.getValue());
                    });
                    output.add(header);

                    fullLinesTree.entrySet().stream().forEach((item) -> {
                        List<String> line = new ArrayList<>();
                        sortedAttrs.entrySet().stream().forEach((param) -> {
                            switch (fProvider.getProviderName()) {
                                // OPEN WEATHER MAP
                                case OpenWeatherMapBean.FORECAST_PROVIDER_TAG:
                                    line.add(((OWM_Forecast5Response) item.getValue())
                                            .getFielByTag(param.getValue()));
                                    break;
                                // TIEMPO.COM
                                case TiempoComBean.FORECAST_PROVIDER_TAG:
                                    line.add(((TiempoComR3_Report) item.getValue())
                                            .getFielByTag(param.getValue()));
                                    break;
                            }
                        });
                        output.add(line);
                    });

                    // Generate CSV file
                    //
                    try {
                        String basePath = request.getSession().getServletContext().getRealPath("/");
                        String internalPath = "resources\\exportCSV\\";
                        String path = exporterCSV.exportCSV(basePath, internalPath, output);
                        model.addAttribute("msgSuccess",
                                String.format("CSV export file successfuly created: <a href='%s' target='_blank'>DOWNLOAD HERE</a>", path));
                        log.i(LOG_TAG, String.format("CSV export file successfuly created: <a href='%s' target='_blank'>DOWNLOAD HERE</a>", path));
                    } catch (ExceptionExportCSV ex) {
                        model.addAttribute("msgError", "Error creating CSV export file");
                        log.e(LOG_TAG, String.format("Error creating CSV export file: %s", ex.getMessage()));
                    }
                }
            }
        }

        configureModel(model);
        model.addAttribute("fPlaces", fPlaceManager.readAllForecastPlace());
        model.addAttribute("placeId", placeId);
        model.addAttribute("fProviders", fProviderManager.readAll());
        model.addAttribute("providerId", providerId);

        return ("export");
    }

    // Private methods
    //
    private Model configureModel(Model model) {
        model.addAttribute("forecastServiceStatus", fService.isForecastServiceOn());
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Export forecasts");
        model.addAttribute("navActiveItem", "export");
        return model;
    }

    private String timeInMillisToString(long timeInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(cal.getTime());
    }

    private boolean longIsBetween(long value, long min, long max) {
        return value >= min && value <= max;
    }

}
