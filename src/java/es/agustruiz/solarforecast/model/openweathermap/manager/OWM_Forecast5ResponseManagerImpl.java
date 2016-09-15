package es.agustruiz.solarforecast.model.openweathermap.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecast5Response;
import es.agustruiz.solarforecast.model.openweathermap.OWM_Forecast5Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.agustruiz.solarforecast.model.openweathermap.dao.OWM_Forecast5ResponseDAO;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class OWM_Forecast5ResponseManagerImpl implements OWM_Forecast5ResponseManager {

    protected static final String LOG_TAG = OWM_Forecast5ResponseManagerImpl.class.getName();

    @Autowired
    protected OWM_Forecast5ResponseDAO dao;

    @Override
    public void create(OWM_Forecast5Response forecast5Response) throws ExceptionCreateForecast5Response{
        dao.create(forecast5Response);
    }

    @Override
    public OWM_Forecast5Response read(long id) {
        return dao.read(id);
    }

    @Override
    public List<OWM_Forecast5Response> readAll() {
        return dao.readAll();
    }

    @Override
    public void update(OWM_Forecast5Response forecast5Response) {
        dao.update(forecast5Response);
    }

    @Override
    public void delete(OWM_Forecast5Response forecast5Response) {
        dao.delete(forecast5Response);
    }

}
