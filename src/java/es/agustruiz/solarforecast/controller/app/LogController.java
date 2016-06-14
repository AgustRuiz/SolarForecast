/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.agustruiz.solarforecast.controller.app;

import es.agustruiz.solarforecast.model.LogLine;
import es.agustruiz.solarforecast.service.ForecastService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Controller
public class LogController {
    
    public static final String LOG_TAG = LogController.class.getName();
    
    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String log(Model model) {
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Log");
        model.addAttribute("navActiveItem", "log");
        
        List<LogLine> logList = new ArrayList<>();
        logList.add(new LogLine(LOG_TAG, LogLine.DEBUG, "First debug test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.DEBUG, "Second debug test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.INFO, "First info test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.INFO, "Second info test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.INFO, "Third info test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.WARNING, "First warning test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.WARNING, "Second warning test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.WARNING, "Third warning test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.WARNING, "Forth warning test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.ERROR, "First danger test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.ERROR, "Second danger test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.ERROR, "Third danger test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.ERROR, "Forth danger test line"));
        logList.add(new LogLine(LOG_TAG, LogLine.ERROR, "Fifth danger test line"));
        
        model.addAttribute("logList", logList);
        
        return ("log");
    }
}
