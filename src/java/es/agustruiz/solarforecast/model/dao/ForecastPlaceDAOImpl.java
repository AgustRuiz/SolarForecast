package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.model.ForecastPlace;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
