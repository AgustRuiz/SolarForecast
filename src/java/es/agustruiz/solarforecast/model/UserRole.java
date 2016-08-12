package es.agustruiz.solarforecast.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userRole", "userProfile_id"}))
public class UserRole implements Serializable {

    protected static final String LOG_TAG = UserRole.class.getName();

    public static final String DEFAULT_ROLE = "ROLE_USER";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userProfile_id", nullable = false)
    protected UserProfile userProfile;

    @Column(name = "userRole")
    protected String userRole;

    // Constructor
    //
    public UserRole() {
    }

    public UserRole(UserProfile userProfile, String userRole) {
        this.userProfile = userProfile;
        this.userRole = userRole;
    }

    // Getters and Setters
    //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
