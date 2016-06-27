package es.agustruiz.solarforecast.model.dao;

import es.agustruiz.solarforecast.exception.ExceptionCreateLogLine;
import es.agustruiz.solarforecast.model.LogLine;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
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
public class LogLineDAOImpl implements LogLineDAO {

    //@PersistenceContext
    @Autowired
    private EntityManagerFactory emf;

    protected static final String LOG_TAG = LogLineDAOImpl.class.getName();

    @Override
    public void createLogLine(LogLine logLine) throws ExceptionCreateLogLine{
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            em.getTransaction().begin();
            em.persist(logLine);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new ExceptionCreateLogLine(ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public LogLine readLogLine(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LogLine> readLogLine(int pageNumber, int rowsPerPage) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LogLine> cq = cb.createQuery(LogLine.class);
        Root<LogLine> root = cq.from(LogLine.class);
        cq.select(root).orderBy(cb.desc(root.get("timeInMillis")));
        TypedQuery<LogLine> tq = em.createQuery(cq);
        tq.setFirstResult((pageNumber - 1) * rowsPerPage);
        tq.setMaxResults(rowsPerPage);
        return tq.getResultList();
    }

    @Override
    public List<LogLine> readAllLogLine() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LogLine> cq = cb.createQuery(LogLine.class);
        Root<LogLine> root = cq.from(LogLine.class);
        cq.select(root).orderBy(cb.desc(root.get("timeInMillis")));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public int count() {
        //return 15;
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(LogLine.class)));
        return em.createQuery(cq).getSingleResult().intValue();
    }

//    @Override
//    public void updateLogLine(LogLine logLine) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void deleteLogLine(LogLine logLine) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
