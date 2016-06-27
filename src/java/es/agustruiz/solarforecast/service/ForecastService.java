package es.agustruiz.solarforecast.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class ForecastService {
    
    private static final String LOG_TAG = ForecastService.class.getName();
    
    static boolean forecastServiceStatus = false;

    public static boolean getForecastServiceStatus() {
        return forecastServiceStatus;
    }

    public void setForecastServiceStatus(boolean forecastServiceStatus) {
        ForecastService.forecastServiceStatus = forecastServiceStatus;
    }

    public boolean switchForecastServiceStatus() {
        forecastServiceStatus = !forecastServiceStatus;
        return forecastServiceStatus;
    }
    
}
