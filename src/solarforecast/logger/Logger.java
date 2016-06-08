/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solarforecast.logger;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class Logger {

    public static final String LOG_TAG = Logger.class.getName();

    private static final String LOG_FILE_PATH = "./log.txt";
    private static final String LOG_FILE_CHARSET = "utf-8";

    private static final char MODE_DEBUG = 'D';
    private static final char MODE_INFO = 'I';
    private static final char MODE_WARNING = 'W';
    private static final char MODE_ERROR = 'E';

    private static Writer writer = null;

    /**
     * Add debug line
     *
     * @param from From class
     * @param message Message
     */
    public static void d(String from, String message) {
        addLine(from, message, MODE_DEBUG);
    }

    /**
     * Add info line
     *
     * @param from From class
     * @param message Message
     */
    public static void i(String from, String message) {
        addLine(from, message, MODE_INFO);
    }

    /**
     * Add warning line
     *
     * @param from From class
     * @param message Message
     */
    public static void w(String from, String message) {
        addLine(from, message, MODE_WARNING);
    }

    /**
     * Add error line
     *
     * @param from From class
     * @param message Message
     */
    public static void e(String from, String message) {
        addLine(from, message, MODE_ERROR);
    }

    /**
     * Add line
     *
     * @param from From class
     * @param message Message
     * @param mode Mode
     */
    private static void addLine(String from, String message, char mode) {
        String line = String.format("%s;%s;%s;%s\n", getDateTime(), mode, from, message);
        if (mode == MODE_ERROR || mode == MODE_WARNING) {
            System.err.print(line);
        } else {
            System.out.print(line);
        }
        if (prepareLogFile()) {
            try {
                writer.write(line);
            } catch (IOException ex) {
                System.err.println("Can´t add line in log file: " + ex.toString());
            }
        } else {
            System.err.println("Can´t add line in log file");
        }
    }
    
    /**
     * Prepare log file
     *
     * @return True if file is ready or false otherwise
     */
    private static boolean prepareLogFile() {
        if (writer == null) {
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(LOG_FILE_PATH), LOG_FILE_CHARSET));
            } catch (UnsupportedEncodingException | FileNotFoundException ex) {
                writer = null;
                System.err.println("Error creating log file: " + ex.toString());
                //java.util.logging.Logger.getLogger(LOG_TAG).log(Level.SEVERE, null, ex);
            }
        }
        return writer != null;
    }
    
    /**
     * Get date time string
     *
     * @return Current date and time in string format
     */
    private static String getDateTime() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

}
