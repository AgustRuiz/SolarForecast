package es.agustruiz.solarforecast.bean;

import es.agustruiz.solarforecast.model.ForecastPlace;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class WeatherForecastBean {

    private static final String LOG_TAG = WeatherForecastBean.class.getName();
    
    private static Map<Long, ForecastPlace> placesList = null;
    
    public WeatherForecastBean() {
        //MyLogger.getInstance().d(LOG_TAG, "Starting bean...");
        placesList = new HashMap<>();
    }

    public static Map<Long, ForecastPlace> getPlacesList() {
        return placesList;
    }

    public static void setPlacesList(Map<Long, ForecastPlace> placesList) {
        WeatherForecastBean.placesList = placesList;
    }
    
    public static void addPlacesList(ForecastPlace newForecastPlace) {
        WeatherForecastBean.placesList.put(newForecastPlace.getId(), newForecastPlace);
    }
    
    public static void scheduledTask(){
        //MyLogger.getInstance().i(LOG_TAG, "Scheduled task");
    }
    
}
