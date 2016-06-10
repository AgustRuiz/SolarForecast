package es.agustruiz.solarforecast.service.timertask;

import java.util.TimerTask;
import static es.agustruiz.solarforecast.Main.TEST_LAT;
import static es.agustruiz.solarforecast.Main.TEST_LON;
import es.agustruiz.solarforecast.logger.MyLogger;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.Forecast5Response;
import es.agustruiz.solarforecast.weatherForecast.apiClients.OpenWeatherMapClient;

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
        MyLogger.i(LOG_TAG, "Getting forecast5...");
        Forecast5Response response = client.getForecast5(TEST_LAT, TEST_LON);
        if (response != null) {
            MyLogger.i(LOG_TAG, "Forecast5 OK");
        } else {
            MyLogger.w(LOG_TAG, "Forecast5 returned null response");
        }
    }

}
