/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cop4331.EventComposite;

import java.util.ArrayList;

/**
 * Class utilized to check for conflicts in the user's Planner instance
 * @author cashhollister
 */
public class ConflictsCheck implements EventConflict{
    private ArrayList<Event> events;
     
    /**
     * Constructor that generates an Empty array list
     */
    public ConflictsCheck() {
        this.events = new ArrayList<>();
    }
    
    /**
     * Public method to add event to Conflict Check list of events
     * @param event 
     */
    public void add(Event event) {
        this.events.add(event);
    }
    
    /**
     * Public method to check for conflicts in planner
     * @preconditions none
     * @postconditions conflict status returned
     * @return Boolean conflict
     */
    @Override
    public boolean getConflict() {
        boolean isConflict = false;
        for (Event event : events) {
            isConflict = event.getConflict();
            if (isConflict) {
                return isConflict;
            }
        }
        return isConflict;
    }
}
