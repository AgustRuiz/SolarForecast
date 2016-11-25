package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateUserRole;
import es.agustruiz.solarforecast.exception.ExceptionUpdateUserRole;
import es.agustruiz.solarforecast.model.UserRole;
import es.agustruiz.solarforecast.model.dao.UserRoleDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class UserRoleManagerImpl implements UserRoleManager {

    protected static final String LOG_TAG = UserRoleManagerImpl.class.getName();

    @Autowired
    protected UserRoleDAO dao;

    // Overriden methods
    // 
    @Override
    public void create(UserRole userRole) throws ExceptionCreateUserRole {
        dao.create(userRole);
    }

    @Override
    public UserRole readById(long id) {
        return dao.readById(id);
    }

    @Override
    public List<UserRole> readAll() {
        return dao.readAll();
    }

    @Override
    public void update(UserRole userRole) throws ExceptionUpdateUserRole {
        dao.update(userRole);
    }

}
