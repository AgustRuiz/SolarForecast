package es.agustruiz.solarforecast.exception;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class ExceptionPasswordNotMatching extends Exception {

    public ExceptionPasswordNotMatching() {
        super();
    }

    public ExceptionPasswordNotMatching(String message) {
        super(message);
    }

}
