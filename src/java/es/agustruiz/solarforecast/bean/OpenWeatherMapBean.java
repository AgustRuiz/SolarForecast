package es.agustruiz.solarforecast.bean;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastProvider;
import es.agustruiz.solarforecast.exception.ExceptionNotValidFrequency;
import es.agustruiz.solarforecast.exception.ExceptionReadForecastPlace;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastProvider;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;
import es.agustruiz.solarforecast.model.manager.ForecastPlaceManager;
import es.agustruiz.solarforecast.model.manager.ForecastProviderManager;
import es.agustruiz.solarforecast.model.manager.ForecastQueryRegistryManager;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.service.ForecastService;
import es.agustruiz.solarforecast.service.apiClients.OpenWeatherMapClient;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class OpenWeatherMapBean {

    protected static final String LOG_TAG = OpenWeatherMapBean.class.getName();

    public static final String FORECAST_PROVIDER_TAG = "OpenWeatherMap";

//    protected static final int MAX_QUERIES_PER_MINUTE = 60;

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

    public int queryFrequency = 0;

    @PostConstruct
    public void prepareForecastProvider() {
        thisProvider = forecastProviderManager.readByName(FORECAST_PROVIDER_TAG);
        if (thisProvider != null) {
            setQueryFrequency(thisProvider.getQueryFrequencyMillis());
        } else {
            try {
                thisProvider = new ForecastProvider(FORECAST_PROVIDER_TAG,
                        ForecastService.getDefaultQueryFrequency());
                forecastProviderManager.create(thisProvider);
                setQueryFrequency(thisProvider.getQueryFrequencyMillis());
            } catch (ExceptionNotValidFrequency | ExceptionCreateForecastProvider ex) {
                logManager.e(LOG_TAG,
                        String.format("Can't create the %s provider: %s",
                                FORECAST_PROVIDER_TAG, ex.getMessage()));
            }
        }
    }

    // Public methods
    //
    public void setQueryFrequency(int queryFrequencyMillis) {
        queryFrequency = queryFrequencyMillis;
        logManager.i(LOG_TAG, "Updated query frequency");
    }
    
    public int getQueryFrequency(){
        return queryFrequency;
    }
    
    public String getForecastProviderTag(){
        return FORECAST_PROVIDER_TAG;
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
