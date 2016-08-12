package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateRepeatedUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionCreateUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionNotExistsUserProfile;
import es.agustruiz.solarforecast.exception.ExceptionUpdateUserProfile;
import es.agustruiz.solarforecast.model.UserProfile;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public interface UserProfileManager {

    void create(UserProfile user) throws ExceptionCreateUserProfile, ExceptionCreateRepeatedUserProfile;

    UserProfile read(String name);

    UserProfile read(long id);

    List<UserProfile> readAll();

    void update(UserProfile user) throws ExceptionUpdateUserProfile, ExceptionNotExistsUserProfile;

    void active(long id) throws ExceptionUpdateUserProfile, ExceptionNotExistsUserProfile;

    void suspend(long id) throws ExceptionUpdateUserProfile, ExceptionNotExistsUserProfile;

    void delete(long id) throws ExceptionUpdateUserProfile, ExceptionNotExistsUserProfile;

}
