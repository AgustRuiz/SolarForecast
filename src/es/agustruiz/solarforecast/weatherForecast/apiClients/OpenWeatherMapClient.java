package es.agustruiz.solarforecast.weatherForecast.apiClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.util.logging.Level;
import javax.ws.rs.core.UriBuilder;
import es.agustruiz.solarforecast.logger.MyLogger;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.Forecast5Response;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class OpenWeatherMapClient {

    // Max: 60 queries per minute
    
    public static final String LOG_TAG = OpenWeatherMapClient.class.getName();

    private static final String OPENWEATHERMAP_KEY = ApiKeys.OPENWEATHERMAP_KEY;

    //Example: http://api.openweathermap.org/data/2.5/forecast?lat=35&lon=139&appid=b1b15e88fa797225412429c1c50c122a
    private static final String URL_BASE = "http://api.openweathermap.org";
    private static final String URL_SCHEME = "http";

    public static final Long FORECAST5_PERIOD_MILLIS = 1 * 30 * 1000L;
    private static final String FORECAST5_PATH = "data/2.5/forecast";
    private static final String FORECAST5_PARAM_LAT = "lat";
    private static final String FORECAST5_PARAM_LON = "lon";
    private static final String FORECAST5_PARAM_KEY = "appid";

    UriBuilder uriBuilder = null;

    /**
     * Constructor
     */
    public OpenWeatherMapClient() {
        MyLogger.d(LOG_TAG, "Initialize");
    }

    public Forecast5Response getForecast5(float latitude, float longitude) {
        UriBuilder uriBuilder = UriBuilder.fromUri(URL_BASE)
                //.scheme(URL_SCHEME)
                .path(FORECAST5_PATH);
        uriBuilder.queryParam(FORECAST5_PARAM_LAT, latitude);
        uriBuilder.queryParam(FORECAST5_PARAM_LON, longitude);
        uriBuilder.queryParam(FORECAST5_PARAM_KEY, OPENWEATHERMAP_KEY);
        URI uri = uriBuilder.build();

        URLConnection connection;
        StringBuilder stringResponse = null;
        try {
            connection = uri.toURL().openConnection();
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()))) {
                stringResponse = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    stringResponse.append(inputLine);
                }
            }
        } catch (IOException ex) {
            MyLogger.e(LOG_TAG, "Error connecting to API");
            //java.util.logging.Logger.getLogger(OpenWeatherMapClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Logger.i(LOG_TAG, "Get forecast finished");
        return (stringResponse == null ? null : objectMapping(stringResponse.toString()));
    }

    private Forecast5Response objectMapping(String jsonString) {
        Forecast5Response response = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.readValue(jsonString, Forecast5Response.class);
            //Logger.i(LOG_TAG, "Object mapped");
        } catch (IOException ex) {
            MyLogger.e(LOG_TAG, "Error mapping response: " + ex.toString());
            //java.util.logging.Logger.getLogger(OpenWeatherMapClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
