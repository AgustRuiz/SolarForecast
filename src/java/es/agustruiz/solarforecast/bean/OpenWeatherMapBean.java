package es.agustruiz.solarforecast.bean;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastProvider;
import es.agustruiz.solarforecast.exception.ExceptionCreateForecastQueryRegistry;
import es.agustruiz.solarforecast.exception.ExceptionNotValidFrequency;
import es.agustruiz.solarforecast.exception.ExceptionReadForecastPlace;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastProvider;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.Forecast5ResponseAPI;
import es.agustruiz.solarforecast.model.manager.ForecastPlaceManager;
import es.agustruiz.solarforecast.model.manager.ForecastProviderManager;
import es.agustruiz.solarforecast.model.manager.ForecastQueryRegistryManager;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.model.openweathermap.Forecast5Response;
import es.agustruiz.solarforecast.service.ForecastService;
import es.agustruiz.solarforecast.service.apiClients.OpenWeatherMapClient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class OpenWeatherMapBean {

    protected static final String LOG_TAG = OpenWeatherMapBean.class.getName();

    public static final long FIXED_RATE = 10000L;
    public static final String FORECAST_PROVIDER_TAG = "OpenWeatherMap";

    protected static final int MAX_QUERIES_PER_MINUTE = 60;

    @Autowired
    LogLineManager logManager;

    @Autowired
    ForecastService forecastService;

    @Autowired
    ForecastPlaceManager forecastPlaceManager;

    @Autowired
    ForecastQueryRegistryManager forecastQueryRegistryManager;

    @Autowired
    ForecastProviderManager forecastProviderManager;

    @Autowired
    OpenWeatherMapClient openWeatherMapClient;

    protected static ForecastProvider thisProvider = null;

    @PostConstruct
    public void prepareForecastProvider() {
//        logManager.d(LOG_TAG, "PostConstructor");
        thisProvider = forecastProviderManager.readByName(FORECAST_PROVIDER_TAG);
        if (thisProvider != null) {
//            logManager.d(LOG_TAG, "Forecast provider found. My job is done...");
        } else {
//            logManager.d(LOG_TAG, "Forecast provider not found. Let's create a new one...");
            try {
                int jarl = ForecastService.getDefaultQueryFrequency();
                thisProvider = new ForecastProvider(FORECAST_PROVIDER_TAG,
                        jarl);
                forecastProviderManager.create(thisProvider);
//                logManager.d(LOG_TAG, "Forecast created!");
            } catch (ExceptionNotValidFrequency | ExceptionCreateForecastProvider ex) {
                logManager.e(LOG_TAG,
                        String.format("Can't create the %s provider: %s",
                                FORECAST_PROVIDER_TAG, ex.getMessage()));
            }
        }
//        logManager.d(LOG_TAG, "End of postConstructor");
    }

    // Public methods
    //
    public void scheduledTask() {
        if (forecastService.isForecastServiceOn()) {
            logManager.i(LOG_TAG, "Scheduled task");
            ForecastPlace fPlace;
            try {
                fPlace = getNextForecastPlaceToQuery();
                ForecastQueryRegistry fQueryRegistry = new ForecastQueryRegistry();
                fQueryRegistry.setTimeInMillis(System.currentTimeMillis());
                fQueryRegistry.setForecastProvider(FORECAST_PROVIDER_TAG);
                fQueryRegistry.setForecastPlace(fPlace);

                Forecast5ResponseAPI f5ResponseAPI = openWeatherMapClient
                        .getForecast5(fPlace.getLatitude(), fPlace.getLongitude());
                List<Forecast5Response> f5ResponseList = new ArrayList<>();
                f5ResponseAPI.getList().stream().forEach((item) -> {
                    f5ResponseList.add(new Forecast5Response(item, fQueryRegistry));
                });
                fQueryRegistry.setOpenWeatherMapList(f5ResponseList);
                forecastQueryRegistryManager.createForecastQueryRegistry(fQueryRegistry);
                logManager.i(LOG_TAG,
                        String.format("Obtained %d rows from \"%s\" provider",
                                f5ResponseList.size(), FORECAST_PROVIDER_TAG));
            } catch (ExceptionReadForecastPlace ex) {
                logManager.e(LOG_TAG, "Can't read next forecast place to query: "
                        + ex.getMessage());
            } catch (ExceptionCreateForecastQueryRegistry ex) {
                logManager.e(LOG_TAG, "Can't save forecast for place: " + ex.getMessage());
            }
        }
    }

    // Private methods
    //
    private ForecastPlace getNextForecastPlaceToQuery() throws ExceptionReadForecastPlace {
        ForecastQueryRegistry targetQuery = null;
        List<ForecastPlace> placesList = forecastPlaceManager.readAllForecastPlace();
        for (final ForecastPlace fPlace : placesList) {
            ForecastQueryRegistry currentQuery = forecastQueryRegistryManager
                    .getLastForecastQueryRegistryByPlace(fPlace);
            if (currentQuery == null) {
                return fPlace;
            } else if (targetQuery == null) {
                targetQuery = currentQuery;
            } else if (currentQuery.getTimeInMillis() < targetQuery.getTimeInMillis()) {
                targetQuery = currentQuery;
            }
        }
        if (targetQuery != null) {
            return targetQuery.getForecastPlace();
        } else {
            throw new ExceptionReadForecastPlace();
        }
    }
}
