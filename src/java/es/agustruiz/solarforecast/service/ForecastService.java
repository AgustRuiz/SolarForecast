package es.agustruiz.solarforecast.service;

import es.agustruiz.solarforecast.model.manager.LogLineManager;
import java.util.Map;
import java.util.TreeMap;
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

    protected static boolean forecastServiceStatus = false;

    protected static final Map<Integer, String> QUERY_FREQUENCY_MAP;

    static {
        QUERY_FREQUENCY_MAP = new TreeMap<>();
        QUERY_FREQUENCY_MAP.put(1000, "1 second (only for testing)");
        QUERY_FREQUENCY_MAP.put(10000, "10 seconds (only for testing)");
        QUERY_FREQUENCY_MAP.put(15000, "15 seconds (only for testing)");
        QUERY_FREQUENCY_MAP.put(60000, "60 seconds (only for testing)");
        QUERY_FREQUENCY_MAP.put(600000, "10 minutes");
        QUERY_FREQUENCY_MAP.put(900000, "15 minutes");
        QUERY_FREQUENCY_MAP.put(1800000, "30 minutes");
        QUERY_FREQUENCY_MAP.put(2700000, "45 minutes");
        QUERY_FREQUENCY_MAP.put(3600000, "1 hour");
        QUERY_FREQUENCY_MAP.put(7200000, "2 hours");
        QUERY_FREQUENCY_MAP.put(10800000, "3 hours");
        QUERY_FREQUENCY_MAP.put(21600000, "6 hours");
        QUERY_FREQUENCY_MAP.put(43200000, "12 hours");
        QUERY_FREQUENCY_MAP.put(86400000, "24 hours");
    }

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
    
    public static Map<Integer, String> getQUERY_FREQUENCY_MAP(){
        return QUERY_FREQUENCY_MAP;
    }
    
    public static Integer getDefaultQueryFrequency(){
        return 3600000; // 1 hour
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
