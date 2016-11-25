package es.agustruiz.solarforecast.model.openweathermap;

import es.agustruiz.solarforecast.model.AbstractResponse;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.CloudsAPI;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.ListAPI;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.MainAPI;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.RainAPI;
import es.agustruiz.solarforecast.model.api.openweathermap.forecast5.WindAPI;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
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
public class OWM_Forecast5Response extends AbstractResponse implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected Integer dt;
    public static final String PARAM_DT_TAG = "dt";

    @Column
    protected Double temp;
    public static final String PARAM_TEMP_TAG = "temp";

    @Column
    protected Double tempMin;
    public static final String PARAM_TEMP_MIN_TAG = "tempMin";

    @Column
    protected Double tempMax;
    public static final String PARAM_TEMP_MAX_TAG = "tempMax";

    @Column
    protected Double pressure;
    public static final String PARAM_PRESSURE_TAG = "pressure";

    @Column
    protected Double seaLevel;
    public static final String PARAM_SEA_LEVEL_TAG = "seaLevel";

    @Column
    protected Double grndLevel;
    public static final String PARAM_GRND_LEVEL_TAG = "grndLevel";

    @Column
    protected Integer humidity;
    public static final String PARAM_HUMIDITY_TAG = "humidity";

    @Column
    protected Integer tempKf;
    public static final String PARAM_TEMP_KF_TAG = "tempKf";

    @Column
    protected Integer cloudsAll;
    public static final String PARAM_CLOUDS_ALL_TAG = "cloudsAll";

    @Column
    protected Double windSpeed;
    public static final String PARAM_WIND_SPEED_TAG = "windSpeed";

    @Column
    protected Integer windDeg;
    public static final String PARAM_WIND_DEG_TAG = "windDeg";

    @Column
    protected Double rain3h;
    public static final String PARAM_RAIN3H_TAG = "rain3h";

    // Constructors
    //
    public OWM_Forecast5Response() {
    }

    public OWM_Forecast5Response(ListAPI listAPI) {
        getDataFromAPIResponse(listAPI);
    }

    // Getters and setters
    //
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

    public String getFielByTag(String tag) {
        switch (tag) {
            case AbstractResponse.PARAM_QUERY_TIMESTAMP_TAG:
                return Long.toString(super.queryTimestamp);
            case PARAM_DT_TAG:
                return (dt != null ? dt.toString() : "");
            case PARAM_TEMP_TAG:
                return (temp != null ? temp.toString() : "");
            case PARAM_TEMP_MIN_TAG:
                return (tempMin != null ? tempMin.toString() : "");
            case PARAM_TEMP_MAX_TAG:
                return (tempMax != null ? tempMax.toString() : "");
            case PARAM_PRESSURE_TAG:
                return (pressure != null ? pressure.toString() : "");
            case PARAM_SEA_LEVEL_TAG:
                return (seaLevel != null ? seaLevel.toString() : "");
            case PARAM_GRND_LEVEL_TAG:
                return (grndLevel != null ? grndLevel.toString() : "");
            case PARAM_HUMIDITY_TAG:
                return (humidity != null ? humidity.toString() : "");
            case PARAM_TEMP_KF_TAG:
                return (tempKf != null ? tempKf.toString() : "");
            case PARAM_CLOUDS_ALL_TAG:
                return (cloudsAll != null ? cloudsAll.toString() : "");
            case PARAM_WIND_SPEED_TAG:
                return (windSpeed != null ? windSpeed.toString() : "");
            case PARAM_WIND_DEG_TAG:
                return (windDeg != null ? windDeg.toString() : "");
            case PARAM_RAIN3H_TAG:
                return (rain3h != null ? rain3h.toString() : "");
            default:
                return "";
        }
    }

    // Static public methods
    //
    static public Map<String, String> getParamList(String requestTimestampKey, String requestTimestampValue) {
        Map<String, String> result = new LinkedHashMap<>();
        result.put(requestTimestampKey, requestTimestampValue);
        result.put(PARAM_DT_TAG, "Forecast timestamp");
        result.put(PARAM_TEMP_TAG, "Temperature");
        result.put(PARAM_TEMP_MIN_TAG, "Min temperature");
        result.put(PARAM_TEMP_MAX_TAG, "Max temperature");
        result.put(PARAM_PRESSURE_TAG, "Pressure");
        result.put(PARAM_SEA_LEVEL_TAG, "Sea level");
        result.put(PARAM_GRND_LEVEL_TAG, "Ground level");
        result.put(PARAM_HUMIDITY_TAG, "Humidity");
        result.put(PARAM_TEMP_KF_TAG, "Temperature (Kº)");
        result.put(PARAM_CLOUDS_ALL_TAG, "Clouds");
        result.put(PARAM_WIND_SPEED_TAG, "Wind speed");
        result.put(PARAM_WIND_DEG_TAG, "Wind degree");
        result.put(PARAM_RAIN3H_TAG, "Rain (3 hours)");
        return result;
    }

    // Private methods
    //
    private void getDataFromAPIResponse(ListAPI apiResponse) {
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
        }
    }
}
