/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cop4331.gui;

import cop4331.SharedViews.GridBox;
import cop4331.CalendarStrategy.WeekEvent;
import cop4331.EventComposite.Event;
import cop4331.System.PlannerSystem;
import cop4331.SharedModels.UserAccount;
import cop4331.EventComposite.ConflictsCheck;
import cop4331.SharedViews.TaskBarController;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import cop4331.CurrentDateDecorator.CurrentDate;
import cop4331.CurrentDateDecorator.CurrentDay;
import cop4331.CurrentDateDecorator.CurrentWeek;
import cop4331.CurrentDateDecorator.EventDate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the main interface of the planner application.
 * It contains the taskbar and a central panel for displaying the current week.
 *
 * @author andrewcoggins Cash Hollister
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
        JPanel taskbarPanel = new JPanel(new GridLayout(5, 1));
        TaskBarController taskbar = new TaskBarController(frame);
        //conflic check buton
        JButton conflictCheck = new JButton("Check For Conflicts");
        
        // add action listener that notifies the user of any exisiting conflicts
        conflictCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Event> events = userAccount.getEvents();
                ConflictsCheck conflictCheck = new ConflictsCheck();
                
                for (Event event : events) {
                    conflictCheck.add(event);
                }
                boolean isConflict = conflictCheck.getConflict();
                
                if (isConflict) {
                    JOptionPane.showMessageDialog(frame, "Conflict Found Check Calendar Page", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "No Conflicts Found", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        taskbarPanel.add(taskbar);
        taskbarPanel.add(conflictCheck);
        frame.add(taskbarPanel, BorderLayout.WEST);

        // Create the main panel 
        mainPanel = new JPanel(new FlowLayout()); 

        // Week container
        JPanel weekContainerPanel = new JPanel(new FlowLayout());
        JPanel weekCompsPanel = new JPanel(new GridLayout(1, 7));
        weekContainerPanel.add(weekCompsPanel);

        // Initialize CurrentDate Object
        // decorator pattern to get the String value corrisponding to today
        CurrentDate currentDate = new EventDate();
        CurrentDate eventCurrentWeek = new CurrentWeek(currentDate);
        // get today's date w/ CurrentDay decorator 
        CurrentDate eventCurrentDay = new CurrentDay(currentDate);
        // Populate week components
        List<String> weekDays = eventCurrentWeek.getCurrentDays();
        String todayDate = eventCurrentDay.getCurrentDays().get(0).substring(0,2);
        for (int x = 0; x < weekDays.size(); x++) {
            try { 
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
            } catch (Exception e) {
                System.out.println("failed at MainInterface week loop");
            }
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

     /**
     * Assigns events to the appropriate day in the week view.
     * 
     * @param currDay The current day's date string.
     * @param box The GridBox representing the day to which events should be assigned.
     */
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
