package es.agustruiz.solarforecast.model.openweathermap;

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
public class Forecast5Response implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Long id;
    
    @Column
    protected Integer dt;
    
    @Column
    protected Double temp;
    
    @Column
    protected Double tempMin;
    
    @Column
    protected Double tempMax;
    
    @Column
    protected Double pressure;
    
    @Column
    protected Double seaLevel;
    
    @Column
    protected Double grndLevel;
    
    @Column
    protected Integer humidity;
    
    @Column
    protected Integer tmpKf;
    
    @Column
    protected Integer cloudsAll;
    
    @Column
    protected Double windSpeed;
    
    @Column
    protected Integer windDeg;
    
    @Column
    protected Double rain3h;

    public Forecast5Response() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Double getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getTmpKf() {
        return tmpKf;
    }

    public void setTmpKf(Integer tmpKf) {
        this.tmpKf = tmpKf;
    }

    public Integer getCloudsAll() {
        return cloudsAll;
    }

    public void setCloudsAll(Integer cloudsAll) {
        this.cloudsAll = cloudsAll;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(Integer windDeg) {
        this.windDeg = windDeg;
    }

    public Double getRain3h() {
        return rain3h;
    }

    public void setRain3h(Double rain3h) {
        this.rain3h = rain3h;
    }
    
}
