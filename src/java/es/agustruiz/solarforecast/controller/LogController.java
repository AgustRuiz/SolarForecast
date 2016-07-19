package es.agustruiz.solarforecast.controller;

import es.agustruiz.solarforecast.exception.ExceptionDeleteLogLine;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.model.LogLine;
import es.agustruiz.solarforecast.service.ForecastService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Controller
public class LogController {

    protected static final String LOG_TAG = LogController.class.getName();

    protected static final int ROWS_PER_PAGE = 25;

    protected static List<LogLine> logList;

    @Autowired
    protected ForecastService forecastService;

    @Autowired
    protected LogLineManager logManager;

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String log(Model model) {
        return "redirect:/log/1";
    }

    @RequestMapping(value = "/log/{pageNumber}", method = RequestMethod.GET)
    public String log(@PathVariable Integer pageNumber, Model model) {
        model = configureModel(model);
        model.addAttribute("title", "Log");
        model.addAttribute("currentPage", pageNumber);

        int numRows = logManager.countRows();
        int numPages = (int) Math.ceil((double) numRows / (double) ROWS_PER_PAGE);

        int newerPage = pageNumber - 1;
        int olderPage = pageNumber + 1;

        model.addAttribute("newerPage", newerPage);
        model.addAttribute("olderPage", olderPage);
        model.addAttribute("numPages", numPages);

        model.addAttribute("logList", logManager.getLogPage(pageNumber, ROWS_PER_PAGE));
        return ("log");
    }

    @RequestMapping(value = "/log/clean", method = RequestMethod.GET)
    public String cleanLog(Model model) {
        try {
            logManager.cleanLog();
            logManager.w(LOG_TAG, "Log cleaned");
        } catch (ExceptionDeleteLogLine ex) {
            Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
            logManager.w(LOG_TAG, "Can't clean log");
        }
        return "redirect:/log/1";
    }

    private Model configureModel(Model model) {
        model.addAttribute("forecastServiceStatus", forecastService.isForecastServiceOn());
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Log");
        model.addAttribute("navActiveItem", "log");
        return model;
    }

}
