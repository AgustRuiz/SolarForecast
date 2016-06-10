package es.agustruiz.solarforecast;

import es.agustruiz.solarforecast.persistence.DatabaseManager;
import es.agustruiz.solarforecast.service.GetterWeatherForecastRunnable;
import es.agustruiz.solarforecast.logger.MyLogger;

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
        MyLogger.d(LOG_TAG, "The start");
        addShutdownHook();

        GetterWeatherForecastRunnable getterRunnable = new GetterWeatherForecastRunnable();

        serviceThread = new Thread(getterRunnable);
        serviceThread.start();
        
        DatabaseManager databaseManager = new DatabaseManager();

        MyLogger.d(LOG_TAG, "The end");

    }

    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                MyLogger.i(LOG_TAG, "Stop program");
                try {
                    serviceThread.stop();
                } catch (Exception ignored) {
                }
            }
        }));
    }

}
