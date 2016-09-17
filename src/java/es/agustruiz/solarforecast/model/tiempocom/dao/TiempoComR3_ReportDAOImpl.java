package es.agustruiz.solarforecast.model.tiempocom.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateTiempoComR3Report;
import es.agustruiz.solarforecast.model.tiempocom.TiempoComR3_Report;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Repository
public class TiempoComR3_ReportDAOImpl implements TiempoComR3_ReportDAO {

    protected static final String LOG_TAG = TiempoComR3_ReportDAOImpl.class.getName();

    @Autowired
    private EntityManagerFactory emf;

    @Override
    public void create(TiempoComR3_Report report) throws ExceptionCreateTiempoComR3Report {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            em.getTransaction().begin();
            em.persist(report);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new ExceptionCreateTiempoComR3Report(ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public TiempoComR3_Report read(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TiempoComR3_Report> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(TiempoComR3_Report report) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TiempoComR3_Report report) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
