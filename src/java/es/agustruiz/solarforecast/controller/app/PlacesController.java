package es.agustruiz.solarforecast.controller.app;

import es.agustruiz.solarforecast.bean.WeatherForecastBean;
import es.agustruiz.solarforecast.exception.ExceptionDeleteForecastPlace;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.manager.ForecastPlaceManager;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Controller
public class PlacesController {

    private static final String LOG_TAG = PlacesController.class.getName();

    @Autowired
    private ForecastPlaceManager forecastPlaceManager;

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public String places(Model model) {
        configureModel(model);
        model.addAttribute("placesList", forecastPlaceManager.readAllForecastPlace());
        return ("places");
    }

    @RequestMapping(value = "/places/create", method = RequestMethod.GET)
    public String createPlace(Model model) {
        configureModel(model);
        model.addAttribute("action", "create");
        model.addAttribute("title", "Create new Place");
        model.addAttribute("placesList", WeatherForecastBean.getPlacesList());
        return ("places");
    }

    @RequestMapping(value = "/places/create", method = RequestMethod.POST)
    public String createPlaceSubmit(Model model, HttpServletRequest request,
            @RequestParam(value = "txtName", required = true) String txtName,
            @RequestParam(value = "txtLatitude", required = false) String txtLatitude,
            @RequestParam(value = "txtLongitude", required = true) String txtLongitude) {

        ForecastPlace newForecastPlace = new ForecastPlace();
        newForecastPlace.setName(txtName);
        newForecastPlace.setLatitude(Float.parseFloat(txtLatitude));
        newForecastPlace.setLongitude(Float.parseFloat(txtLongitude));

        forecastPlaceManager.createForecastPlace(newForecastPlace);
        model.addAttribute("msgSuccess", "New place created!");

        configureModel(model);
        model.addAttribute("action", "create");
        model.addAttribute("title", "Create new Place - Received");
        model.addAttribute("txtName", txtName);
        model.addAttribute("txtLatitude", txtLatitude);
        model.addAttribute("txtLongitude", txtLongitude);
        model.addAttribute("msgError", "Not implemented yet");
        model.addAttribute("placesList", WeatherForecastBean.getPlacesList());
        return ("places");
    }

    @RequestMapping(value = "/places/delete/{placeId}", method = RequestMethod.GET)
    public String deletePlace(@PathVariable Integer placeId, Model model) {
        model = configureModel(model);

        ForecastPlace deleteForecastPlace = forecastPlaceManager.readForecastPlace(placeId);
        try{
            forecastPlaceManager.deleteForecastPlace(deleteForecastPlace);
            model.addAttribute("msgSuccess", "Place successfuly deleted");
        }catch(ExceptionDeleteForecastPlace ex){
            model.addAttribute("msgError", "Can't delete this place: <br/>" + ex.getMessage());
        }

        return places(model);
    }

    private Model configureModel(Model model) {
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Places");
        model.addAttribute("navActiveItem", "places");
        return model;
    }
}
