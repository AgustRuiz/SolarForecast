package es.agustruiz.solarforecast.controller;

import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.service.ForecastService;
import javax.servlet.http.HttpServletRequest;
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
        forecastService.setForecastServiceStatus(true);
        return "redirect:/home";
    }

    @RequestMapping(value = "/stopForecastService", method = RequestMethod.GET)
    public String stopForecastService(Model model) {
        forecastService.setForecastServiceStatus(false);
        return "redirect:/home";
    }

    @RequestMapping(value = "/quickStartForecastService", method = RequestMethod.GET)
    public String quickStartForecastService(HttpServletRequest request) {
        forecastService.setForecastServiceStatus(true);
    String referer = request.getHeader("Referer");
    return "redirect:"+ referer;
    }
    
    @RequestMapping(value = "/quickStopForecastService", method = RequestMethod.GET)
    public String quickStopForecastService(HttpServletRequest request) {
        forecastService.setForecastServiceStatus(false);
    String referer = request.getHeader("Referer");
    return "redirect:"+ referer;
    }

}
