/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cop4331.CurrentDateDecorator;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class the functions as the concrete component of the CurrentDate Decorator
 * @author cashhollister
 */
public class EventDate implements CurrentDate {
    private YearMonth currentMonth;
    private int numberOfDays;
    private List<LocalDate> dates;
    private List<String> times = Arrays.asList(
            "00:00 AM",
            "01:00 AM",
            "02:00 AM",
            "03:00 AM",
            "04:00 AM",
            "05:00 AM",
            "06:00 AM",
            "07:00 AM",
            "08:00 AM",
            "09:00 AM",
            "10:00 AM",
            "11:00 AM",
            "12:00 PM",
            "01:00 PM",
            "02:00 PM",
            "03:00 PM",
            "04:00 PM",
            "05:00 PM",
            "06:00 PM",
            "07:00 PM",
            "08:00 PM",
            "09:00 PM",
            "10:00 PM",
            "11:00 PM"
    );
    
    /**
     * Constructor to create CurrentMonth Object
     * @preconditions none
     * @postconditions CurrentMonth Object created
     */
    public EventDate() {
        this.currentMonth = YearMonth.now();
        this.numberOfDays = currentMonth.lengthOfMonth();
        this.dates = new ArrayList<>();
    }
    
    /**
     * Method utilized to add dates to the dates List
     * @preconditions none
     * @postconditions list of dates generated
     */
    @Override
    public void generateDates() {
        for (int x = 1; x <= numberOfDays; x++) {
            this.dates.add(currentMonth.atDay(x));
        }
        System.out.println("month " + currentMonth);
    }
    
    /**
     * Method utilized to get current dates in month
     * @preconditions none
     * @postconditions array list of dates
     * @return dates
     */
    @Override
    public List<LocalDate> getDates() {
        this.generateDates();
        System.out.println("dates " + dates);
        return this.dates;
    }
    
    /**
     * Method utilized to get times initialized locally
     * @preconditions none
     * @postconditions list of valid times
     * @return List<String> times
     */
    @Override
    public List<String> getTimes() {
        return this.times;
    }
    
    /**
     * Method utilized to get string values of current week
     * @preconditions none
     * @postconditions get string values of current week
     * @return List<String> thisWeek
     */
    @Override
    public List<String> getCurrentDays() {
        // empty list to contain days of this week
        List<String> thisWeek = new ArrayList<>();
        
        // init start date
        LocalDate start;
        if (LocalDate.now().getDayOfWeek().getValue() == 7) {
            // ensures that the day of the week will always start on the most recent sunday
            start = LocalDate.now();
        } else {
            // ensures that the day of the week will always start on the most recent sunday
            // finds current day thurs 28 => walkes back the days based on thursdays day value (4) => returns sunday 24th
            start = LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue());
        }
        // appends the day of the week to thisWeek until the currDay == end (Sunday)
            LocalDate currDay = start;
            for (int x = 0; x < 7; x++) {
                String dayToAdd = currDay.toString().substring(8, 10) + " - " + currDay.getDayOfWeek().toString();
                thisWeek.add(dayToAdd);
                currDay = currDay.plusDays(1);
            }

            return thisWeek;
        
    }
}
