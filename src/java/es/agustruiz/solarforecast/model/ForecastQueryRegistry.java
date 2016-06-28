package es.agustruiz.solarforecast.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Entity
public class ForecastQueryRegistry implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected long id;
    
    @Column
    protected long timeInMillis;
    
    @Column
    protected String forecastProvider;
    
    @ManyToOne
    protected ForecastPlace forecastPlace;

    public ForecastQueryRegistry() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    public String getForecastProvider() {
        return forecastProvider;
    }

    public void setForecastProvider(String forecastProvider) {
        this.forecastProvider = forecastProvider;
    }

    public ForecastPlace getForecastPlace() {
        return forecastPlace;
    }

    public void setForecastPlace(ForecastPlace forecastPlace) {
        this.forecastPlace = forecastPlace;
    }
    
}
