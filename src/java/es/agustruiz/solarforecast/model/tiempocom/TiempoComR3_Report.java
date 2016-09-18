package es.agustruiz.solarforecast.model.tiempocom;

import es.agustruiz.solarforecast.model.AbstractResponse;
import es.agustruiz.solarforecast.model.api.tiempocom.TiempoComR3_ReportAPI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
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
public class TiempoComR3_Report extends AbstractResponse implements Serializable {

    // Attributes
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected long fTimestamp;
    public static final String PARAM_TIMESTAMP_TAG = "fTimestamp";

    @Column
    protected String clouds;
    public static final String PARAM_CLOUDS_TAG = "clouds";

    @Column
    protected Integer humidity;
    public static final String PARAM_HUMIDITY_TAG = "humidity";

    @Column
    protected Integer pressureValue;
    public static final String PARAM_PRESSURE_VALUE_TAG = "pressureValue";

    @Column
    protected String pressureUnit;
    public static final String PARAM_PRESSURE_UNIT_TAG = "pressureUnit";

    @Column
    protected Integer rainValue;
    public static final String PARAM_RAIN_VALUE_TAG = "rainValue";

    @Column
    protected String rainUnit;
    public static final String PARAM_RAIN_UNIT_TAG = "rainUnit";

    @Column
    protected Integer snowlineValue;
    public static final String PARAM_SNOWLINE_VALUE_TAG = "snowlineValue";

    @Column
    protected String snowlineUnit;
    public static final String PARAM_SNOWLINE_UNIT_TAG = "snowlineUnit";

    @Column
    protected Integer tempValue;
    public static final String PARAM_TEMP_VALUE_TAG = "tempValue";

    @Column
    protected String tempUnit;
    public static final String PARAM_TEMP_UNIT_TAG = "tempUnit";

    @Column
    protected Integer windValue;
    public static final String PARAM_WIND_VALUE_TAG = "windValue";

    @Column
    protected String windUnit;
    public static final String PARAM_WIND_UNIT_TAG = "windUnit";

    @Column
    protected String windDir;
    public static final String PARAM_WIND_DIR_TAG = "windDir";

    @Column
    protected Integer windGustsValue;
    public static final String PARAM_WINDGUSTS_VALUE_TAG = "windGustsValue";

    @Column
    protected String windGustsUnit;
    public static final String PARAM_WINDGUSTS_UNIT_TAG = "windGustsUnit";

    @Column
    protected Integer windchillValue;
    public static final String PARAM_WINDCHILL_VALUE_TAG = "windchillValue";

    @Column
    protected String windchillUnit;
    public static final String PARAM_WINDCHILL_UNIT_TAG = "windchillUnit";

    // Public methods
    //
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getfTimestamp() {
        return fTimestamp;
    }

