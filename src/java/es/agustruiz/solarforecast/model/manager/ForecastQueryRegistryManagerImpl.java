package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastQueryRegistry;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastProvider;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;
import es.agustruiz.solarforecast.model.dao.ForecastQueryRegistryDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class ForecastQueryRegistryManagerImpl implements ForecastQueryRegistryManager {

    protected static final String LOG_TAG = ForecastQueryRegistryManagerImpl.class.getName();

    @Autowired
    protected ForecastQueryRegistryDAO forecastQueryRegistryDAO;

    @Override
    public void createForecastQueryRegistry(ForecastQueryRegistry forecastQueryRegistry) throws ExceptionCreateForecastQueryRegistry {
        forecastQueryRegistryDAO.createForecastQueryRegistry(forecastQueryRegistry);
    }

    @Override
    public ForecastQueryRegistry getLastForecastQueryRegistryByPlace(ForecastPlace forecastPlace) {
        return forecastQueryRegistryDAO.getLastForecastQueryRegistryByPlace(forecastPlace);
    }

    @Override
    public int countByProvider(String forecastProvider) {
        return forecastQueryRegistryDAO.countByProvider(forecastProvider);
    }

    @Override
    public List<ForecastQueryRegistry> readAllByPlaceAndProvider(ForecastPlace place, ForecastProvider provider) {
        return forecastQueryRegistryDAO.readAllByPlaceAndProvider(place, provider);
    }

}
