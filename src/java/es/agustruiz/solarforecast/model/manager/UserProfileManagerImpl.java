package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateRepeatedUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionCreateUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionNotExistsUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionUpdateUserProfile;
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
    public void create(UserProfile user) throws ExceptionCreateUserProfile, ExceptionCreateRepeatedUserProfile {
        dao.create(user);
    }

    @Override
    public UserProfile read(String name) {
        return dao.readByName(name);
    }

    @Override
    public UserProfile read(long id) {
        return dao.readById(id);
    }

    @Override
    public List<UserProfile> readAll() {
        return dao.readAll();
    }

    @Override
    public void update(UserProfile user) throws ExceptionUpdateUserProfile, ExceptionNotExistsUserProfile {
        dao.update(user);
    }

    @Override
    public void active(long id) throws ExceptionUpdateUserProfile, ExceptionNotExistsUserProfile {
        UserProfile user = dao.readById(id);
        if (user == null) {
            throw new ExceptionNotExistsUserProfile();
        }
        user.setActivatedState();
        dao.update(user);
    }

    @Override
    public void suspend(long id) throws ExceptionUpdateUserProfile, ExceptionNotExistsUserProfile {
        UserProfile user = dao.readById(id);
        if (user == null) {
            throw new ExceptionNotExistsUserProfile();
        }
        user.setSuspendedState();
        dao.update(user);
    }

    @Override
    public void delete(long id) throws ExceptionUpdateUserProfile, ExceptionNotExistsUserProfile {
        UserProfile user = dao.readById(id);
        if (user == null) {
            throw new ExceptionNotExistsUserProfile();
        }
        user.setDeletedState();
        dao.update(user);
    }

}
