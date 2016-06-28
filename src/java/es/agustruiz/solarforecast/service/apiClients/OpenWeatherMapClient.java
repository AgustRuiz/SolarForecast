package es.agustruiz.solarforecast.service.apiClients;

import es.agustruiz.solarforecast.model.manager.LogLineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import javax.ws.rs.core.UriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class OpenWeatherMapClient {

    protected static final String LOG_TAG = OpenWeatherMapClient.class.getName();

    protected static final String OPENWEATHERMAP_KEY = ApiKeys.OPENWEATHERMAP_KEY;

    protected static final String URL_BASE = "http://api.openweathermap.org";
    protected static final String URL_SCHEME = "http";

    protected static final String FORECAST5_PATH = "data/2.5/forecast";
    protected static final String FORECAST5_PARAM_LAT = "lat";
    protected static final String FORECAST5_PARAM_LON = "lon";
    protected static final String FORECAST5_PARAM_KEY = "appid";

    protected UriBuilder uriBuilder = null;

    @Autowired
    LogLineManager logLineManager;

    public String getForecast5(float latitude, float longitude) {
        UriBuilder uriBuilder = UriBuilder.fromUri(URL_BASE);
        uriBuilder.scheme(URL_SCHEME);
        uriBuilder.path(FORECAST5_PATH);
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
            logLineManager.e(LOG_TAG, "Error connecting to API");
        }

        if (stringResponse == null) {
            logLineManager.d(LOG_TAG, "Response is null");
            return null;
        } else {
            logLineManager.d(LOG_TAG, "Response OK");
            return stringResponse.toString();
        }
    }

//    private Forecast5Response objectMapping(String jsonString) {
//        Forecast5Response response = null;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            response = mapper.readValue(jsonString, Forecast5Response.class);
//            //Logger.i(LOG_TAG, "Object mapped");
//        } catch (IOException ex) {
//            MyLogger.e(LOG_TAG, "Error mapping response: " + ex.toString());
//            //java.util.logging.Logger.getLogger(OpenWeatherMapClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return response;
//    }
    
}
