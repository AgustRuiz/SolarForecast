package es.agustruiz.solarforecast.controller.app;

import es.agustruiz.solarforecast.service.ForecastService;
import es.agustruiz.solarforecast.service.MyLogger;
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

    @RequestMapping(value = "/startForecastService", method = RequestMethod.GET)
    public String startForecastService(Model model) {
        MyLogger.i(LOG_TAG, "Start forecast service");
        ForecastService.setForecastServiceStatus(true);
        //return index(model);
        return "redirect:/home";
    }

    @RequestMapping(value = "/stopForecastService", method = RequestMethod.GET)
    public String stopForecastService(Model model) {
        MyLogger.i(LOG_TAG, "Stop forecast service");
        ForecastService.setForecastServiceStatus(false);
        //return index(model);
        return "redirect:/home";
    }

}
