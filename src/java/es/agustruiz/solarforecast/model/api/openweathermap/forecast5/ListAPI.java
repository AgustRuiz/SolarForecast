
package es.agustruiz.solarforecast.model.api.openweathermap.forecast5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "dt",
    "main",
    "weather",
    "clouds",
    "wind",
    "rain",
    "sys",
    "dt_txt"
})
public class ListAPI implements Serializable {

    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("main")
    private MainAPI main;
    @JsonProperty("weather")
    private java.util.List<WeatherAPI> weather = new ArrayList<>();
    @JsonProperty("clouds")
    private CloudsAPI clouds;
    @JsonProperty("wind")
    private WindAPI wind;
    @JsonProperty("rain")
    private RainAPI rain;
    @JsonProperty("sys")
    private Sys_API sys;
    @JsonProperty("dt_txt")
    private String dtTxt;
    @JsonIgnore
    final private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * 
     * @return
     *     The dt
     */
    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    /**
     * 
     * @param dt
     *     The dt
     */
    @JsonProperty("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    /**
     * 
     * @return
     *     The main
     */
    @JsonProperty("main")
    public MainAPI getMain() {
        return main;
    }

    /**
     * 
     * @param main
     *     The main
     */
    @JsonProperty("main")
    public void setMain(MainAPI main) {
        this.main = main;
    }

    /**
     * 
     * @return
     *     The weather
     */
    @JsonProperty("weather")
    public java.util.List<WeatherAPI> getWeather() {
        return weather;
    }

    /**
     * 
     * @param weather
     *     The weather
     */
    @JsonProperty("weather")
    public void setWeather(java.util.List<WeatherAPI> weather) {
        this.weather = weather;
    }

    /**
     * 
     * @return
     *     The clouds
     */
    @JsonProperty("clouds")
    public CloudsAPI getClouds() {
        return clouds;
    }

    /**
     * 
     * @param clouds
     *     The clouds
     */
    @JsonProperty("clouds")
    public void setClouds(CloudsAPI clouds) {
        this.clouds = clouds;
    }

    /**
     * 
     * @return
     *     The wind
     */
    @JsonProperty("wind")
    public WindAPI getWind() {
        return wind;
    }

    /**
     * 
     * @param wind
     *     The wind
     */
    @JsonProperty("wind")
    public void setWind(WindAPI wind) {
        this.wind = wind;
    }

    /**
     * 
     * @return
     *     The rain
     */
    @JsonProperty("rain")
    public RainAPI getRain() {
        return rain;
    }

    /**
     * 
     * @param rain
     *     The rain
     */
    @JsonProperty("rain")
    public void setRain(RainAPI rain) {
        this.rain = rain;
    }

    /**
     * 
     * @return
     *     The sys
     */
    @JsonProperty("sys")
    public Sys_API getSys() {
        return sys;
    }

    /**
     * 
     * @param sys
     *     The sys
     */
    @JsonProperty("sys")
    public void setSys(Sys_API sys) {
        this.sys = sys;
    }

    /**
     * 
     * @return
     *     The dtTxt
     */
    @JsonProperty("dt_txt")
    public String getDtTxt() {
        return dtTxt;
    }

    /**
     * 
     * @param dtTxt
     *     The dt_txt
     */
    @JsonProperty("dt_txt")
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
