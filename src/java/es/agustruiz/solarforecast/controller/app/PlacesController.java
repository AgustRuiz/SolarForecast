package es.agustruiz.solarforecast.controller.app;

import es.agustruiz.solarforecast.bean.WeatherForecastBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Controller
public class PlacesController {
    
    public static final String LOG_TAG = PlacesController.class.getName();
    
    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public String places(Model model) {
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Places");
        model.addAttribute("navActiveItem", "places");
        model.addAttribute("placesList" , WeatherForecastBean.getPlacesList());
        
        return ("places");
    }
}
