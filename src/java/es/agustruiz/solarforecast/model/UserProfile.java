package es.agustruiz.solarforecast.model;

import es.agustruiz.solarforecast.exception.ExceptionUserProfileState;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Type;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Entity
public class UserProfile implements Serializable {

    private static final String LOG_TAG = UserProfile.class.getName();

    public static final char STATE_ACTIVE = 'A';
    public static final char STATE_SUSPENDED = 'S';
    public static final char STATE_DELETED = 'D';

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(unique = true, nullable = false, length = 16)
    protected String username;

    @Column(nullable = false, length = 32)
    protected String password;

    @Column(nullable = false, length = 1)
    @Type(type = "org.hibernate.type.StringType")
    protected String profileState = String.valueOf(STATE_ACTIVE);

    @OneToMany
    protected Set<UserRole> userRole = new HashSet<>();

    // Constructor
    //
    public UserProfile() {
    }

    // Getters & Setters
    //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
//        this.password = password;
        this.password = password;
    }

    public char getProfileState() {
        return profileState.charAt(0);
    }

    public void setProfileState(char profileState) throws ExceptionUserProfileState {
        switch (profileState) {
            case STATE_ACTIVE:
                setActivatedState();
                break;
            case STATE_SUSPENDED:
                setSuspendedState();
                break;
            case STATE_DELETED:
                setDeletedState();
                break;
            default:
                throw new ExceptionUserProfileState("Not valid user state");
        }
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    // Public methods
    //
    public boolean isActivatedState() {
        return (String.valueOf(STATE_ACTIVE) == null ? profileState == null : String.valueOf(STATE_ACTIVE).equals(profileState));
    }

    public void setActivatedState() {
        profileState = String.valueOf(STATE_ACTIVE);
    }

    public boolean isSuspendedState() {
        return (profileState == null ? String.valueOf(STATE_SUSPENDED) == null : profileState.equals(String.valueOf(STATE_SUSPENDED)));
    }

    public void setSuspendedState() {
        profileState = String.valueOf(STATE_SUSPENDED);
    }

    public boolean isDeletedState() {
        return (profileState == null ? String.valueOf(STATE_DELETED) == null : profileState.equals(String.valueOf(STATE_DELETED)));
    }

    public void setDeletedState() {
        profileState = String.valueOf(STATE_DELETED);
    }

    public boolean checkPassword(String password) {
        return (this.password != null && password != null ? this.password.equals(password) : false);
    }
}
