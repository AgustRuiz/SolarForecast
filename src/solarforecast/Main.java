package solarforecast;

import service.GetterWeatherForecastRunnable;
import solarforecast.logger.Logger;
import solarforecast.model.api.openweathermap.forecast5.Forecast5Response;
import solarforecast.weatherForecast.apiClients.OpenWeatherMapClient;

/**
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class Main {

    public static final String LOG_TAG = Main.class.getName();

    public static final float TEST_LAT = 37.7874302f;
    public static final float TEST_LON = -3.7775753f;

    protected static Thread serviceThread;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Logger.d(LOG_TAG, "The start");
        addShutdownHook();

        GetterWeatherForecastRunnable getterRunnable = new GetterWeatherForecastRunnable();

        serviceThread = new Thread(getterRunnable);
        serviceThread.start();

        Logger.d(LOG_TAG, "The end");

    }

    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                Logger.i(LOG_TAG, "Stop program");
                try {
                    serviceThread.stop();
                } catch (Exception ignored) {
                }
            }
        }));
    }

}
