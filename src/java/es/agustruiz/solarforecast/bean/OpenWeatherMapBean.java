package es.agustruiz.solarforecast.bean;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastQueryRegistry;
import es.agustruiz.solarforecast.exception.ExceptionReadForecastPlace;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.Forecast5ResponseAPI;
import es.agustruiz.solarforecast.model.manager.ForecastPlaceManager;
import es.agustruiz.solarforecast.model.manager.ForecastQueryRegistryManager;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.service.apiClients.OpenWeatherMapClient;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

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
    LogLineManager logLineManager;

    @Autowired
    ForecastPlaceManager forecastPlaceManager;

    @Autowired
    ForecastQueryRegistryManager forecastQueryRegistryManager;

    @Autowired
    OpenWeatherMapClient openWeatherMapClient;

    public void scheduledTask() {
        ForecastPlace fPlace;
        try {
            fPlace = getNextForecastPlaceToQuery();
            ForecastQueryRegistry fQueryRegistry = new ForecastQueryRegistry();
            fQueryRegistry.setTimeInMillis(System.currentTimeMillis());
            fQueryRegistry.setForecastProvider(FORECAST_PROVIDER_TAG);
            fQueryRegistry.setForecastPlace(fPlace);

            forecastQueryRegistryManager.createForecastQueryRegistry(fQueryRegistry);
            Forecast5ResponseAPI response = openWeatherMapClient.getForecast5(fPlace.getLatitude(), fPlace.getLongitude());
            logLineManager.i(LOG_TAG, "Querying place " + fPlace.getId() + "...");
        } catch (ExceptionReadForecastPlace ex) {
            logLineManager.e(LOG_TAG, "Can't read next forecast place to query");
        } catch (ExceptionCreateForecastQueryRegistry ex) {
            logLineManager.e(LOG_TAG, "Can't save forecast for place");
        }
    }

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
