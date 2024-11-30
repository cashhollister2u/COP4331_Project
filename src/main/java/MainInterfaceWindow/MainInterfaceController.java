/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// MainInterfaceController.java
package MainInterfaceWindow;

import SharedViews.GridBox;
import SharedModels.CurrentMonth;
import SharedViews.WeekEvent;
import SharedViews.DayEvent;
import SharedModels.Event;
import PlannerSystem.PlannerSystem;
import SharedModels.UserAccount;
import SharedViews.TaskBarController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class represents the main interface of the planner application.
 * It contains the taskbar and a central panel for displaying different views.
 *
 * @author andrewcoggins
 */
public class MainInterfaceController {
    private PlannerSystem systemInstance = PlannerSystem.getInstance();
    private UserAccount userAccount = systemInstance.getUserAccount();
    private List<Event> accountEvents = userAccount.getEvents();
    private JFrame frame;
    /**
     * Constructs the MainInterface and initializes its components.
     */
    public MainInterfaceController() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Main Interface");
        
        // Add the taskbar panel to the west of the frame
        TaskBarController taskbarPanel = new TaskBarController(frame);
        frame.add(taskbarPanel, BorderLayout.WEST);
        // week container
        JPanel weekContainerPanel = new JPanel(new FlowLayout());
        JPanel weekCompsPanel = new JPanel(new GridLayout(1, 7));
        weekContainerPanel.add(weekCompsPanel);
        
        // day containter
        JPanel todayContainerPanel = new JPanel(new FlowLayout());
        JPanel todayCompsPanel = new JPanel(new GridLayout(1, 7));
        todayContainerPanel.add(todayCompsPanel);
        
        // init CurrentMonth Object
        CurrentMonth currentMonth = new CurrentMonth();
        
        // Populate week components
        List<String> weekDays = currentMonth.getCurrentWeek();
        String todayDate = currentMonth.getTodayDate();
        for (int x = 0; x < weekDays.size(); x++) {
            String currDate = weekDays.get(x);
            JLabel dateString = new JLabel(currDate);
            
            // change color based on current day
            if (currDate.substring(0,2).equals(todayDate)) {
                dateString.setForeground(Color.BLUE);

            }
            
            // generate grid box for each day
            GridBox box = new GridBox(dateString, 150, 800);
            
            // assign events to day of week
            assignWeekEvents(currDate, box);
            
            weekCompsPanel.add(box);
        }

        // Populate Today components
        String today = currentMonth.getToday();
        JLabel dateString = new JLabel(today);
        GridBox box = new GridBox(dateString, 450, 800);
        assignTodayEvents(today, box);
        todayCompsPanel.add(box);
        
        // frame settings
        frame.add(todayContainerPanel, BorderLayout.CENTER);
        frame.add(weekContainerPanel, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void assignWeekEvents(String currDay, GridBox box) {
        String currDate = currDay.substring(0, 2);
        
        for (Event event : this.accountEvents) {
            String eventDate = event.getDate().toString().substring(8,10); 
            if (currDate.equals(eventDate)){
                WeekEvent weekEvent = new WeekEvent(event, frame);
                box.addEvent(weekEvent);
            }
        }
    }
    
    private void assignTodayEvents(String currDay, GridBox box) {
        String currDate = currDay.substring(0, 2);
        
        for (Event event : this.accountEvents) {
            String eventDate = event.getDate().toString().substring(8,10); 
            if (currDate.equals(eventDate)){
                DayEvent dayEvent = new DayEvent(event, frame);
                box.addEvent(dayEvent);
            }
        }
    }
}
