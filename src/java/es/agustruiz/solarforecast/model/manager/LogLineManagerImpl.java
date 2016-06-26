package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.model.dao.LogLineDAO;
import es.agustruiz.solarforecast.model.LogLine;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class LogLineManagerImpl implements LogLineManager {

    protected static final String LOG_TAG = LogLineManagerImpl.class.getName();
    
    protected static final int PAGE_SIZE = 10;

    @Autowired
    protected LogLineDAO logLineDAO;

    @Transactional
    @Override
    public void d(String from, String message) {
        addLine(new LogLine(from, LogLine.DEBUG, message));
    }

    @Transactional
    @Override
    public void i(String from, String message) {
        
        addLine(new LogLine(from, LogLine.INFO, message));
    }

    @Transactional
    @Override
    public void w(String from, String message) {
        addLine(new LogLine(from, LogLine.WARNING, message));
    }

    @Transactional
    @Override
    public void e(String from, String message) {
        addLine(new LogLine(from, LogLine.ERROR, message));
    }

    @Override
    public List<LogLine> getLog() {
        return logLineDAO.readAllLogLine();
    }
    
    @Override
    public List<LogLine> getLogPage(int pageNumber, int rowsPerPage) {
        return logLineDAO.readLogLine(pageNumber, rowsPerPage);
    }

    @Override
    public int countRows() {
        return logLineDAO.count();
    }
    
    private void addLine(LogLine line) {
        logLineDAO.createLogLine(line);
    }

}
