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
import java.util.List;

/**
 *
 * @author andrewcoggins
 */

public class DailyViewStrategy implements CalendarViewStrategy {
    @Override
    public JPanel createCalendarView(JFrame frame) {
        JPanel todayContainerPanel = new JPanel(new FlowLayout());
        JPanel todayCompsPanel = new JPanel(new GridLayout(1, 7));
        todayContainerPanel.add(todayCompsPanel);

        PlannerSystem systemInstance = PlannerSystem.getInstance();
        UserAccount userAccount = systemInstance.getUserAccount();
        List<Event> accountEvents = userAccount.getEvents();

        CurrentMonth currentMonth = new CurrentMonth();
        String today = currentMonth.getToday();
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
