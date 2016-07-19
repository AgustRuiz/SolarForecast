package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastProvider;
import es.agustruiz.solarforecast.exception.ExceptionUpdateForecastProvider;
import es.agustruiz.solarforecast.model.ForecastProvider;
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

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Repository
public class ForecastProviderDAOImpl implements ForecastProviderDAO {

    protected static final String LOG_TAG = ForecastProviderDAOImpl.class.getName();

    @Autowired
    private EntityManagerFactory emf;
    
    @Autowired
    protected LogLineManager logManager;

    @Override
    public void create(ForecastProvider forecastProvider) throws ExceptionCreateForecastProvider {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            em.getTransaction().begin();
            em.persist(forecastProvider);
            em.getTransaction().commit();
            logManager.i(LOG_TAG, String.format("Forecast provider \"%s\" created",
                    forecastProvider.getProviderName()));
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            logManager.w(LOG_TAG, String.format("Cant create \"%s\" forecast provider",
                    forecastProvider.getProviderName()));
            throw new ExceptionCreateForecastProvider(ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public ForecastProvider readById(long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(ForecastProvider.class, id);
    }

    @Override
    public ForecastProvider readByName(String providerName) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ForecastProvider> cQuery = cBuilder.createQuery(ForecastProvider.class);
        Root root = cQuery.from(ForecastProvider.class);

        Predicate predicate = cBuilder.equal(root.get("providerName"), providerName);
        cQuery.select(root);
        cQuery.where(predicate);

        try {
            return em.createQuery(cQuery).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ForecastProvider> readAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ForecastProvider> cq = cb.createQuery(ForecastProvider.class);
        Root<ForecastProvider> root = cq.from(ForecastProvider.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void update(ForecastProvider forecastProvider) throws ExceptionUpdateForecastProvider{
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            em.getTransaction().begin();
            em.merge(forecastProvider);
            em.getTransaction().commit();
            logManager.i(LOG_TAG, String.format("Forecast provider \"%s\" updated",
                    forecastProvider.getProviderName()));
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            logManager.w(LOG_TAG, String.format("Can't update \"%s\" forecast provider",
                    forecastProvider.getProviderName()));
            throw new ExceptionUpdateForecastProvider(ex.getMessage());
        } finally {
            em.close();
        }
    }
    
//    @Override
//    public void delete(ForecastProvider forecastProvider) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
