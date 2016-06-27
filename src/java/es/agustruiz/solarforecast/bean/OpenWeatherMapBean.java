package es.agustruiz.solarforecast.bean;

import es.agustruiz.solarforecast.model.manager.LogLineManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class OpenWeatherMapBean {

    protected static final String LOG_TAG = OpenWeatherMapBean.class.getName();

    public static final long FIXED_RATE = 5000L;
    
    protected static final int MAX_QUERIES_PER_MINUTE = 60;
    
//    protected static OpenWeatherMapService instance = null;

    @Autowired
    LogLineManager logLineManager;
    
//    private OpenWeatherMapService(){}
    
//    public static OpenWeatherMapService getInstance(){
//        if(instance == null)
//            instance = new OpenWeatherMapService();
//        return instance;
//    }
    
    public void scheduledTask() {
        logLineManager.w(LOG_TAG, "Beautiful scheduled task");
    }

}
