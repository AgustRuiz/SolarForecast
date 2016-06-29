package es.agustruiz.solarforecast.model.openweathermap.manager;

import es.agustruiz.solarforecast.model.openweathermap.Forecast5Response;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface Forecast5ResponseManager {

    void create(Forecast5Response forecast5Response);

    Forecast5Response read(long id);

    List<Forecast5Response> readAll();

    void update(Forecast5Response forecast5Response);

    void delete(Forecast5Response forecast5Response);

}
