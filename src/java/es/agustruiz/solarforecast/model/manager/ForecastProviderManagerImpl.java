package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastProvider;
import es.agustruiz.solarforecast.exception.ExceptionUpdateForecastProvider;
import es.agustruiz.solarforecast.model.ForecastProvider;
import es.agustruiz.solarforecast.model.dao.ForecastProviderDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class ForecastProviderManagerImpl implements ForecastProviderManager{
    
    protected static final String LOG_TAG = ForecastProviderManagerImpl.class.getName();
    
    @Autowired
    ForecastProviderDAO dao;    
    
    @Autowired
    ForecastQueryRegistryManager fQueryRegistryManager;


    @Override
    public void create(ForecastProvider forecastProvider) throws ExceptionCreateForecastProvider {
        dao.create(forecastProvider);
    }

    @Override
    public ForecastProvider readById(long id) {
        return dao.readById(id);
    }

    @Override
    public ForecastProvider readByName(String providerName) {
        return dao.readByName(providerName);
    }

    @Override
    public List<ForecastProvider> readAll() {
        return dao.readAll();
    }

    @Override
    public void update(ForecastProvider forecastProvider) throws ExceptionUpdateForecastProvider {
        dao.update(forecastProvider);
    }

    @Override
    public int countQueriesByProvider(String providerName) {
        return fQueryRegistryManager.countByProvider(providerName);
    }
    
}
