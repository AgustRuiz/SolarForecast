package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.dao.ForecastPlaceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class ForecastPlaceManagerImpl implements ForecastPlaceManager {
    
    protected static final String LOG_TAG = ForecastPlaceManagerImpl.class.getName();
    
    protected static final int PAGE_SIZE = 10;

    @Autowired
    protected ForecastPlaceDAO forecastPlaceDAO;

    @Override
    public void createForecastPlace(ForecastPlace forecastPlace) {
        forecastPlaceDAO.createForecastPlace(forecastPlace);
    }
    
}
