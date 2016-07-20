package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateUserProfile;
import es.agustruiz.solarforecast.model.UserProfile;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface UserProfileManager {
    
    void create(UserProfile user) throws ExceptionCreateUserProfile;
    
    UserProfile read(String name);
    
    UserProfile read(long id);
    
    List<UserProfile> readAll();
    
}
