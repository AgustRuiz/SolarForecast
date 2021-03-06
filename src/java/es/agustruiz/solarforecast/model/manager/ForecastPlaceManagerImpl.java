package es.agustruiz.solarforecast.model.manager;

import es.agustruiz.solarforecast.exception.ExceptionCreateForecastPlace;
import es.agustruiz.solarforecast.exception.ExceptionDeleteForecastPlace;
import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.dao.ForecastPlaceDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class ForecastPlaceManagerImpl implements ForecastPlaceManager {
    
    protected static final String LOG_TAG = ForecastPlaceManagerImpl.class.getName();

    @Autowired
    protected ForecastPlaceDAO forecastPlaceDAO;

    @Override
    public void createForecastPlace(ForecastPlace forecastPlace) throws ExceptionCreateForecastPlace {
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
