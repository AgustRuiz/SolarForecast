package es.agustruiz.solarforecast.model.tiempocom.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateTiempoComR3Report;
import es.agustruiz.solarforecast.model.tiempocom.TiempoComR3_Report;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface TiempoComR3_ReportManager {
    
    void create(TiempoComR3_Report report) throws ExceptionCreateTiempoComR3Report;

    TiempoComR3_Report read(long id);

    List<TiempoComR3_Report> readAll();

    void update(TiempoComR3_Report report);

    void delete(TiempoComR3_Report report);
    
}
