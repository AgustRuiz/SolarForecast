package es.agustruiz.solarforecast.controller;

import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Controller
public class DefaultController {

    private static final String LOG_TAG = DefaultController.class.getName();
    
    @Autowired
    protected LogLineManager logLineManager;
    
    @Autowired
    protected ForecastService forecastService;

    @RequestMapping(value = "/startForecastService", method = RequestMethod.GET)
    public String startForecastService(Model model) {
        logLineManager.i(LOG_TAG, "Start forecast service");
        forecastService.setForecastServiceStatus(true);
        //return index(model);
        return "redirect:/home";
    }

    @RequestMapping(value = "/stopForecastService", method = RequestMethod.GET)
    public String stopForecastService(Model model) {
        logLineManager.i(LOG_TAG, "Stop forecast service");
        forecastService.setForecastServiceStatus(false);
        //return index(model);
        return "redirect:/home";
    }

}
