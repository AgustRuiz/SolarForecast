package es.agustruiz.solarforecast.bean;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastProvider;
import es.agustruiz.solarforecast.exception.ExceptionNotValidFrequency;
import es.agustruiz.solarforecast.model.ForecastProvider;
import es.agustruiz.solarforecast.model.manager.ForecastPlaceManager;
import es.agustruiz.solarforecast.model.manager.ForecastProviderManager;
import es.agustruiz.solarforecast.model.manager.ForecastQueryRegistryManager;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.service.ForecastService;
import es.agustruiz.solarforecast.service.apiClients.TiempoComClient;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class TiempoComBean {
    
    protected static final String LOG_TAG = TiempoComBean.class.getName();
    
    @Autowired
    LogLineManager log;
    
    @Autowired
    ForecastService fService;
    
    @Autowired
    ForecastPlaceManager fPlaceManager;
    
    @Autowired
    ForecastQueryRegistryManager fQueryRegistryManager;
    
    @Autowired
    ForecastProviderManager fProviderManager;
    
    @Autowired
    TiempoComClient client;

    protected int queryFrequency = 0;
    
    protected static ForecastProvider thisProvider = null;
    
    public static final String FORECAST_PROVIDER_TAG = "TiempoCom";

    @PostConstruct
    public void prepareForecastProvider() {
        thisProvider = fProviderManager.readByName(FORECAST_PROVIDER_TAG);
        if (thisProvider != null) {
            setQueryFrequency(thisProvider.getQueryFrequencyMillis());
        } else {
            try {
                thisProvider = new ForecastProvider(FORECAST_PROVIDER_TAG,
                        ForecastService.getDefaultQueryFrequency());
                fProviderManager.create(thisProvider);
                setQueryFrequency(thisProvider.getQueryFrequencyMillis());
            } catch (ExceptionNotValidFrequency | ExceptionCreateForecastProvider e) {
                log.e(LOG_TAG,String.format("Can't create the %s provider: %s",
                                FORECAST_PROVIDER_TAG, e.getMessage()));
            }
        }
    }

    // Public methods
    //
    public void setQueryFrequency(int queryFrequencyMillis) {
        queryFrequency = queryFrequencyMillis;
        log.i(LOG_TAG, "Updated query frequency");
    }
    
    public int getQueryFrequency(){
        return queryFrequency;
    }
    
    public String getForecastProviderTag(){
        return FORECAST_PROVIDER_TAG;
    }
    
}
