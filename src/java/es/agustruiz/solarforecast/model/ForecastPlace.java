package es.agustruiz.solarforecast.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Entity
public class ForecastPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column
    protected String name;

    @Column
    protected float latitude;

    @Column
    protected float longitude;
    
    @OneToMany
    protected List<ForecastQueryRegistry> forecastQueryRegistryList;

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

    public List<ForecastQueryRegistry> getForecastQueryRegistryList() {
        return forecastQueryRegistryList;
    }

    public void setForecastQueryRegistryList(List<ForecastQueryRegistry> forecastQueryRegistryList) {
        this.forecastQueryRegistryList = forecastQueryRegistryList;
    }

}
