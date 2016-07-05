package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastProvider;
import es.agustruiz.solarforecast.exception.ExceptionUpdateForecastProvider;
import es.agustruiz.solarforecast.model.ForecastProvider;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface ForecastProviderManager {

    void create(ForecastProvider forecastProvider) throws ExceptionCreateForecastProvider;

    ForecastProvider readById(long id);

    ForecastProvider readByName(String providerName);

    List<ForecastProvider> readAll();

    void update(ForecastProvider forecastProvider) throws ExceptionUpdateForecastProvider;

//    void delete(ForecastProvider forecastProvider);
}
