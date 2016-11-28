package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateUserRole;
import es.agustruiz.solarforecast.exception.ExceptionUpdateUserRole;
import es.agustruiz.solarforecast.model.UserProfile;
import es.agustruiz.solarforecast.model.UserRole;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

    private static final String LOG_TAG = UserRoleDAOImpl.class.getName();

    @Autowired
    private EntityManagerFactory emf;

    @Autowired
    protected LogLineManager logManager;

    @Transactional
    @Override
    public void create(UserRole userRole) throws ExceptionCreateUserRole {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(userRole);
            et.commit();
            logManager.i(LOG_TAG, "User role created");
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            logManager.e(LOG_TAG, String.format("Error creating user role: %s", ex.getMessage()));
            throw new ExceptionCreateUserRole("Database error");
        } finally {
            em.close();
        }
    }

    @Override
    public UserRole readById(long id) {
        return emf.createEntityManager().find(UserRole.class, id);
    }

    @Override
    public List<UserRole> readAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserRole> cq = cb.createQuery(UserRole.class);
        Root<UserRole> root = cq.from(UserRole.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<UserRole> readByUserProfile(UserProfile userProfile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(UserRole userRole) throws ExceptionUpdateUserRole {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(userRole);
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new ExceptionUpdateUserRole(ex.getMessage());
        }
    }

}
