package es.agustruiz.solarforecast.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Entity
public class ForecastPlace implements Serializable {
    
    protected static final String LOG_TAG = ForecastPlace.class.getName();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(unique=true)
    protected String name;

    @Column
    protected float latitude;

    @Column
    protected float longitude;
    
    @Column
    protected String TiempoCom_LocationValue;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    protected List<ForecastQueryRegistry> forecastQueryRegistryList;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    protected List<Forecast5Response> openWeatherMapForecastList;

    public ForecastPlace() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getTiempoCom_LocationValue() {
        return TiempoCom_LocationValue;
    }

    public void setTiempoCom_LocationValue(String TiempoCom_LocationValue) {
        this.TiempoCom_LocationValue = TiempoCom_LocationValue;
    }

}
