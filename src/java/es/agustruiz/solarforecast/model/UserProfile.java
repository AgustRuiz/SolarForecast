package es.agustruiz.solarforecast.model;

import es.agustruiz.solarforecast.exception.ExceptionUserProfileState;
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
public class UserProfile implements Serializable {

    private static final String LOG_TAG = UserProfile.class.getName();

    public static final char STATE_ACTIVE = 0;
    public static final char STATE_SUSPENDED = 1;
    public static final char STATE_DELETED = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(unique = true, nullable = false, length=16)
    protected String name;

    @Column(nullable = false, length=16)
    protected String password;

    @Column(nullable = false)
    protected char profileState;

    // Constructor
    //
    public UserProfile() {
        profileState = STATE_ACTIVE;
    }

    // Getters & Setters
    //
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getProfileState() {
        return profileState;
    }

    public void setProfileState(char profileState) throws ExceptionUserProfileState {
        if (profileState == STATE_ACTIVE || profileState == STATE_SUSPENDED || profileState == STATE_DELETED) {
            this.profileState = profileState;
        } else {
            throw new ExceptionUserProfileState("Not valid user state");
        }
    }
    
    public boolean isActive(){
        return profileState == STATE_ACTIVE;
    }
    
    public boolean isSuspended(){
        return profileState == STATE_SUSPENDED;
    }
    
    public boolean isDeleted(){
        return profileState == STATE_DELETED;
    }

}
