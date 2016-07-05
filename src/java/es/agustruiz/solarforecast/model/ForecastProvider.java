package es.agustruiz.solarforecast.model;

import es.agustruiz.solarforecast.exception.ExceptionNotValidFrequency;
import es.agustruiz.solarforecast.service.ForecastService;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

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
    protected String providerName;

    @Column
    protected int queryFrequencyMillis;

    @Column(columnDefinition = "tinyint(1) default 1")
    protected boolean active;

    // Constructors
    protected ForecastProvider() {
    }

    public ForecastProvider(String providerName, int queryFrequencyMillis) throws ExceptionNotValidFrequency {
        setProviderName(providerName);
        setQueryFrequencyMillis(queryFrequencyMillis);
        active = true;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getQueryFrequencyMillis() {
        return queryFrequencyMillis;
    }

    public void setQueryFrequencyMillis(int queryFrequencyMillis) throws ExceptionNotValidFrequency {
        if (queryFrequencyMillis <= 0) {
            throw new ExceptionNotValidFrequency("Forecast provider query frequency must be a positive value (in millis)");
        } else if (!ForecastService.getQueryFrequencyMap().containsKey(queryFrequencyMillis)) {
            throw new ExceptionNotValidFrequency("Query frequency has not a valid value");
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
