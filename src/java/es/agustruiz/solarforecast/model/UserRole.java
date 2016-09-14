package es.agustruiz.solarforecast.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Entity
@Table
public class UserRole implements Serializable {

    protected static final String LOG_TAG = UserRole.class.getName();

    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String DEFAULT_ROLE = ROLE_USER;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column
    protected String userRole;

    // Constructor
    //
    public UserRole() {
    }

    public UserRole(String userRole) {
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

//    public UserProfile getUserProfile() {
//        return userProfile;
//    }

//    public void setUserProfile(UserProfile userProfile) {
//        this.userProfile = userProfile;
//    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
