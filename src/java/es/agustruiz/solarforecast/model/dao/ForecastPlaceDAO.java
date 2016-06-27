package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.model.ForecastPlace;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface ForecastPlaceDAO {
    void createForecastPlace(ForecastPlace forecastPlace);
    ForecastPlace readForecastPlace(Long id);
    List<ForecastPlace> readAllForecastPlace();
    int count();
    void updateLogLine(ForecastPlace forecastPlace);
    void deleteLogLine(ForecastPlace forecastPlace);
}
