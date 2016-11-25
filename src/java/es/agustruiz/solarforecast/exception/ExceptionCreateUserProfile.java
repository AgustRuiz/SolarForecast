package es.agustruiz.solarforecast.exception;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class ExceptionCreateUserProfile extends Exception {
    
    public ExceptionCreateUserProfile (String message){
        super(message);
    }

    public ExceptionCreateUserProfile() {
        super();
    }
    
}
