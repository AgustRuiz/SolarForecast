/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastQueryRegistry;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;
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
public class ForecastQueryRegistryDAOImpl implements ForecastQueryRegistryDAO {

    protected static final String LOG_TAG = ForecastQueryRegistryDAOImpl.class.getName();

    @Autowired
    EntityManagerFactory emf;

    @Override
    public void createForecastQueryRegistry(ForecastQueryRegistry forecastRegistry) throws ExceptionCreateForecastQueryRegistry {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            em.getTransaction().begin();
            em.persist(forecastRegistry);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new ExceptionCreateForecastQueryRegistry(ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public ForecastQueryRegistry getLastForecastQueryRegistryByPlace(ForecastPlace forecastPlace) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ForecastQueryRegistry> cQuery = cBuilder.createQuery(ForecastQueryRegistry.class);
        Root root = cQuery.from(ForecastQueryRegistry.class);

        Predicate predicate = cBuilder.equal(root.get("forecastPlace"), forecastPlace.getId());
        cQuery.select(root).orderBy(cBuilder.desc(root.get("timeInMillis"))); // First maximum = more recent
        cQuery.where(predicate);
        List<ForecastQueryRegistry> resultList = em.createQuery(cQuery).getResultList();
        
        return (resultList != null && resultList.size() > 0 ? resultList.get(0) : null);
    }

    @Override
    public int countByProvider(String forecastProvider) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ForecastQueryRegistry> cQuery = cBuilder.createQuery(ForecastQueryRegistry.class);
        Root root = cQuery.from(ForecastQueryRegistry.class);

        Predicate predicate = cBuilder.equal(root.get("forecastProvider"), forecastProvider);
        cQuery.select(root);
        cQuery.where(predicate);

        try {
            return em.createQuery(cQuery).getResultList().size();
        } catch (NoResultException ex) {
            return -1;
        }
    }
    
}
