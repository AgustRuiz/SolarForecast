package es.agustruiz.solarforecast.service.apiClients;

import es.agustruiz.solarforecast.bean.TiempoComBean;
import es.agustruiz.solarforecast.exception.ExceptionCreateForecastQueryRegistry;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;
import es.agustruiz.solarforecast.model.api.tiempocom.TiempoComR3_ReportAPI;
import es.agustruiz.solarforecast.model.manager.ForecastPlaceManager;
import es.agustruiz.solarforecast.model.manager.ForecastQueryRegistryManager;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.model.tiempocom.TiempoComR3_Report;
import es.agustruiz.solarforecast.service.ForecastService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXB;
import org.apache.jasper.tagplugins.jstl.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class TiempoComClient {

    protected static final String LOG_TAG = TiempoComClient.class.getName();

    protected static final String PROVIDER_NAME = TiempoComBean.FORECAST_PROVIDER_TAG;

    protected static final String URL_BASE = "http://api.tiempo.com";
    protected static final String URL_SCHEME = "http";

    protected static final String PATH = "index.php";

    protected static final String PARAM_API_LANG = "api_lang";
    protected static final String PARAM_API_LANG_VALUE = "es";
    protected static final String PARAM_LOCALIDAD = "localidad";
    protected static final String PARAM_LOCALIDAD_VALUE = "3593";
    protected static final String PARAM_AFFILIATE_ID = "affiliate_id";
    protected static final String PARAM_AFFILIATE_ID_VALUE = ApiKeys.TIEMPO_COM_AFFILIATE_ID;
    protected static final String PARAM_V = "v";
    protected static final String PARAM_V_VALUE = "2";
    protected static final String PARAM_H = "h";
    protected static final String PARAM_H_VALUE = "1";

    protected UriBuilder uriBuilder = null;

    @Autowired
    LogLineManager log;

    @Autowired
    ForecastService fService;

    @Autowired
    ForecastPlaceManager fPlacesManager;

    @Autowired
    ForecastQueryRegistryManager fQueryRegistryManager;

    // Public methods
    //
    public void QueryAllForecasts() {
        if (fService.isForecastServiceOn()) {
            log.d(LOG_TAG, "QueryAllForecasts Start");
            List<ForecastPlace> places = fPlacesManager.readAllForecastPlace();
            places.stream().forEach((ForecastPlace place) -> {
                log.i(LOG_TAG, String.format("Querying %s...", place.getName()));
                long queryTime = System.currentTimeMillis();
                TiempoComR3_ReportAPI reportAPI = getReport(place.getTiempoCom_LocationValue());
                if (reportAPI != null) {
                    ForecastQueryRegistry queryRegistry = new ForecastQueryRegistry();
                    queryRegistry.setForecastPlace(place);
                    queryRegistry.setForecastProvider(PROVIDER_NAME);
                    queryRegistry.setTimeInMillis(queryTime);
                    queryRegistry.setTiempoCom_list(TiempoComR3_Report.parseApiReport(reportAPI));
                    try {
                        fQueryRegistryManager.createForecastQueryRegistry(queryRegistry);
                        log.i(LOG_TAG, String.format("Query to %s OK!", place.getName()));
                    } catch (ExceptionCreateForecastQueryRegistry ex) {
                        log.e(LOG_TAG, String.format("Error saving %s forecast!", place.getName()));
                    }
                } else {
                    log.e(LOG_TAG, String.format("Error receiving %s forecasts", place.getName()));
                }
            });
        }
    }

    // Protected methods
    //
    protected TiempoComR3_ReportAPI getReport(String loc_value) {
        UriBuilder builder = UriBuilder.fromUri(URL_BASE);
        builder.scheme(URL_SCHEME);
        builder.path(PATH);
        builder.queryParam(PARAM_API_LANG, PARAM_API_LANG_VALUE);
        builder.queryParam(PARAM_LOCALIDAD, loc_value);
        builder.queryParam(PARAM_AFFILIATE_ID, PARAM_AFFILIATE_ID_VALUE);
        builder.queryParam(PARAM_V, PARAM_V_VALUE);
        builder.queryParam(PARAM_H, PARAM_H_VALUE);
        URI uri = builder.build();

        URLConnection connection;
        StringBuilder stringResponse = null;
        try {
            connection = uri.toURL().openConnection();
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                stringResponse = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    stringResponse.append(inputLine);
                }
            }
            log.d(LOG_TAG, "Response OK");
        } catch (IOException e) {
            log.e(LOG_TAG, String.format("Error connecting to API: %s", e.getMessage()));
        }

        return (stringResponse == null ? null : objectMapping(stringResponse.toString()));
    }

    private TiempoComR3_ReportAPI objectMapping(String xmlString) {
        return JAXB.unmarshal(new StringReader(xmlString), TiempoComR3_ReportAPI.class);
    }
}
