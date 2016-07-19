package es.agustruiz.solarforecast.controller;

import es.agustruiz.solarforecast.bean.OpenWeatherMapBean;
import es.agustruiz.solarforecast.exception.ExceptionNotValidFrequency;
import es.agustruiz.solarforecast.exception.ExceptionUpdateForecastProvider;
import es.agustruiz.solarforecast.model.ForecastProvider;
import es.agustruiz.solarforecast.model.manager.ForecastProviderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Controller
public class ForecastProviderController {

    protected static final String LOG_TAG = ForecastProviderController.class.getName();

    @Autowired
    protected ForecastProviderManager forecastProviderManager;

    @Autowired
    protected HomeController homeController;
    
    @Autowired
    protected OpenWeatherMapBean openWeatherMapBean;

    @RequestMapping(value = "/forecastProvider/{providerId}/setQueryFrequency/{queryFrequencyMillis}", method = RequestMethod.GET)
    public String setQueryFrequency(@PathVariable Integer providerId,
            @PathVariable Integer queryFrequencyMillis, Model model, RedirectAttributes redirectAttributes) {
        ForecastProvider forecastProvider = forecastProviderManager.readById(providerId);
        if (forecastProvider == null) {
            model.addAttribute("msgError", "Forecast provider not found");
        } else {
            try {
                forecastProvider.setQueryFrequencyMillis(queryFrequencyMillis);
                forecastProviderManager.update(forecastProvider);
                openWeatherMapBean.setQueryFrequency(queryFrequencyMillis);
                redirectAttributes.addFlashAttribute("msgSuccess", "Forecast provider updated!");
            } catch (ExceptionNotValidFrequency ex) {
                redirectAttributes.addFlashAttribute("msgError", String.format("Not valid query frequency: %s", ex.getMessage()));
            } catch (ExceptionUpdateForecastProvider ex) {
                redirectAttributes.addFlashAttribute("msgError", String.format("Can't update forecast provider: %s", ex.getMessage()));
            }
        }
        return "redirect:/home";
    }
}
