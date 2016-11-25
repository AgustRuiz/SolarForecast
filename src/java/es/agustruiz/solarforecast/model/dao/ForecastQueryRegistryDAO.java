package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastQueryRegistry;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastProvider;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface ForecastQueryRegistryDAO {

    void createForecastQueryRegistry(ForecastQueryRegistry forecastRegistry) throws ExceptionCreateForecastQueryRegistry;

    ForecastQueryRegistry getLastForecastQueryRegistryByPlace(ForecastPlace forecastPlace);

//    ForecastQueryRegistry readForecastQueryRegistry(Long id);
    
//    List<ForecastQueryRegistry> readAllForecastQueryRegistry();
    
    int countByProvider(String forecastProvider);
    
    List<ForecastQueryRegistry> readAllByPlaceAndProvider(ForecastPlace place, ForecastProvider provider);

}
