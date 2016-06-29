package es.agustruiz.solarforecast.model.openweathermap.manager;

import es.agustruiz.solarforecast.model.openweathermap.Forecast5Response;
import es.agustruiz.solarforecast.model.openweathermap.dao.Forecast5ResponseDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class Forecast5ResponseManagerImpl implements Forecast5ResponseManager {

    protected static final String LOG_TAG = Forecast5ResponseManagerImpl.class.getName();

    @Autowired
    protected Forecast5ResponseDAO dao;

    @Override
    public void create(Forecast5Response forecast5Response) {
        dao.create(forecast5Response);
    }

    @Override
    public Forecast5Response read(long id) {
        return dao.read(id);
    }

    @Override
    public List<Forecast5Response> readAll() {
        return dao.readAll();
    }

    @Override
    public void update(Forecast5Response forecast5Response) {
        dao.update(forecast5Response);
    }

    @Override
    public void delete(Forecast5Response forecast5Response) {
        dao.delete(forecast5Response);
    }

}
