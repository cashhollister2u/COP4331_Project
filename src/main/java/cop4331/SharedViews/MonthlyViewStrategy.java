/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cop4331.SharedViews;

import cop4331.SharedModels.CurrentMonth;
import cop4331.System.PlannerSystem;
import cop4331.SharedModels.UserAccount;
import cop4331.SharedModels.Event;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Concrete strategy for creating the monthly calendar view.
 * @author andrewcoggins
 */

public class MonthlyViewStrategy implements CalendarViewStrategy {
    /**
     * {@inheritDoc}
     * 
     * Creates and returns a JPanel representing the monthly calendar view.
     */
    @Override
    public JPanel createCalendarView(JFrame frame) {
        JPanel calendarContainerPanel = new JPanel(new FlowLayout());
        JPanel calendarCompsPanel = new JPanel(new GridLayout(5, 7));
        calendarContainerPanel.add(calendarCompsPanel);

        PlannerSystem systemInstance = PlannerSystem.getInstance();
        UserAccount userAccount = systemInstance.getUserAccount();
        List<Event> accountEvents = userAccount.getEvents();

        CurrentMonth currentMonth = new CurrentMonth();
        String todayDate = currentMonth.getTodayDate();
        List<LocalDate> monthDates = currentMonth.getDates();

        for (int x = 0; x < monthDates.size(); x++) {
            String currDate = monthDates.get(x).toString().substring(8,10);
            JLabel dateString = new JLabel(currDate);

            // change color based on current day
            if (currDate.substring(0,2).equals(todayDate)) {
                dateString.setForeground(Color.BLUE);
            }

            // generate grid box for each day
            GridBox box = new GridBox(dateString, 150, 150);

            currDate = currDate.substring(0, 2);
            for (Event event : accountEvents) {
                String eventDate = event.getDate().toString().substring(8,10);
                if (currDate.equals(eventDate)){
                    MonthEvent monthEvent = new MonthEvent(event, frame);
                    box.addEvent(monthEvent);
                }
            }

            calendarCompsPanel.add(box);
        }

        return calendarContainerPanel;
    }
}
