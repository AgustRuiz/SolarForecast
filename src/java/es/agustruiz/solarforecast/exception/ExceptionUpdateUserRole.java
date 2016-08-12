package es.agustruiz.solarforecast.exception;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class ExceptionUpdateUserRole extends Exception {
    
    public ExceptionUpdateUserRole (String message){
        super(message);
    }

    public ExceptionUpdateUserRole() {
        super();
    }
    
}
