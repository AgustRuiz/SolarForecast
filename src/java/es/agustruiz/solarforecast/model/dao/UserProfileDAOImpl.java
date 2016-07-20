package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateUserProfile;
import es.agustruiz.solarforecast.model.UserProfile;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Repository
public class UserProfileDAOImpl implements UserProfileDAO {
    
    private static final String LOG_TAG = UserProfileDAOImpl.class.getName();

    @Autowired
    private EntityManagerFactory emf;
    
    @Autowired
    protected LogLineManager logManager;

    @Transactional
    @Override
    public void create(UserProfile user) throws ExceptionCreateUserProfile {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(user);
            et.commit();
            logManager.i(LOG_TAG, String.format("New user \"%s\" created!", user.getName()));
        } catch (Exception ex) {
            if(et.isActive())
                et.rollback();
            logManager.e(LOG_TAG, String.format("Error creating user \"%s\"", user.getName()));
            throw new ExceptionCreateUserProfile(ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public UserProfile read(String name) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserProfile> cQuery = cBuilder.createQuery(UserProfile.class);
        Root root = cQuery.from(UserProfile.class);

        Predicate predicate = cBuilder.equal(root.get("name"), name);
        cQuery.select(root);
        cQuery.where(predicate);
        
        try {
            return em.createQuery(cQuery).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public UserProfile read(long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(UserProfile.class, id);
    }

    @Override
    public List<UserProfile> readAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserProfile> cq = cb.createQuery(UserProfile.class);
        Root<UserProfile> root = cq.from(UserProfile.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

}
