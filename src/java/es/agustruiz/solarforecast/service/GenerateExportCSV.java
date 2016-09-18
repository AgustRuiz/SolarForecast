package es.agustruiz.solarforecast.service;

import es.agustruiz.solarforecast.exception.ExceptionExportCSV;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Service
public class GenerateExportCSV {

    protected static final String LOG_TAG = ForecastService.class.getName();

    protected static final char DEFAULT_SEPARATOR = ';';

    @Autowired
    LogLineManager logManager;

    // Public methods
    //
    @SuppressWarnings("ConvertToTryWithResources")
    public String exportCSV(String basePath, String internalPath, List<List<String>> output) throws ExceptionExportCSV {
        String fileName = String.format("%d_export.csv", System.currentTimeMillis());
        String filePath = String.format("%s%s%s", basePath, internalPath, fileName);

        try {
            final File file = new File(filePath);
            final File directory = file.getParentFile();
            if (null != directory) {
                directory.mkdirs();
            }
            FileWriter writer = new FileWriter(file);
            for (List<String> line : output) {
                writeLine(writer, line);
            }
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            throw new ExceptionExportCSV(ex.getMessage());
        }

        return internalPath + fileName;
    }

    // Private methods
    //
    private static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    private static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    //https://tools.ietf.org/html/rfc4180
    private static String followCVSformat(String value) {
        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

    private static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {
        boolean first = true;
        //default customQuote is empty
        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }
            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }
}
