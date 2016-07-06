package es.agustruiz.solarforecast.service;

import es.agustruiz.solarforecast.bean.OpenWeatherMapBean;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import java.util.HashMap;
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

    protected static final Map<Integer, String> queryFrequencyMap;

    static {
        queryFrequencyMap = new TreeMap<>();
        queryFrequencyMap.put(1000, "1 second (only for testing)");
        queryFrequencyMap.put(10000, "10 seconds (only for testing)");
        queryFrequencyMap.put(15000, "15 seconds (only for testing)");
        queryFrequencyMap.put(600000, "10 minutes");
        queryFrequencyMap.put(900000, "15 minutes");
        queryFrequencyMap.put(1800000, "30 minutes");
        queryFrequencyMap.put(2700000, "45 minutes");
        queryFrequencyMap.put(3600000, "1 hour");
        queryFrequencyMap.put(7200000, "2 hours");
        queryFrequencyMap.put(10800000, "3 hours");
        queryFrequencyMap.put(21600000, "6 hours");
        queryFrequencyMap.put(43200000, "12 hours");
        queryFrequencyMap.put(86400000, "24 hours");
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
    
    public static Map<Integer, String> getQueryFrequencyMap(){
        return queryFrequencyMap;
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
