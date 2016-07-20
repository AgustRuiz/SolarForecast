package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateUserProfile;
import es.agustruiz.solarforecast.model.UserProfile;
import es.agustruiz.solarforecast.model.dao.UserProfileDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class UserProfileManagerImpl implements UserProfileManager {

    protected static final String LOG_TAG = UserProfileManagerImpl.class.getName();

    @Autowired
    protected UserProfileDAO dao;

    @Override
    public void create(UserProfile user) throws ExceptionCreateUserProfile {
        dao.create(user);
    }

    @Override
    public UserProfile read(String name) {
        return dao.read(name);
    }

    @Override
    public UserProfile read(long id) {
        return dao.read(id);
    }

    @Override
    public List<UserProfile> readAll() {
        return dao.readAll();
    }

}
