package es.agustruiz.solarforecast.controller;

import es.agustruiz.solarforecast.exception.ExceptionCreateRepeatedUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionCreateUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionPasswordNotMatching;
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
public class UserProfileController {

    protected static final String LOG_TAG = UserProfileController.class.getName();

    @Autowired
    protected ForecastService forecastService;

    @Autowired
    protected UserProfileManager manager;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userProfileList(Model model) {
        model = configureModel(model);
        model.addAttribute("usersList", manager.readAll());
        return "users";
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public String userProfileCreate(Model model) {
        model = configureModel(model);
        model.addAttribute("action", "create");
        model.addAttribute("title", "Create new user");
        return "users";
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public String userProfileCreateSubmit(Model model, HttpServletRequest request,
            @RequestParam(value = "txtName", required = true) String txtName,
            @RequestParam(value = "txtPassword", required = true) String txtPassword,
            @RequestParam(value = "txtPassword2", required = true) String txtPassword2) {
        model = configureModel(model);
        try {
            if (!txtPassword.equals(txtPassword2)) {
                throw new ExceptionPasswordNotMatching();
            }
            UserProfile userProfile = new UserProfile();
            userProfile.setName(txtName);
            userProfile.setPassword(txtPassword);
            manager.create(userProfile);
            model.addAttribute("msgSuccess", "New user created!");
            model.addAttribute("usersList", manager.readAll());

        } catch (ExceptionPasswordNotMatching ex){
            model.addAttribute("action", "create");
            model.addAttribute("title", "Create new user");
            model.addAttribute("txtName", txtName);
            model.addAttribute("msgError", "Can't create new user. Password don't match");
        } catch (ExceptionCreateRepeatedUserProfile ex) {
            model.addAttribute("msgError", "Can't create new user. User already exists");
        } catch (NullPointerException ex) {
            model.addAttribute("action", "create");
            model.addAttribute("title", "Create new user");
            model.addAttribute("txtName", txtName);
            model.addAttribute("msgError", "Can't create new user. Please, check the parameters");
        } catch (ExceptionCreateUserProfile ex) {
            model.addAttribute("action", "create");
            model.addAttribute("title", "Create new user");
            model.addAttribute("txtName", txtName);
            model.addAttribute("msgError", "Can't create new user. Database error");
        }
        return "users";

    }

    private Model configureModel(Model model) {
        model.addAttribute("forecastServiceStatus", forecastService.isForecastServiceOn());
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Users");
        model.addAttribute("navActiveItem", "users");
        return model;
    }

}
