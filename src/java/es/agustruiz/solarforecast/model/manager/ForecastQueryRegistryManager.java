package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastQueryRegistry;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface ForecastQueryRegistryManager {

    void createForecastQueryRegistry(ForecastQueryRegistry forecastQueryRegistry) throws ExceptionCreateForecastQueryRegistry;

    ForecastQueryRegistry getLastForecastQueryRegistryByPlace(ForecastPlace forecastPlace);

}
