package solarforecast;

import solarforecast.logger.Logger;
import solarforecast.model.api.openweathermap.OpenWeatherMapResponse;
import solarforecast.weatherForecast.apiClients.OpenWeatherMapClient;

/**
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class Main {

    public static final String LOG_TAG = Main.class.getName();

    private static final float TEST_LAT = 37.7874302f;
    private static final float TEST_LON = -3.7775753f;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Logger.d(LOG_TAG, "Initialize");
        addShutdownHook();

        OpenWeatherMapClient openWheatherMapClient = new OpenWeatherMapClient();
        String rawString = openWheatherMapClient.getForecast(TEST_LAT, TEST_LON);

        OpenWeatherMapResponse openWeatherMapResponse = null;

        if (rawString != null) {
            openWeatherMapResponse = openWheatherMapClient.objectMapping(rawString);
        } else {

        }

        while (true) {
        }

    }

    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                Logger.d(LOG_TAG, "Finalize");
            }
        }));
    }

}
