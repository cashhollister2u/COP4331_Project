/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cop4331.CurrentDateDecorator;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface for the CurrentDate Decorator
 * @invariant the list of times, currentMonth, and numberOfDays remain constant after object creation
 * @author cashhollister
 */
public interface CurrentDate {
    
    /**
     * Method utilized to add dates to the dates List
     * @preconditions none
     * @postconditions list of dates generated
     */
    public void generateDates();
    
    /**
     * Method utilized to get current dates in month
     * @preconditions none
     * @postconditions array list of dates
     * @return dates
     */
    public List<LocalDate> getDates();
    
    /**
     * Method utilized to get times initialized locally
     * @preconditions none
     * @postconditions list of valid times
     * @return List<String> times
     */
    public List<String> getTimes();
    
    /**
     * Method utilized to get string representing today 
     * @preconditions none
     * @postconditions string consisting of date and day of week
     * @return String today
     */
    public List<String> getCurrentDays();
    
}
