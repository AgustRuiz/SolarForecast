package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.LogLine;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    public void createForecastPlace(ForecastPlace forecastPlace) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(forecastPlace);
        em.getTransaction().commit();
    }

    @Override
    public ForecastPlace readForecastPlace(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLogLine(ForecastPlace forecastPlace) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLogLine(ForecastPlace forecastPlace) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
