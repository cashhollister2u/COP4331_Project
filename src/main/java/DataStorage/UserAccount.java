/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStorage;
import java.io.Serializable;
import java.util.List;

/**
 * Class utilized to store User Account data
 * @invariant events will be type Event, username and password will be Strings
 * @author cashhollister
 */
public class UserAccount implements Serializable {
    private String username;
    private String password;
    private List<Event> events;
    
    /**
     * Constructor utilized to create UserAccount Instance
     * @preconditions none
     * @postconditions UserAccount created
     * @param username
     * @param password
     * @param events 
     */
    public UserAccount(String username, String password, List<Event> events) {
        this.username = username;
        this.password = password;
        this.events = events;
    }
    
    /**
     * Public method to set username
     * @preconditons newUsername type String
     * @postconditions username is changed
     * @param newUsername 
     */
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }
    
    /**
     * Public method to set password
     * @preconditons newPassword type String
     * @postconditions password is changed
     * @param newPassword 
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
    /**
     * Public method to add Event
     * @preconditons event type Event
     * @postconditions event is added
     * @param newEvent 
     */
    public void addEvent(Event newEvent) {
        this.events.add(newEvent);
    }
    
    /**
     * Public method to remove Event
     * @preconditons event type Event
     * @postconditions event is removed from events
     * @param removedEvent 
     */
    public void removeEvent(Event removedEvent) {
        this.events.remove(removedEvent);
    }
    
    /**
     * Public method to get username
     * @preconditons none
     * @postconditions username is returned
     * @return String username
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Public method to get password
     * @preconditons none
     * @postconditions password is returned
     * @return String password
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * Public method to get events
     * @preconditons none
     * @postconditions events is returned
     * @return List<Event> events 
     */
    public List<Event> getEvents() {
        return this.events;
    }
}
