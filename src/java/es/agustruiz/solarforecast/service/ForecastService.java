/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.agustruiz.solarforecast.service;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class ForecastService {
    
    static boolean forecastServiceStatus = false;

    public static boolean getForecastServiceStatus() {
        return forecastServiceStatus;
    }

    public static void setForecastServiceStatus(boolean forecastServiceStatus) {
        ForecastService.forecastServiceStatus = forecastServiceStatus;
    }

    public static boolean switchForecastServiceStatus() {
        forecastServiceStatus = !forecastServiceStatus;
        return forecastServiceStatus;
    }
    
}
