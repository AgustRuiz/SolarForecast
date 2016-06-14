/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.agustruiz.solarforecast.controller.app;

import es.agustruiz.solarforecast.service.ForecastService;
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
    
    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String log(Model model) {
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Log");
        model.addAttribute("navActiveItem", "log");
        return ("log");
    }
}
