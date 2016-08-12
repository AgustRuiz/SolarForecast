package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateUserRole;
import es.agustruiz.solarforecast.exception.ExceptionUpdateUserRole;
import es.agustruiz.solarforecast.model.UserProfile;
import es.agustruiz.solarforecast.model.UserRole;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface UserRoleDAO {
    
    void create(UserRole userRole) throws ExceptionCreateUserRole;
    
    UserRole readById(long id);
    
    List<UserRole> readAll();
    
    List<UserRole> readByUserProfile(UserProfile userProfile);
    
    void update(UserRole userRole) throws ExceptionUpdateUserRole;
    
}
