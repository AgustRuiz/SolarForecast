package es.agustruiz.solarforecast.model;

import es.agustruiz.solarforecast.exception.ExceptionUserProfileRole;
import es.agustruiz.solarforecast.exception.ExceptionUserProfileState;
import java.io.Serializable;
import java.security.MessageDigest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(unique = true, nullable = false, length = 16)
    protected String name;

    @Column(nullable = false, length = 32)
    protected String password;

    @Column(nullable = false, length = 1)
    @Type(type = "org.hibernate.type.StringType")
    protected String profileState = String.valueOf(STATE_ACTIVE);

    @Column(nullable = false, length = 16)
    protected String profileRole = ROLE_USER;

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
//        this.password = password;
        this.password = this.generatePasswordHash(password);
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

    public String getProfileRole() {
        return profileRole;
    }

    public void setProfileRole(String profileRole) throws ExceptionUserProfileRole {
        switch (profileRole) {
            case ROLE_ADMIN:
            case ROLE_USER:
                this.profileRole = profileRole;
                break;
            default:
                throw new ExceptionUserProfileRole("Not valid role!");
        }
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

    public boolean checkPassword(String plainPassword) {
        return (this.password == null ? generatePasswordHash(plainPassword) == null : this.password.equals(generatePasswordHash(plainPassword)));
    }

    // Private methods
    //
    private String generatePasswordHash(String plainPassword) {
        String generatedPassword = plainPassword;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(plainPassword.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (Exception ex) {
        }
        return generatedPassword;
    }
}
