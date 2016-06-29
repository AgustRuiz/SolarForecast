package es.agustruiz.solarforecast.model.openweathermap.dao;

import es.agustruiz.solarforecast.model.openweathermap.Forecast5Response;
import java.util.List;
import javax.persistence.EntityManagerFactory;
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
    public void create(Forecast5Response forecast5Response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
