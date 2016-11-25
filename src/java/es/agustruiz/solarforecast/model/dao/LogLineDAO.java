package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateLogLine;
import es.agustruiz.solarforecast.exception.ExceptionDeleteLogLine;
import es.agustruiz.solarforecast.model.LogLine;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface LogLineDAO {

    void createLogLine(LogLine logLine) throws ExceptionCreateLogLine;

    LogLine readLogLine(Long id);

    List<LogLine> readLogLine(int pageNumber, int rowsPerPage);

    List<LogLine> readAllLogLine();

    int count();

    void cleanLogLine() throws ExceptionDeleteLogLine;
//    void updateLogLine(LogLine logLine);
//    void deleteLogLine(LogLine logLine);

}
