package es.agustruiz.solarforecast.model;

import es.agustruiz.solarforecast.exception.ExceptionNegativeFrequency;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Entity
public class ForecastProvider implements Serializable {

    // Attributes
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column
    protected String name;

    @Column
    protected int queryFrequencyMillis;

    @Column(columnDefinition="tinyint(1) default 1")
    protected boolean active;

    // Constructors
    public ForecastProvider() {
        active = true;
    }

    // Getters and setters
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

    public int getQueryFrequencyMillis() {
        return queryFrequencyMillis;
    }

    public void setQueryFrequencyMillis(int queryFrequencyMillis) throws ExceptionNegativeFrequency {
        if (queryFrequencyMillis <= 0) {
            throw new ExceptionNegativeFrequency("Forecast provider query frequency must be a positive value (in millis)");
        } else {
            this.queryFrequencyMillis = queryFrequencyMillis;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
