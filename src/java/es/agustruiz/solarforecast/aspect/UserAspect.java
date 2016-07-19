package es.agustruiz.solarforecast.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Component
@Aspect
public class UserAspect {

    public UserAspect() {
        System.out.println("*****");
        System.out.println("UserAspect class constructor...");
    }
    
    

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void isController() {}

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void isService() {}

    @Pointcut("execution(* *(..))")
    public void anyMethod() {}

    @Before("isController() && anyMethod() ")
    public void beforeMethodInControllerClass() {
        System.out.println("*****");
        System.out.println("Before execute controller method..");
    }

    @Before("isService() && anyMethod() ")
    public void beforeMethodInServiceClass() {
        System.out.println("*****");
        System.out.println("Before execute service method..");
    }
    
    
    
    
    
    
    

}
