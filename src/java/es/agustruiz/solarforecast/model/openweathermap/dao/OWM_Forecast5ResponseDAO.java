package es.agustruiz.solarforecast.model.openweathermap.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateOWMForecast5Response;
import es.agustruiz.solarforecast.model.openweathermap.OWM_Forecast5Response;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface OWM_Forecast5ResponseDAO {

    void create(OWM_Forecast5Response forecast5Response) throws ExceptionCreateOWMForecast5Response;

    OWM_Forecast5Response read(long id);

    List<OWM_Forecast5Response> readAll();

    void update(OWM_Forecast5Response forecast5Response);

    void delete(OWM_Forecast5Response forecast5Response);

}