    public void setfTimestamp(long fTimestamp) {
        this.fTimestamp = fTimestamp;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPressureValue() {
        return pressureValue;
    }

    public void setPressureValue(Integer pressureValue) {
        this.pressureValue = pressureValue;
    }

    public String getPressureUnit() {
        return pressureUnit;
    }

    public void setPressureUnit(String pressureUnit) {
        this.pressureUnit = pressureUnit;
    }

    public Integer getRainValue() {
        return rainValue;
    }

    public void setRainValue(Integer rainValue) {
        this.rainValue = rainValue;
    }

    public String getRainUnit() {
        return rainUnit;
    }

    public void setRainUnit(String rainUnit) {
        this.rainUnit = rainUnit;
    }

    public Integer getSnowlineValue() {
        return snowlineValue;
    }

    public void setSnowlineValue(Integer snowlineValue) {
        this.snowlineValue = snowlineValue;
    }

    public String getSnowlineUnit() {
        return snowlineUnit;
    }

    public void setSnowlineUnit(String snowlineUnit) {
        this.snowlineUnit = snowlineUnit;
    }

    public Integer getTempValue() {
        return tempValue;
    }

    public void setTempValue(Integer tempValue) {
        this.tempValue = tempValue;
    }

    public String getTempUnit() {
        return tempUnit;
    }

    public void setTempUnit(String tempUnit) {
        this.tempUnit = tempUnit;
    }

    public Integer getWindValue() {
        return windValue;
    }

    public void setWindValue(Integer windValue) {
        this.windValue = windValue;
    }

    public String getWindUnit() {
        return windUnit;
    }

    public void setWindUnit(String windUnit) {
        this.windUnit = windUnit;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public Integer getWindGustsValue() {
        return windGustsValue;
    }

    public void setWindGustsValue(Integer windGustsValue) {
        this.windGustsValue = windGustsValue;
    }

    public String getWindGustsUnit() {
        return windGustsUnit;
    }

    public void setWindGustsUnit(String windGustsUnit) {
        this.windGustsUnit = windGustsUnit;
    }

    public Integer getWindchillValue() {
        return windchillValue;
    }

    public void setWindchillValue(Integer windchillValue) {
        this.windchillValue = windchillValue;
    }

    public String getWindchillUnit() {
        return windchillUnit;
    }

    public void setWindchillUnit(String windchillUnit) {
        this.windchillUnit = windchillUnit;
    }

    public String getFielByTag(String tag) {
        switch (tag) {
            case AbstractResponse.PARAM_QUERY_TIMESTAMP_TAG:
                return Long.toString(super.queryTimestamp);
            case PARAM_TIMESTAMP_TAG:
                return Long.toString(fTimestamp);
            case PARAM_CLOUDS_TAG:
                return clouds;
            case PARAM_HUMIDITY_TAG:
                return humidity.toString();
            case PARAM_PRESSURE_VALUE_TAG:
                return pressureValue.toString();
            case PARAM_PRESSURE_UNIT_TAG:
                return pressureUnit;
            case PARAM_RAIN_VALUE_TAG:
                return rainValue.toString();
            case PARAM_RAIN_UNIT_TAG:
                return rainUnit;
            case PARAM_SNOWLINE_VALUE_TAG:
                return snowlineValue.toString();
            case PARAM_SNOWLINE_UNIT_TAG:
                return snowlineUnit;
            case PARAM_TEMP_VALUE_TAG:
                return tempValue.toString();
            case PARAM_TEMP_UNIT_TAG:
                return tempUnit;
            case PARAM_WIND_VALUE_TAG:
                return windValue.toString();
            case PARAM_WIND_UNIT_TAG:
                return windUnit;
            case PARAM_WIND_DIR_TAG:
                return windDir;
            case PARAM_WINDGUSTS_VALUE_TAG:
                return windGustsValue.toString();
            case PARAM_WINDGUSTS_UNIT_TAG:
                return windGustsUnit;
            case PARAM_WINDCHILL_VALUE_TAG:
                return windchillValue.toString();
            case PARAM_WINDCHILL_UNIT_TAG:
                return windchillUnit;
            default:
                return "";
        }
    }

    // Static public methods
    //
    static public List<TiempoComR3_Report> parseApiReport(TiempoComR3_ReportAPI reportApi) {
        List<TiempoComR3_Report> result = new ArrayList<>();
        reportApi.getLocation().getDay().stream().forEach((dayAPI) -> {
            dayAPI.getHour().stream().forEach((hourAPI) -> {
                TiempoComR3_Report report = new TiempoComR3_Report();
                report.fTimestamp = getTimestamp(dayAPI.getValue(), hourAPI.getValue());
                report.clouds = hourAPI.getClouds().getValue();
                report.humidity = hourAPI.getHumidity().getValue();
                report.pressureValue = hourAPI.getPressure().getValue();
                report.pressureUnit = hourAPI.getPressure().getUnit();
                report.rainValue = hourAPI.getRain().getValue();
                report.rainUnit = hourAPI.getRain().getUnit();
                report.snowlineValue = hourAPI.getSnowline().getValue();
                report.snowlineUnit = hourAPI.getSnowline().getUnit();
                report.tempValue = hourAPI.getTemp().getValue();
                report.tempUnit = hourAPI.getTemp().getUnit();
                report.windValue = hourAPI.getWind().getValue();
                report.windUnit = hourAPI.getWind().getUnit();
                report.windDir = hourAPI.getWind().getDir();
                report.windGustsValue = hourAPI.getWindGusts().getValue();
                report.windGustsUnit = hourAPI.getWindGusts().getUnit();
                report.windchillValue = hourAPI.getWindchill().getValue();
                report.windchillUnit = hourAPI.getWindchill().getUnit();
                result.add(report);
            });
        });
        return result;
    }

    static public Map<String, String> getParamList(String requestTimestampKey, String requestTimestampValue) {
        Map<String, String> result = new LinkedHashMap<>();
        result.put(requestTimestampKey, requestTimestampValue);
        result.put("fTimestamp", "Forecast timestamp");
        result.put("clouds", "Clouds");
        result.put("humidity", "Humidity");
        result.put("pressureValue", "Pressure value");
        result.put("pressureUnit", "Pressure unit");
        result.put("rainValue", "Rain value");
        result.put("rainUnit", "Rain unit");
        result.put("snowlineValue", "Snowline value");
        result.put("snowlineUnit", "Snowline unit");
        result.put("tempValue", "Temperature value");
        result.put("tempUnit", "Temperatura unit");
        result.put("windValue", "Wind value");
        result.put("windUnit", "Wind unit");
        result.put("windDir", "Wind direction");
        result.put("windGustsValue", "Wind Gust Value");
        result.put("windGustsUnit", "Wind Gusts Unit");
        result.put("windchillValue", "Windchill Value");
        result.put("windchillUnit", "Windchill Unit");
        return result;
    }

    // Protected methods 
    //
    /**
     * Returns timestamp for a YYYYMMDD format integer date value
     *
     * @param fullDayValue Date in YYYYMMDD format
     * @param hourString Hour string in HH:MM format
     * @return Timestamp for fullDayValue
     */
    static protected long getTimestamp(int fullDayValue, String hourString) {
        String fullDayString = Integer.toString(fullDayValue);
        int year = Integer.parseInt(fullDayString.substring(0, 4));
        int monthZeroBased = Integer.parseInt(fullDayString.substring(4, 6)) - 1;
        int day = Integer.parseInt(fullDayString.substring(6, 8));
        int hour = Integer.parseInt(hourString.substring(0, 2));
        int minute = Integer.parseInt(hourString.substring(3, 5));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0); // Reset millis
        cal.set(year, monthZeroBased, day, hour, minute, 0);
        Date date = cal.getTime();
        return date.getTime();
    }

}
