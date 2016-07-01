package es.agustruiz.solarforecast.model.openweathermap.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecast5Response;
import es.agustruiz.solarforecast.model.openweathermap.Forecast5Response;
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
public class Forecast5ResponseDAOImpl implements Forecast5ResponseDAO {

    protected static final String LOG_TAG = Forecast5ResponseDAOImpl.class.getName();

    //@PersistenceContext
    @Autowired
    private EntityManagerFactory emf;
    
    @Transactional
    @Override
    public void create(Forecast5Response forecast5Response) throws ExceptionCreateForecast5Response {
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
            throw new ExceptionCreateForecast5Response(ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Forecast5Response read(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Forecast5Response> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void update(Forecast5Response forecast5Response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void delete(Forecast5Response forecast5Response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
