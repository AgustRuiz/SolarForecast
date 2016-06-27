package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionDeleteForecastPlace;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.dao.ForecastPlaceDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    public List<ForecastPlace> readAllForecastPlace() {
        return forecastPlaceDAO.readAllForecastPlace();
    }

    @Override
    public ForecastPlace readForecastPlace(long id) {
        return forecastPlaceDAO.readForecastPlace(id);
    }
    
    @Override
    public void deleteForecastPlace(ForecastPlace forecastPlace) throws ExceptionDeleteForecastPlace{
            forecastPlaceDAO.deleteForecastPlace(forecastPlace);
    }
    
}
