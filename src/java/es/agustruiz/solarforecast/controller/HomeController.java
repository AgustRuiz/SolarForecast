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
public class HomeController {

    private static final String LOG_TAG = HomeController.class.getName();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Home");
        model.addAttribute("navActiveItem", "home");
        model.addAttribute("serviceStatusTitle", "Service status");

        model.addAttribute("forecastServiceStatusLabel", "ForecastService");
        if (ForecastService.getForecastServiceStatus()) {
            model.addAttribute("forecastServiceStatusValue", "Server is running");
            model.addAttribute("forecastServiceStatusClass", "success");
            model.addAttribute("forecastServiceBtnLabel", "Stop service");
            model.addAttribute("btnForecastServiceUrl", "/stopForecastService");
        } else {
            model.addAttribute("forecastServiceStatusValue", "Server is not running");
            model.addAttribute("forecastServiceStatusClass", "danger");
            model.addAttribute("forecastServiceBtnLabel", "Start service");
            model.addAttribute("btnForecastServiceUrl", "/startForecastService");
        }
        return ("home");
    }
}
