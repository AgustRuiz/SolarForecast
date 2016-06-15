package es.agustruiz.solarforecast.bean;

import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.service.MyLogger;
import static java.time.Clock.fixed;
import java.util.HashMap;
import java.util.Map;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@EnableScheduling
public class WeatherForecastBean {

    private static final String LOG_TAG = WeatherForecastBean.class.getName();
    
    private static Map<Long, ForecastPlace> placesList = null;
    
    public WeatherForecastBean() {
        MyLogger.d(LOG_TAG, "Starting bean...");
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
    
    @Scheduled(fixedRate = 5000)
    public static void scheduledTask(){
        MyLogger.i(LOG_TAG, "Scheduled task");
    }
    
    
}
