package es.agustruiz.solarforecast.controller;

import es.agustruiz.solarforecast.model.ForecastProvider;
import es.agustruiz.solarforecast.model.manager.ForecastProviderManager;
import es.agustruiz.solarforecast.model.manager.ForecastQueryRegistryManager;
import es.agustruiz.solarforecast.service.ForecastService;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
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
public class HomeController {

    private static final String LOG_TAG = HomeController.class.getName();

    @Autowired
    protected ForecastService fService;

    @Autowired
    protected ForecastProviderManager fProviderManager;

    @Autowired
    protected ForecastQueryRegistryManager fQueryRegistryManager;

    // Public methods
    //
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model = configureModel(model);

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

        model.addAttribute("queryFrequencies", ForecastService.getQUERY_FREQUENCY_MAP());

        Map<ForecastProvider, Integer> fProviderMapExtra = new HashMap<>();
        fProviderManager.readAll().stream().forEach((fProvider) -> {
            fProviderMapExtra.put(fProvider,
                    fQueryRegistryManager.countByProvider(fProvider.getProviderName()));
        });

//        model.addAttribute("forecastProviders", fProviderManager.readAll());
        model.addAttribute("forecastProviders", fProviderMapExtra.entrySet());

        return ("home");
    }

    @SuppressWarnings("UnusedAssignment")
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied(Model model, HttpServletRequest request, Principal user) {
        model = configureModel(model, false);

        //if (user != null) {
        //model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
        //} else {
        //model.addObject("msg", "You do not have permission to access this page!");
        //}
        model.addAttribute("msg", "You do not have premission to access this page!");

        //model.setViewName("403");
        return "403";

    }

    // Private methods
    //
    private Model configureModel(Model model) {
        return configureModel(model, true);
    }

    private Model configureModel(Model model, boolean fillActiveItem) {
        model.addAttribute("forecastServiceStatus", fService.isForecastServiceOn());
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Home");
        if (fillActiveItem) {
            model.addAttribute("navActiveItem", "home");
        }
        return model;
    }
}
