package es.agustruiz.solarforecast.service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class ForecastService {
    
    private static final String LOG_TAG = ForecastService.class.getName();
    
    static boolean forecastServiceStatus = false;

    public static boolean getForecastServiceStatus() {
        return forecastServiceStatus;
    }

    public static void setForecastServiceStatus(boolean forecastServiceStatus) {
        ForecastService.forecastServiceStatus = forecastServiceStatus;
    }

    public static boolean switchForecastServiceStatus() {
        forecastServiceStatus = !forecastServiceStatus;
        return forecastServiceStatus;
    }
    
}
