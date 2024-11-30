/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cop4331.gui;

import cop4331.SharedViews.GridBox;
import cop4331.SharedModels.CurrentMonth;
import cop4331.SharedViews.WeekEvent;
import cop4331.SharedModels.Event;
import cop4331.System.PlannerSystem;
import cop4331.SharedModels.UserAccount;
import cop4331.SharedViews.TaskBarController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class represents the main interface of the planner application.
 * It contains the taskbar and a central panel for displaying the current week.
 *
 * @author andrewcoggins
 */
public class MainInterfaceController {
    private PlannerSystem systemInstance = PlannerSystem.getInstance();
    private UserAccount userAccount = systemInstance.getUserAccount();
    private List<Event> accountEvents = userAccount.getEvents();
    private JFrame frame;
    private JPanel mainPanel; // Main panel to hold the week view

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

        // Create the main panel 
        mainPanel = new JPanel(new FlowLayout()); 

        // Week container
        JPanel weekContainerPanel = new JPanel(new FlowLayout());
        JPanel weekCompsPanel = new JPanel(new GridLayout(1, 7));
        weekContainerPanel.add(weekCompsPanel);

        // Initialize CurrentMonth Object
        CurrentMonth currentMonth = new CurrentMonth();

        // Populate week components
        List<String> weekDays = currentMonth.getCurrentWeek();
        String todayDate = currentMonth.getTodayDate();
        for (int x = 0; x < weekDays.size(); x++) {
            String currDate = weekDays.get(x);
            JLabel dateString = new JLabel(currDate);

            // Change color based on current day
            if (currDate.substring(0,2).equals(todayDate)) {
                dateString.setForeground(Color.BLUE);
            }

            // Generate grid box for each day
            GridBox box = new GridBox(dateString, 150, 800);

            // Assign events to day of week
            assignWeekEvents(currDate, box);

            weekCompsPanel.add(box);
        }

        // Add the week view to the main panel
        mainPanel.add(weekContainerPanel); 

        // Frame settings
        frame.add(mainPanel, BorderLayout.CENTER); // Add mainPanel to the frame
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
}
