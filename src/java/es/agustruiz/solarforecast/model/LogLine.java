package es.agustruiz.solarforecast.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class LogLine implements Serializable{

    private static final String LOG_TAG = LogLine.class.getName();
    
    public static final char DEBUG = 'D';
    public static final char INFO = 'I';
    public static final char WARNING = 'W';
    public static final char ERROR = 'E';

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected long id;
    
    @Column
    protected long timeInMillis;
    
    @Column(name="fromCol")
    protected String from;
    
    @Column
    protected char mode;
    
    @Column
    protected String message;

    public LogLine() {
    }

    public LogLine(String from, char mode, String message) {
        this.timeInMillis = System.currentTimeMillis();
        this.from = from;
        this.mode = mode;
        this.message = message;
    }
    
    public String getTimeDateString(){
        return getCurrentDateTime(timeInMillis);
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(long timeInMillis) {
        this.timeInMillis = timeInMillis;
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
        return String.format("%s;%s;%s;%s", timeInMillis, mode, from, message);
    }

    private static String getCurrentDateTime(long millis) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return sdfDate.format(calendar.getTime());
    }

}
