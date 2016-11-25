package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateUserRole;
import es.agustruiz.solarforecast.exception.ExceptionUpdateUserRole;
import es.agustruiz.solarforecast.model.UserRole;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface UserRoleManager {

    void create(UserRole userRole) throws ExceptionCreateUserRole;

    UserRole readById(long id);

    List<UserRole> readAll();

    void update(UserRole userRole) throws ExceptionUpdateUserRole;

}
