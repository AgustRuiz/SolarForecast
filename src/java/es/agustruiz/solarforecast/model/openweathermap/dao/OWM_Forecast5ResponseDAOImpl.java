package es.agustruiz.solarforecast.model.openweathermap.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateOWMForecast5Response;
import es.agustruiz.solarforecast.model.openweathermap.OWM_Forecast5Response;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Repository
public class OWM_Forecast5ResponseDAOImpl implements OWM_Forecast5ResponseDAO {

    protected static final String LOG_TAG = OWM_Forecast5ResponseDAOImpl.class.getName();

    //@PersistenceContext
    @Autowired
    private EntityManagerFactory emf;
    
    @Transactional
    @Override
    public void create(OWM_Forecast5Response forecast5Response) throws ExceptionCreateOWMForecast5Response {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            em.getTransaction().begin();
            em.persist(forecast5Response);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new ExceptionCreateOWMForecast5Response(ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public OWM_Forecast5Response read(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OWM_Forecast5Response> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void update(OWM_Forecast5Response forecast5Response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void delete(OWM_Forecast5Response forecast5Response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
