package es.agustruiz.solarforecast.exception;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class ExceptionNotExistsUserProfile extends Exception {

    public ExceptionNotExistsUserProfile(String message) {
        super(message);
    }

    public ExceptionNotExistsUserProfile() {
        super();
    }

}
