package es.agustruiz.solarforecast.service;

import es.agustruiz.solarforecast.bean.OpenWeatherMapBean;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class ForecastService {

    protected static final String LOG_TAG = ForecastService.class.getName();

    @Autowired
    LogLineManager logManager;
    
    @Autowired
    OpenWeatherMapBean openWeatherMapBean;

    protected static boolean forecastServiceStatus = false;

    // Public methods
    //
    public static boolean getForecastServiceStatus() {
        return forecastServiceStatus;
    }

    public void setForecastServiceStatus(boolean forecastServiceStatus) {
        ForecastService.forecastServiceStatus = forecastServiceStatus;
        notifyStatusToLog();
    }

    public boolean switchForecastServiceStatus() {
        forecastServiceStatus = !forecastServiceStatus;
        notifyStatusToLog();
        return forecastServiceStatus;
    }

    public boolean isForecastServiceOn() {
        return forecastServiceStatus;
    }

    // Private methods
    //
    private void notifyStatusToLog() {
        if (forecastServiceStatus) {
            logManager.i(LOG_TAG, "Forecast service is ON");
        } else {
            logManager.i(LOG_TAG, "Forecast service is OFF");
        }
    }

}
