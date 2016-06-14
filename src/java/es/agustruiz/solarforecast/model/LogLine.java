package es.agustruiz.solarforecast.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class LogLine {

    public static final char DEBUG = 'D';
    public static final char INFO = 'I';
    public static final char WARNING = 'W';
    public static final char ERROR = 'E';

    protected String timeDate;
    protected String from;
    protected char mode;
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
