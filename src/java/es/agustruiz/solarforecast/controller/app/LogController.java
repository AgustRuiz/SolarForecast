/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.agustruiz.solarforecast.controller.app;

import es.agustruiz.solarforecast.model.LogLine;
import es.agustruiz.solarforecast.service.MyLogger;
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
        
        List<LogLine> logList = MyLogger.getLog();
        
        model.addAttribute("logList", logList);
        
        return ("log");
    }
}
