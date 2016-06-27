package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionDeleteForecastPlace;
import es.agustruiz.solarforecast.model.ForecastPlace;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface ForecastPlaceManager {
    
    void createForecastPlace(ForecastPlace forecastPlace);
    List<ForecastPlace> readAllForecastPlace();
    ForecastPlace readForecastPlace(long id);
    void deleteForecastPlace(ForecastPlace forecastPlace) throws ExceptionDeleteForecastPlace;
    
}
