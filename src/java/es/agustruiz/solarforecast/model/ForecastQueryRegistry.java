package es.agustruiz.solarforecast.model;

import es.agustruiz.solarforecast.model.openweathermap.OWM_Forecast5Response;
import es.agustruiz.solarforecast.model.tiempocom.TiempoComR3_Report;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

    @OneToMany(cascade = CascadeType.ALL)
    protected List<OWM_Forecast5Response> OWM_list;

    @OneToMany(cascade = CascadeType.ALL)
    protected List<TiempoComR3_Report> TiempoCom_list;
    
    public ForecastQueryRegistry() {
        this.timeInMillis = System.currentTimeMillis();
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

    public List<OWM_Forecast5Response> getOWM_list() {
        return OWM_list;
    }

    public void setOWM_list(List<OWM_Forecast5Response> OWM_list) {
        this.OWM_list = OWM_list;
    }

    public List<TiempoComR3_Report> getTiempoCom_list() {
        return TiempoCom_list;
    }

    public void setTiempoCom_list(List<TiempoComR3_Report> TiempoCom_list) {
        this.TiempoCom_list = TiempoCom_list;
    }
    
}
