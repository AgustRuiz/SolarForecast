/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solarforecast.weatherForecast.apiClients;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.util.logging.Level;
import javax.ws.rs.core.UriBuilder;
import solarforecast.logger.Logger;
import solarforecast.model.api.openweathermap.OpenWeatherMapResponse;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class OpenWeatherMapClient {

    public static final String LOG_TAG = OpenWeatherMapClient.class.getName();

    private static final String OPENWEATHERMAP_KEY = ApiKeys.OPENWEATHERMAP_KEY;

    //Example: http://api.openweathermap.org/data/2.5/forecast?lat=35&lon=139&appid=b1b15e88fa797225412429c1c50c122a
    private static final String URL_BASE = "http://api.openweathermap.org";
    private static final String URL_PATH = "data/2.5/forecast";
    private static final String URL_SCHEME = "http";
    private static final String PARAM_LAT = "lat";
    private static final String PARAM_LON = "lon";
    private static final String PARAM_KEY = "appid";

    /**
     * Constructor
     */
    public OpenWeatherMapClient() {
        Logger.d(LOG_TAG, "Initialize");
    }

    public String getForecast(float latitude, float longitude) {
        Logger.d(LOG_TAG, "Getting forecast...");

        UriBuilder uriBuilder = UriBuilder.fromUri(URL_BASE)
                //.scheme(URL_SCHEME)
                .path(URL_PATH);
        uriBuilder.queryParam(PARAM_LAT, latitude);
        uriBuilder.queryParam(PARAM_LON, longitude);
        uriBuilder.queryParam(PARAM_KEY, OPENWEATHERMAP_KEY);
        URI uri = uriBuilder.build();

        URLConnection connection;
        StringBuilder response = null;
        try {
            connection = uri.toURL().openConnection();
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()))) {
                response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
        } catch (IOException ex) {
            Logger.d(LOG_TAG, "Error connecting to API");
            //java.util.logging.Logger.getLogger(OpenWeatherMapClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.i(LOG_TAG, "Get forecast finished");
        return (response == null ? null : response.toString());
    }

    public OpenWeatherMapResponse objectMapping(String jsonString) {
        OpenWeatherMapResponse response = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.readValue(jsonString, OpenWeatherMapResponse.class);
            Logger.i(LOG_TAG, "Object mapped");
        } catch (IOException ex) {
            Logger.e(LOG_TAG, "Error mapping response");
            java.util.logging.Logger.getLogger(OpenWeatherMapClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
