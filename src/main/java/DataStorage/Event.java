/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStorage;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 * Class utilized to store Event data
 * @invariant types of instance variable will be constant
 * @author cashhollister
 */
public class Event {
    private String title;
    private LocalDate date;
    private String time;
    private String course;
    private String description;
    private String priority;
    private String status;
    private boolean complete;
    private boolean conflict;
   /**
    * Constructor utilized to create Event instance
    * @preconditions none
    * @postconditions Event created
    * @param title
    * @param date
    * @param time
    * @param course
    * @param description
    * @param priority
    * @param status
    * @param complete
    * @param conflict 
    */
    public Event(String title, LocalDate date, String time, String course, String description, 
            String priority, String status, boolean complete, boolean conflict) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.course = course;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.complete = complete;
        this.conflict = conflict;
    }
    
    /**
     * Public method to check for conflicts in Events
     * @preconditions Event input
     * @postconditions returns Boolean based on conflict status
     * @param other
     * @return Boolean 
     */
    public boolean checkConflict(Event other) {
        LocalDate otherDate = other.getDate();
        String otherTime = other.getTime();
        
        return !(otherDate == this.date && otherTime == this.time);
    } 
    
    /**
     * Public method to set title
     * @preconditions newTitle String
     * @postconditions title changed for Event
     * @param newTitle 
     */
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    
    /**
     * Public method to set date
     * @preconditions newDate Date
     * @postconditions date changed for Event
     * @param newDate 
     */
    public void setDate(LocalDate newDate) {
        this.date = newDate;
    }
    
    /**
     * Public method to set time
     * @preconditions newTime LocalTime
     * @postconditions time changed for Event
     * @param newTime 
     */
    public void setTime(String newTime) {
        this.time = newTime;
    }
    
    /**
     * Public method to set course
     * @preconditions newCourse String
     * @postconditions course changed for Event
     * @param newCourse 
     */
    public void setCourse(String newCourse) {
        this.course = newCourse;
    }
    
    /**
     * Public method to set description
     * @preconditions newDescription String
     * @postconditions description changed for Event
     * @param newDescription 
     */
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    
    /**
     * Public method to set priority
     * @preconditions newPriority String
     * @postconditions priority changed for Event
     * @param newPriority 
     */
    public void setPriority(String newPriority) {
        this.priority = newPriority;
    }
    
    /**
     * Public method to set status
     * @preconditions newStatus Boolean
     * @postconditions status changed for Event
     * @param newStatus 
     */
    public void setStatus(String newStatus) {
        this.status = newStatus;
    }
    
    /**
     * Public method to set complete
     * @preconditions newComplete Boolean
     * @postconditions complete changed for Event
     * @param newComplete 
     */
    public void setComplete(boolean newComplete) {
        this.complete = newComplete;
    }
    
    /**
     * Public method to set conflict
     * @preconditions newConflict Boolean
     * @postconditions conflict changed for Event
     * @param newConflict 
     */
    public void setConflict(boolean newConflict) {
        this.conflict = newConflict;
    }
    
    /**
     * Public method to get title
     * @preconditions none
     * @postconditions title returned
     * @return String title
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * Public method to get date
     * @preconditions none
     * @postconditions date returned
     * @return Date date
     */
    public LocalDate getDate() {
        return this.date;
    }
    
    /**
     * Public method to get time
     * @preconditions none
     * @postconditions time returned
     * @return LocalTime time
     */
    public String getTime() {
        return this.time;
    }
    
    /**
     * Public method to get course
     * @preconditions none
     * @postconditions course returned
     * @return String course
     */
    public String getCourse() {
        return this.course;
    }
    
    /**
     * Public method to get description
     * @preconditions none
     * @postconditions description returned
     * @return String description
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Public method to get priority
     * @preconditions none
     * @postconditions priority returned
     * @return String priority
     */
    public String getPriority() {
        return this.priority;
    }
    
    /**
     * Public method to get status
     * @preconditions none
     * @postconditions status returned
     * @return Boolean status
     */
    public String getStatus() {
        return this.status;
    }
    
    /**
     * Public method to get complete
     * @preconditions none
     * @postconditions complete returned
     * @return Boolean complete
     */
    public boolean getComplete() {
        return this.complete;
    }
    
    /**
     * Public method to get conflict
     * @preconditions none
     * @postconditions conflict returned
     * @return Boolean conflict
     */
    public boolean getConflict() {
        return this.conflict;
    }
}
