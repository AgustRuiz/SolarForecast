package es.agustruiz.solarforecast.service.apiClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.agustruiz.solarforecast.bean.OpenWeatherMapBean;
import es.agustruiz.solarforecast.exception.ExceptionCreateForecastQueryRegistry;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.Forecast5ResponseAPI;
import es.agustruiz.solarforecast.model.manager.ForecastPlaceManager;
import es.agustruiz.solarforecast.model.manager.ForecastQueryRegistryManager;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.model.openweathermap.OWM_Forecast5Response;
import es.agustruiz.solarforecast.service.ForecastService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
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

    protected static final String PROVIDER_NAME = OpenWeatherMapBean.FORECAST_PROVIDER_TAG;

    protected UriBuilder uriBuilder = null;

    @Autowired
    LogLineManager log;

    @Autowired
    ForecastService forecastService;

    @Autowired
    ForecastPlaceManager placesManager;
    
    @Autowired
    ForecastQueryRegistryManager queryRegistryManager;

    // Public methods
    //
    public void QueryAllForecasts() {
        if (forecastService.isForecastServiceOn()) {
            log.d(LOG_TAG, "QueryAllForecasts Start");
            List<ForecastPlace> places = placesManager.readAllForecastPlace();
            places.stream().forEach((place) -> {
                log.i(LOG_TAG, String.format("Querying %s...", place.getName()));
                long queryTime = System.currentTimeMillis();
                Forecast5ResponseAPI apiResponse
                        = getForecast5(place.getLatitude(), place.getLongitude());
                if (apiResponse != null) {
                    List<OWM_Forecast5Response> f5ResponseList = new ArrayList<>();
                    apiResponse.getList().stream().forEach((listAPI) -> {
                        f5ResponseList.add(new OWM_Forecast5Response(listAPI));
                    });
                    
                    ForecastQueryRegistry queryRegistry = new ForecastQueryRegistry();
                    queryRegistry.setForecastPlace(place);
                    queryRegistry.setForecastProvider(PROVIDER_NAME);
                    queryRegistry.setTimeInMillis(queryTime);
                    queryRegistry.setOWM_list(f5ResponseList);
                    
                    try {
                        queryRegistryManager.createForecastQueryRegistry(queryRegistry);
                        log.i(LOG_TAG, String.format("Query to %s OK!", place.getName()));
                    } catch (ExceptionCreateForecastQueryRegistry ex) {
                        log.e(LOG_TAG, String.format("Error saving %s forecast!", place.getName()));
                    }
                    
                } else {
                    log.w(LOG_TAG, "Response is null");
                }
            });
        }
    }

    // Protected methods
    //
    protected Forecast5ResponseAPI getForecast5(float latitude, float longitude) {
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
            log.e(LOG_TAG, "Error connecting to API: " + ex.getMessage());
        }

        return (stringResponse == null ? null : objectMapping(stringResponse.toString()));
    }

    private Forecast5ResponseAPI objectMapping(String jsonString) {
        Forecast5ResponseAPI response = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.readValue(jsonString, Forecast5ResponseAPI.class);
        } catch (IOException ex) {
            log.w(LOG_TAG, "Error mapping response: " + ex.toString());
        }
        return response;
    }

}
