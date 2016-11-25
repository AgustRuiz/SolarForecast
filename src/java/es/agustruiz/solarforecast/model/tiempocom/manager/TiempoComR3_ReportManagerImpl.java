package es.agustruiz.solarforecast.model.tiempocom.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateTiempoComR3Report;
import es.agustruiz.solarforecast.model.tiempocom.TiempoComR3_Report;
import es.agustruiz.solarforecast.model.tiempocom.dao.TiempoComR3_ReportDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class TiempoComR3_ReportManagerImpl implements TiempoComR3_ReportManager {

    protected static final String LOG_TAG = TiempoComR3_ReportManagerImpl.class.getName();

    @Autowired
    protected TiempoComR3_ReportDAO dao;

    @Override
    public void create(TiempoComR3_Report report) throws ExceptionCreateTiempoComR3Report {
        dao.create(report);
    }

    @Override
    public TiempoComR3_Report read(long id) {
        return dao.read(id);
    }

    @Override
    public List<TiempoComR3_Report> readAll() {
        return dao.readAll();
    }

    @Override
    public void update(TiempoComR3_Report report) {
        dao.update(report);
    }

    @Override
    public void delete(TiempoComR3_Report report) {
        dao.delete(report);
    }

}
