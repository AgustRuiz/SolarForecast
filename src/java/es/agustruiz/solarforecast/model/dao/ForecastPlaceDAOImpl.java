package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastPlace;
import es.agustruiz.solarforecast.exception.ExceptionDeleteForecastPlace;
import es.agustruiz.solarforecast.model.ForecastPlace;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Repository
public class ForecastPlaceDAOImpl implements ForecastPlaceDAO {

    @Autowired
    private EntityManagerFactory emf;

    @Override
    public void createForecastPlace(ForecastPlace forecastPlace) throws ExceptionCreateForecastPlace {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            em.getTransaction().begin();
            em.persist(forecastPlace);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new ExceptionCreateForecastPlace(ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public ForecastPlace readForecastPlace(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(ForecastPlace.class, id);
    }

    @Override
    public List<ForecastPlace> readAllForecastPlace() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ForecastPlace> cq = cb.createQuery(ForecastPlace.class);
        Root<ForecastPlace> root = cq.from(ForecastPlace.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void deleteForecastPlace(ForecastPlace forecastPlace) throws ExceptionDeleteForecastPlace {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(em.contains(forecastPlace) ? forecastPlace : em.merge(forecastPlace));
            em.flush();
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new ExceptionDeleteForecastPlace(ex.getMessage());
        } finally {
            em.close();
        }
    }

}
