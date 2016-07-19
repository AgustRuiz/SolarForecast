package es.agustruiz.solarforecast.service.apiClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.Forecast5ResponseAPI;
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

    public Forecast5ResponseAPI getForecast5(float latitude, float longitude) {
        UriBuilder builder = UriBuilder.fromUri(URL_BASE);
        builder.scheme(URL_SCHEME);
        builder.path(FORECAST5_PATH);
        builder.queryParam(FORECAST5_PARAM_LAT, latitude);
        builder.queryParam(FORECAST5_PARAM_LON, longitude);
        builder.queryParam(FORECAST5_PARAM_KEY, OPENWEATHERMAP_KEY);
        URI uri = builder.build();

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
            //logLineManager.d(LOG_TAG, "Response OK");
        } catch (IOException ex) {
            logLineManager.e(LOG_TAG, "Error connecting to API: " + ex.getMessage());
        }

        return (stringResponse == null ? null : objectMapping(stringResponse.toString()));
    }

    private Forecast5ResponseAPI objectMapping(String jsonString) {
        Forecast5ResponseAPI response = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.readValue(jsonString, Forecast5ResponseAPI.class);
        } catch (IOException ex) {
            logLineManager.w(LOG_TAG, "Error mapping response: " + ex.toString());
        }
        return response;
    }

}
