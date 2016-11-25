package es.agustruiz.solarforecast.exception;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class ExceptionCreateUserRole extends Exception {
    
    public ExceptionCreateUserRole (String message){
        super(message);
    }

    public ExceptionCreateUserRole() {
        super();
    }
    
}
