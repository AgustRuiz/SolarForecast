package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateRepeatedUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionCreateUserProfile;
import es.agustruiz.solarforecast.model.UserProfile;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface UserProfileDAO {
    
    void create(UserProfile user) throws ExceptionCreateUserProfile, ExceptionCreateRepeatedUserProfile;
    
    UserProfile read(String name);
    
    UserProfile read(long id);
    
    List<UserProfile> readAll();
    
}
