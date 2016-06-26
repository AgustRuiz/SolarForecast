package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.model.LogLine;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface LogLineDAO {
    
    void createLogLine(LogLine logLine);
    LogLine readLogLine(Long id);
    List<LogLine> readLogLine(int pageNumber, int rowsPerPage);
    List<LogLine> readAllLogLine();
    int count();
//    void updateLogLine(LogLine logLine);
//    void deleteLogLine(LogLine logLine);
    
}
