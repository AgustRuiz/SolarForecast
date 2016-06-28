package es.agustruiz.solarforecast.controller;

import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.model.LogLine;
import java.util.ArrayList;
import java.util.List;
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
    protected LogLineManager logLineManager;

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String log(Model model) {
        return "redirect:/log/1";
    }

    @RequestMapping(value = "/log/{pageNumber}", method = RequestMethod.GET)
    public String log(@PathVariable Integer pageNumber, Model model) {
        model = configureModel(model);
        model.addAttribute("title", "Log");
        model.addAttribute("currentPage", pageNumber);

        int numRows = logLineManager.countRows();
        int numPages = (int) Math.ceil((double) numRows / (double) ROWS_PER_PAGE);

        int newerPage = pageNumber - 1;
        int olderPage = pageNumber + 1;

        model.addAttribute("newerPage", newerPage);
        model.addAttribute("olderPage", olderPage);
        model.addAttribute("numPages", numPages);

        model.addAttribute("logList", logLineManager.getLogPage(pageNumber, ROWS_PER_PAGE));
        return ("log");
    }

    private Model configureModel(Model model) {
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Log");
        model.addAttribute("navActiveItem", "log");
        return model;
    }

}
