package es.agustruiz.solarforecast.service;

import es.agustruiz.solarforecast.model.LogLine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class MyLogger {

    private static final String LOG_TAG = MyLogger.class.getName();

//    private static final String LOG_FILE_PATH = "../../log.txt";
//    private static final String LOG_FILE_CHARSET = "utf-8";
    
    private static List<LogLine> listLog = null;

    public static void d(String from, String message) {
        addLine(new LogLine(from, LogLine.DEBUG, message));
    }

    public static void i(String from, String message) {
        addLine(new LogLine(from, LogLine.INFO, message));
    }

    public static void w(String from, String message) {
        addLine(new LogLine(from, LogLine.WARNING, message));
    }

    public static void e(String from, String message) {
        addLine(new LogLine(from, LogLine.ERROR, message));
    }

    public static List<LogLine> getLog() {
        return listLog;
    }

    private static void addLine(LogLine line) {
        if (listLog == null) {
            listLog = new ArrayList<>();
        }
        listLog.add(0, line);

//        String lineString = line.toString();
//        if (line.getMode() == LogLine.ERROR || line.getMode() == LogLine.WARNING) {
//            System.err.println(lineString);
//        } else {
//            System.out.println(lineString);
//        }
//        
//        BufferedWriter bufferedWriter = null;
//        try {
//            FileWriter fileWriter = new FileWriter(LOG_FILE_PATH);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(lineString);
//            bufferedWriter.newLine();
//            bufferedWriter.flush();
//            bufferedWriter.close();
//        } catch (IOException ex) {
//            System.err.println("Error in MyLogger: " + ex.getMessage());
//        }

    }

}
