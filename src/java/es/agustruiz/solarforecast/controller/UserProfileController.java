package es.agustruiz.solarforecast.controller;

import es.agustruiz.solarforecast.exception.ExceptionCreateRepeatedUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionCreateUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionCreateUserRole;
import es.agustruiz.solarforecast.exception.ExceptionNotExistsUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionPasswordNotMatching;
import es.agustruiz.solarforecast.exception.ExceptionUpdateUserProfile;
import es.agustruiz.solarforecast.model.UserProfile;
import es.agustruiz.solarforecast.model.UserRole;
import es.agustruiz.solarforecast.model.manager.UserProfileManager;
import es.agustruiz.solarforecast.model.manager.UserRoleManager;
import es.agustruiz.solarforecast.service.ForecastService;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    protected UserProfileManager userProfileManager;

    @Autowired
    protected UserRoleManager userRoleManager;

    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userProfileList(Model model) {
        model = configureModel(model);
        model.addAttribute("usersList", userProfileManager.readAll());
//        model.addAttribute("roleNamesMap", getRoleNamesMap());
        return "users";
    }

    @SuppressWarnings("UnusedAssignment")
    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public String userProfileCreate(Model model) {
        model = configureModel(model);
        model = configureModelForCreate(model, null, true, false);
        return "users";
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public String userProfileCreateSubmit(Model model,
            @RequestParam(value = "txtName", required = true) String txtName,
            @RequestParam(value = "txtPassword", required = true) String txtPassword,
            @RequestParam(value = "txtPassword2", required = true) String txtPassword2,
            @RequestParam(value = "chkRoleUser", defaultValue = "false") Boolean chkRoleUser,
            @RequestParam(value = "chkRoleAdmin", defaultValue = "false") Boolean chkRoleAdmin) {
        model = configureModel(model);
        chkRoleUser = true; // Assert role user is always checked
        try {
            if (!txtPassword.equals(txtPassword2)) {
                throw new ExceptionPasswordNotMatching();
            }
            UserProfile userProfile = new UserProfile();
            userProfile.setUsername(txtName);
            userProfile.setPassword(txtPassword);
            Set<UserRole> userRoles = new HashSet<>();
            if (chkRoleUser) {
                userRoles.add(new UserRole(UserRole.ROLE_USER));
            }
            if (chkRoleAdmin) {
                userRoles.add(new UserRole(UserRole.ROLE_ADMIN));
            }
            userProfileManager.create(userProfile);
            for (UserRole role : userRoles) {
                userRoleManager.create(role);
            }
            userProfile.setUserRole(userRoles);
            userProfileManager.update(userProfile);
            model.addAttribute("msgSuccess", "New user created!");
        } catch (NullPointerException ex) {
            model = configureModelForCreate(model, txtName, chkRoleUser, chkRoleAdmin);
            model.addAttribute("msgError", "Can't create new user. Please, check the parameters");
        } catch (ExceptionPasswordNotMatching ex) {
            model = configureModelForCreate(model, txtName, chkRoleUser, chkRoleAdmin);
            model.addAttribute("msgError", "Can't create new user. Password don't match");
        } catch (ExceptionCreateRepeatedUserProfile ex) {
            model.addAttribute("msgError", "Can't create new user. User already exists");
        } catch (ExceptionCreateUserProfile | ExceptionUpdateUserProfile | ExceptionNotExistsUserProfile ex) {
            model = configureModelForCreate(model, txtName, chkRoleUser, chkRoleAdmin);
            model.addAttribute("msgError", "Can't create new user: " + ex.getMessage());
        } catch (ExceptionCreateUserRole ex) {
            model = configureModelForCreate(model, txtName, chkRoleUser, chkRoleAdmin);
            model.addAttribute("msgError", "Can't create new user role: " + ex.getMessage());
        }
        model.addAttribute("usersList", userProfileManager.readAll());
        return "users";
    }

    @RequestMapping(value = "/users/activate/{userId}", method = RequestMethod.GET)
    public ModelAndView activeUserProfile(@PathVariable Integer userId, RedirectAttributes redir) {
        modelAndView.setViewName("redirect:/users");
        try {
            userProfileManager.active(userId);
            redir.addFlashAttribute("msgSuccess", "User account successfuly activated");
        } catch (ExceptionNotExistsUserProfile ex) {
            redir.addFlashAttribute("msgError", "User not found!");
        } catch (ExceptionUpdateUserProfile ex) {
            redir.addFlashAttribute("msgError", "Can't activate user account!");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/users/suspend/{userId}", method = RequestMethod.GET)
    public ModelAndView suspendUserProfile(@PathVariable Integer userId, RedirectAttributes redir) {
        modelAndView.setViewName("redirect:/users");
        try {
            userProfileManager.suspend(userId);
            redir.addFlashAttribute("msgSuccess", "User account successfuly suspended");
        } catch (ExceptionNotExistsUserProfile ex) {
            redir.addFlashAttribute("msgError", "User not found!");
        } catch (ExceptionUpdateUserProfile ex) {
            redir.addFlashAttribute("msgError", "Can't suspend user account!");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/users/delete/{userId}", method = RequestMethod.GET)
    public ModelAndView deleteUserProfile(@PathVariable Integer userId, RedirectAttributes redir) {
        modelAndView.setViewName("redirect:/users");
        try {
            userProfileManager.delete(userId);
            redir.addFlashAttribute("msgSuccess", "User account successfuly deleted");
        } catch (ExceptionNotExistsUserProfile ex) {
            redir.addFlashAttribute("msgError", "User not found!");
        } catch (ExceptionUpdateUserProfile ex) {
            redir.addFlashAttribute("msgError", "Can't delete user account!");
        }
        return modelAndView;
    }

    // Private methods
    //
    private Model configureModel(Model model) {
        model.addAttribute("forecastServiceStatus", forecastService.isForecastServiceOn());
        model.addAttribute("projectName", "SolarForecast");
        model.addAttribute("title", "Users");
        model.addAttribute("navActiveItem", "users");
        return model;
    }

    private Model configureModelForCreate(Model model, String txtName,
            Boolean chkRoleUser, Boolean chkRoleAdmin) {
        model.addAttribute("action", "create");
        model.addAttribute("title", "Create new user");
        if (txtName != null && txtName.isEmpty()) {
            model.addAttribute("txtName", txtName);
        }
        if (chkRoleUser != null) {
            model.addAttribute("chkRoleUser", chkRoleUser);
        }
        if (chkRoleAdmin != null) {
            model.addAttribute("chkRoleAdmin", chkRoleAdmin);
        }
        return model;
    }

    private Map<String, String> getRoleNamesMap() {
        Map<String, String> roleNamesMap = new LinkedHashMap<>();
        roleNamesMap.put("chkRoleUser", "User role");
        roleNamesMap.put("chkRoleAdmin", "Admin role");
        return roleNamesMap;
    }

    private Map<String, Boolean> getDefaultRoleValuesMap() {
        Map<String, Boolean> defaultRoleValuesMap = new LinkedHashMap<>();
        defaultRoleValuesMap.put("chkRoleUser", true);
        defaultRoleValuesMap.put("chkRoleAdmin", false);
        return defaultRoleValuesMap;
    }

}
