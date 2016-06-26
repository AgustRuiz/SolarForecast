package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.model.LogLine;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface LogLineManager {
    
    void d(String from, String message);
    void i(String from, String message);
    void w(String from, String message);
    void e(String from, String message);
    List<LogLine> getLog();
    List<LogLine> getLogPage(int pageNumber, int rowsPerPage);
    int countRows();
    
}
