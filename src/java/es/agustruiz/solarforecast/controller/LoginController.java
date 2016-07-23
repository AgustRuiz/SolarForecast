package es.agustruiz.solarforecast.controller;

import es.agustruiz.solarforecast.model.UserProfile;
import es.agustruiz.solarforecast.model.manager.UserProfileManager;
import es.agustruiz.solarforecast.service.ForecastService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Controller
public class LoginController {

    protected static final String LOG_TAG = LoginController.class.getName();

    @Autowired
    protected ForecastService forecastService;

    @Autowired
    protected UserProfileManager userManager;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model = configureModel(model);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(Model model, HttpServletRequest request,
            @RequestParam(value = "txtUserName", required = true) String txtUserName,
            @RequestParam(value = "txtPassword", required = true) String txtPassword) {
        model = configureModel(model);
        model.addAttribute("txtUserName", txtUserName);

        try {
            if (txtUserName.isEmpty() || txtPassword.isEmpty()) {
                throw new Exception("Please, fill user name and password!");
            }
            UserProfile user = userManager.read(txtUserName);
            if (user == null || !user.checkPassword(txtPassword)){
                throw new Exception("Incorrect user name or password!");
            }
            model.addAttribute("msgSuccess", "DO HERE LOGIN WITH USER");
        } catch (Exception ex) {
            model.addAttribute("msgError", ex.getMessage());
        }
        return "login";
    }

    private Model configureModel(Model model) {
        model.addAttribute("forecastServiceStatus", forecastService.isForecastServiceOn());
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Users");
        model.addAttribute("navActiveItem", "users");
        return model;
    }

}
