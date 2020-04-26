package ch.anakin.hotel_projekt.model;

/**
 * short description
 * <p>
 * user modelclass
 * <p>
 * Hotel_Projekt
 *
 * @author Anakin Krischler
 * @version 1.0
 * @since 07.04.20
 */
public class User {

    private String username;
    private String userRole;

    /**
     * Instantiates a new User.
     */
    public User() {
        userRole = "guest";
    }

    /**
     * Gets the username
     *
     * @return value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     *
     * @param username the value to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the user
     *
     * @return value of user
     */
    public String getUser() {
        return username;
    }

    /**
     * Sets the user
     *
     * @param user the value to set
     */
    public void setUser(String user) {
        this.username = user;
    }

    /**
     * Gets the userRole
     *
     * @return value of userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * Sets the userRole
     *
     * @param userRole the value to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
/**
    Service	Rolle
                guest	user	admin
        list	Nein	Ja	    Ja
        read	Nein	Ja	    Ja
        create	Nein	Ja	    Ja
        update	Nein	Nein	Ja
        delete	Nein	Nein	Ja
 */