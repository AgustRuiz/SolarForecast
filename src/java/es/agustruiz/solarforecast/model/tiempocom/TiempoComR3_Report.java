package es.agustruiz.solarforecast.model.tiempocom;

import es.agustruiz.solarforecast.model.api.tiempocom.TiempoComR3_ReportAPI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
public class TiempoComR3_Report implements Serializable {

    // Attributes
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected long fTimestamp;

    @Column
    protected String clouds;

    @Column
    protected Integer humidity;

    @Column
    protected Integer pressureValue;

    @Column
    protected String pressureUnit;

    @Column
    protected Integer rainValue;

    @Column
    protected String rainUnit;

    @Column
    protected Integer snowlineValue;

    @Column
    protected String snowlineUnit;

    @Column
    protected Integer tempValue;

    @Column
    protected String tempUnit;

    @Column
    protected Integer windValue;

    @Column
    protected String windUnit;

    @Column
    protected String windDir;

    @Column
    protected Integer windGustsValue;

    @Column
    protected String windGustsUnit;

    @Column
    protected Integer windchillValue;

    @Column
    protected String windchillUnit;

    // Public methods
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
