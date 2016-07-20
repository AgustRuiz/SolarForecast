package es.agustruiz.solarforecast.exception;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class ExceptionCreateRepeatedUserProfile extends Exception {

    public ExceptionCreateRepeatedUserProfile(String message) {
        super(message);
    }

    public ExceptionCreateRepeatedUserProfile() {
        super();
    }

}
