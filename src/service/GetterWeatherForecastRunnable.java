package service;

import java.util.Timer;
import java.util.TimerTask;
import service.timertask.OpenWeatherMapForecast5;
import solarforecast.logger.Logger;
import solarforecast.weatherForecast.apiClients.OpenWeatherMapClient;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class GetterWeatherForecastRunnable implements Runnable {

    public static final String LOG_TAG = GetterWeatherForecastRunnable.class.getName();
    
    protected Timer timer;
    protected OpenWeatherMapForecast5 openWeatherMapForecast5;

    public GetterWeatherForecastRunnable() {
        timer = new Timer();
        openWeatherMapForecast5 = new OpenWeatherMapForecast5();
    }
    
    @Override
    public void run() {
        timer.schedule(openWeatherMapForecast5, 0, OpenWeatherMapClient.FORECAST5_PERIOD_MILLIS);
    }
    
}
