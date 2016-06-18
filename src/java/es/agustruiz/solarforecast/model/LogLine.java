package es.agustruiz.solarforecast.model;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class LogLine {

    private static final String LOG_TAG = LogLine.class.getName();
    
    public static final char DEBUG = 'D';
    public static final char INFO = 'I';
    public static final char WARNING = 'W';
    public static final char ERROR = 'E';

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Long id;
    
    @Column
    protected String timeDate;
    
    @Column
    protected String from;
    
    @Column
    protected char mode;
    
    @Column
    protected String message;

    public LogLine(String from, char mode, String message) {
        this.timeDate = getCurrentDateTime();
        this.from = from;
        this.mode = mode;
        this.message = message;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public char getMode() {
        return mode;
    }

    public void setMode(char mode) {
        this.mode = mode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s", timeDate, mode, from, message);
    }

    private static String getCurrentDateTime() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

}
