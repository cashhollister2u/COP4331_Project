/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cop4331.CalendarStrategy;

import cop4331.System.PlannerSystem;
import cop4331.SharedModels.UserAccount;
import cop4331.EventComposite.Event;
import cop4331.CurrentDateDecorator.EventDate;
import cop4331.CurrentDateDecorator.CurrentDate;
import cop4331.CurrentDateDecorator.CurrentDay;
import cop4331.SharedViews.GridBox;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * Concrete strategy for creating the daily calendar view.
 * @author andrewcoggins CashHollister
 */

public class DailyViewStrategy implements CalendarViewStrategy {
    /**
     * {@inheritDoc}
     * 
     * Creates and returns a JPanel representing the daily calendar view.
     */
    @Override
    public JPanel createCalendarView(JFrame frame) {
        JPanel todayContainerPanel = new JPanel(new FlowLayout());
        JPanel todayCompsPanel = new JPanel(new GridLayout(1, 7));
        todayContainerPanel.add(todayCompsPanel);

        PlannerSystem systemInstance = PlannerSystem.getInstance();
        UserAccount userAccount = systemInstance.getUserAccount();
        List<Event> accountEvents = userAccount.getEvents();
        
        // decorator pattern to get the String value corrisponding to today
        CurrentDate currentDate = new EventDate();
        CurrentDate eventCurrentDay = new CurrentDay(currentDate);
        String today = eventCurrentDay.getCurrentDays().get(0);
        
        JLabel dateString = new JLabel(today);
        GridBox box = new GridBox(dateString, 450, 800);

        String currDate = today.substring(0, 2);
        for (Event event : accountEvents) {
            String eventDate = event.getDate().toString().substring(8,10);
            if (currDate.equals(eventDate)){
                DayEvent dayEvent = new DayEvent(event, frame);
                box.addEvent(dayEvent);
            }
        }

        todayCompsPanel.add(box);
        return todayContainerPanel;
    }
}
