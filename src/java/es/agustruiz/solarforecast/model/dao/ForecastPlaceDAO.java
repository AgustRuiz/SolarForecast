package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastPlace;
import es.agustruiz.solarforecast.exception.ExceptionDeleteForecastPlace;
import es.agustruiz.solarforecast.model.ForecastPlace;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface ForecastPlaceDAO {

    void createForecastPlace(ForecastPlace forecastPlace) throws ExceptionCreateForecastPlace;

    ForecastPlace readForecastPlace(Long id);

    List<ForecastPlace> readAllForecastPlace();

    void deleteForecastPlace(ForecastPlace forecastPlace) throws ExceptionDeleteForecastPlace;
}
