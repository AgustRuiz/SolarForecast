package service.timertask;

import java.util.TimerTask;
import static solarforecast.Main.TEST_LAT;
import static solarforecast.Main.TEST_LON;
import solarforecast.logger.Logger;
import solarforecast.model.api.openweathermap.forecast5.Forecast5Response;
import solarforecast.weatherForecast.apiClients.OpenWeatherMapClient;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class OpenWeatherMapForecast5 extends TimerTask {

    public static final String LOG_TAG = OpenWeatherMapForecast5.class.getName();

    OpenWeatherMapClient client;

    public OpenWeatherMapForecast5() {
        client = new OpenWeatherMapClient();
    }

    @Override
    public void run() {
        Logger.i(LOG_TAG, "Getting forecast5...");
        Forecast5Response response = client.getForecast5(TEST_LAT, TEST_LON);
        if (response != null) {
            Logger.i(LOG_TAG, "Forecast5 OK");
        } else {
            Logger.w(LOG_TAG, "Forecast5 returned null response");
        }
    }

}
