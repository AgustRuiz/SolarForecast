package es.agustruiz.solarforecast.model.dao;

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
public interface UserProfileDAO {

    void create(UserProfile user) throws ExceptionCreateUserProfile, ExceptionCreateRepeatedUserProfile;

    UserProfile readByName(String name);

    UserProfile readById(long id);

    List<UserProfile> readAll();

    void update(UserProfile user) throws ExceptionUpdateUserProfile, ExceptionNotExistsUserProfile;

    // SessionFactory methods
    
    SessionFactory getSessionFactory();

    void setSessionFactory(SessionFactory sessionFactory);

}
