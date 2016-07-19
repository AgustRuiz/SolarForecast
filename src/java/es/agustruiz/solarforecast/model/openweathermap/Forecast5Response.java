package es.agustruiz.solarforecast.model.openweathermap;

import es.agustruiz.solarforecast.model.ForecastPlace;
import es.agustruiz.solarforecast.model.ForecastQueryRegistry;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.CloudsAPI;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.ListAPI;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.MainAPI;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.RainAPI;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.WindAPI;
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
public class Forecast5Response implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    protected Integer tempKf;

    @Column
    protected Integer cloudsAll;

    @Column
    protected Double windSpeed;

    @Column
    protected Integer windDeg;

    @Column
    protected Double rain3h;

    @ManyToOne
    protected ForecastPlace forecastPlace;

    @ManyToOne
    protected ForecastQueryRegistry forecastQuery;

    // Constructors
    public Forecast5Response() {
    }

    public Forecast5Response(ListAPI listAPI, ForecastQueryRegistry forecastQuery) {
        getDataFromAPIResponse(listAPI, forecastQuery);
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = (dt != null ? dt : 0);
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = (temp != null ? temp : 0);
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = (tempMin != null ? tempMin : 0);
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = (tempMax != null ? tempMax : 0);
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = (pressure != null ? pressure : 0);
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = (seaLevel != null ? seaLevel : 0);
    }

    public Double getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = (grndLevel != null ? grndLevel : 0);
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = (humidity != null ? humidity : 0);
    }

    public Integer getTempKf() {
        return tempKf;
    }

    public void setTempKf(Integer tempKf) {
        this.tempKf = (tempKf != null ? tempKf : 0);
    }

    public Integer getCloudsAll() {
        return cloudsAll;
    }

    public void setCloudsAll(Integer cloudsAll) {
        this.cloudsAll = (cloudsAll != null ? cloudsAll : 0);
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = (windSpeed != null ? windSpeed : 0);
    }

    public Integer getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(Integer windDeg) {
        this.windDeg = (windDeg != null ? windDeg : 0);
    }

    public Double getRain3h() {
        return rain3h;
    }

    public void setRain3h(Double rain3h) {
        this.rain3h = (rain3h != null ? rain3h : 0);
    }

    public ForecastPlace getForecastPlace() {
        return forecastPlace;
    }

    public void setForecastPlace(ForecastPlace forecastPlace) {
        this.forecastPlace = forecastPlace;
    }

    public ForecastQueryRegistry getForecastQuery() {
        return forecastQuery;
    }

    public void setForecastQuery(ForecastQueryRegistry forecastQuery) {
        this.forecastQuery = forecastQuery;
    }

    // Private methods
    private void getDataFromAPIResponse(ListAPI apiResponse, ForecastQueryRegistry forecastQuery) {
        if (apiResponse != null) {
            setDt(apiResponse.getDt());
            CloudsAPI cloudsAPI = apiResponse.getClouds();
            if (cloudsAPI != null) {
                setCloudsAll(cloudsAPI.getAll());
            }
            MainAPI mainAPI = apiResponse.getMain();
            if (mainAPI != null) {
                setTemp(mainAPI.getTemp());
                setTempMin(mainAPI.getTempMin());
                setTempMax(mainAPI.getTempMax());
                setPressure(mainAPI.getPressure());
                setSeaLevel(mainAPI.getSeaLevel());
                setGrndLevel(mainAPI.getGrndLevel());
                setHumidity(mainAPI.getHumidity());
                setTempKf(mainAPI.getTempKf());
            }
            WindAPI windAPI = apiResponse.getWind();
            if (windAPI != null) {
                setWindSpeed(windAPI.getSpeed());
                setWindDeg(windAPI.getDeg());
            }
            RainAPI rainAPI = apiResponse.getRain();
            if (rainAPI != null) {
                setRain3h(apiResponse.getRain().get3h());
            }
            if (forecastQuery != null) {
                setForecastQuery(forecastQuery);
                if (forecastQuery.getForecastPlace() != null) {
                    setForecastPlace(forecastQuery.getForecastPlace());
                }
            }
        }
    }

}
