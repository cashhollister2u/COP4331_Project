/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cop4331.CurrentDateDecorator;

import java.time.LocalDate;
import java.util.List;

/**
 * Class that acts as the Decorator for the EventDate Object for current week
 * @author cashhollister
 */
public class CurrentWeek implements CurrentDate {
    private CurrentDate eventDate;
    
    /**
     * Constructor to create EventCurrentWeek Object
     * @preconditions none
     * @postconditions EventCurrentWeek Object created
     * @param eventDate
     */
    public CurrentWeek(CurrentDate eventDate) {
        this.eventDate = eventDate;
    }
    
    /**
     * Method utilized to add dates to the dates List
     * @preconditions none
     * @postconditions list of dates generated
     */
    @Override
    public void generateDates() {
        eventDate.generateDates();
    }
    
    /**
     * Method utilized to get current dates in month
     * @preconditions none
     * @postconditions array list of dates
     * @return dates
     */
    @Override
    public List<LocalDate> getDates() {
        return eventDate.getDates();
    }
    
    /**
     * Method utilized to get times initialized locally
     * @preconditions none
     * @postconditions list of valid times
     * @return List<String> times
     */
    @Override
    public List<String> getTimes() {
        return eventDate.getTimes();
    }
    
    /**
     * Method utilized to get string values of current week
     * @preconditions none
     * @postconditions get string values of current week
     * @return List<String> thisWeek
     */
    @Override
    public List<String> getCurrentDays() {
        return eventDate.getCurrentDays();
    }
}
