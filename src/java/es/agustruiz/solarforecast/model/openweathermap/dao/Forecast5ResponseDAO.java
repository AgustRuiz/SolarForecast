package es.agustruiz.solarforecast.model.openweathermap.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecast5Response;
import es.agustruiz.solarforecast.model.openweathermap.Forecast5Response;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface Forecast5ResponseDAO {

    void create(Forecast5Response forecast5Response) throws ExceptionCreateForecast5Response;

    Forecast5Response read(long id);

    List<Forecast5Response> readAll();

    void update(Forecast5Response forecast5Response);

    void delete(Forecast5Response forecast5Response);

}
