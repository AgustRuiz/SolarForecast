package es.agustruiz.solarforecast.model;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class ForecastPlace {
    
    protected long id;
    protected String name;
    protected float latitude;
    protected float longitude;

    public ForecastPlace() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
}
