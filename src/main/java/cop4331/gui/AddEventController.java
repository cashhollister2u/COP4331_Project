/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cop4331.gui;

import cop4331.System.PlannerSystem;
import cop4331.SharedModels.UserAccount;
import cop4331.SharedModels.Event;
import cop4331.SharedViews.TaskBarController;
import cop4331.SharedModels.CurrentMonth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

/**
 * This class represents the window for adding new events to the calendar.
 * It provides a user interface with fields for entering event details.
 * @author cashhollister, andrewcogins
 */
public class AddEventController {
    private JPanel addEventPanel;

    /**
     * Constructs the AddEventWindow and initializes its components.
     */
    public AddEventController() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Add New Event");

        // Add the taskbar panel to the west of the frame
        TaskBarController taskbarPanel = new TaskBarController(frame);
        frame.add(taskbarPanel, BorderLayout.WEST);
        
        addEventPanel = new JPanel();
        addEventPanel.setLayout(new BorderLayout());

        // Create header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));

        headerPanel.add(Box.createVerticalStrut(20));
        headerPanel.add(Box.createVerticalStrut(20));

        // Create details panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        
        // Create and set up separate field panels
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.X_AXIS));
        JPanel timePanel = new JPanel();
        timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.X_AXIS));
        JPanel coursePanel = new JPanel();
        coursePanel.setLayout(new BoxLayout(coursePanel, BoxLayout.X_AXIS));
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.X_AXIS));
        JPanel priorityPanel = new JPanel();
        priorityPanel.setLayout(new BoxLayout(priorityPanel, BoxLayout.X_AXIS));
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JPanel completePanel = new JPanel();
        completePanel.setLayout(new BoxLayout(completePanel, BoxLayout.X_AXIS));
        JPanel conflictPanel = new JPanel();
        conflictPanel.setLayout(new BoxLayout(conflictPanel, BoxLayout.X_AXIS));
        

        // Separate panel components
        // Event title
        JLabel titleLabel = new JLabel("Title: ");
        JTextField titleField = new JTextField();
        // Event date
        JLabel dateLabel = new JLabel("Date: ");
        JComboBox<LocalDate> dateComboBox = new JComboBox<>();
        // Event time
        JLabel timeLabel = new JLabel("Time: ");
        JComboBox<String> timeComboBox = new JComboBox<>();
        // Event course 
        JLabel courseLabel = new JLabel("Course: ");
        JTextField courseField = new JTextField();
        // Event description
        JLabel descriptionLabel = new JLabel("Description: ");
        JTextArea descriptionField = new JTextArea();
        descriptionField.setLineWrap(true);
        // Event priority
        JLabel priorityLabel = new JLabel("Priority: ");
        JComboBox<String> priorityComboBox = new JComboBox<>();
        // Event status
        JLabel statusLabel = new JLabel("Status: ");
        JComboBox<String> statusComboBox = new JComboBox<>();
        // Event completion status
        JLabel completeLabel = new JLabel("Complete: ");
        JCheckBox completeBox = new JCheckBox();
        // Event conflict status
        JLabel conflictLabel = new JLabel("Conflict: ");
        JCheckBox conflictBox = new JCheckBox();
        
        
        // init CurrentMonth object
        CurrentMonth currentMonth = new CurrentMonth();
        // add dates to combo box
        List<LocalDate> dateList = currentMonth.getDates();
        for (LocalDate date : dateList) {
            dateComboBox.addItem(date);
        }
        
        // add times to combo box
        List<String> timeList = currentMonth.getTimes();
        for (String specificTime : timeList) {
            timeComboBox.addItem(specificTime);
        }
        
        // add priorities to combo box
        priorityComboBox.addItem("Low");
        priorityComboBox.addItem("Moderate");
        priorityComboBox.addItem("High");
        
        // add statuses to combo box
        statusComboBox.addItem("Not Started");
        statusComboBox.addItem("In Progress");
        statusComboBox.addItem("Test and Analysis");
        statusComboBox.addItem("Q and A");
        statusComboBox.addItem("Complete");
        
        
        // add components to specific panels
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);
        datePanel.add(dateLabel);
        datePanel.add(dateComboBox);
        timePanel.add(timeLabel);
        timePanel.add(timeComboBox);
        coursePanel.add(courseLabel);
        coursePanel.add(courseField);
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(descriptionField);
        priorityPanel.add(priorityLabel);
        priorityPanel.add(priorityComboBox);
        statusPanel.add(statusLabel);
        statusPanel.add(statusComboBox);
        completePanel.add(completeLabel);
        completePanel.add(completeBox);
        conflictPanel.add(conflictLabel);
        conflictPanel.add(conflictBox);
        
        // add specific panels to details panel
        detailsPanel.add(titlePanel);
        detailsPanel.add(datePanel);
        detailsPanel.add(timePanel);
        detailsPanel.add(coursePanel);
        detailsPanel.add(descriptionPanel);
        detailsPanel.add(priorityPanel);
        detailsPanel.add(statusPanel);
        detailsPanel.add(completePanel);
        detailsPanel.add(conflictPanel);
        
        
        // Set maximum size
        Dimension fieldSize = new Dimension(400, 30);
        Dimension descriptionSize = new Dimension(400, 120);
        titleField.setMaximumSize(fieldSize);
        dateComboBox.setMaximumSize(fieldSize);
        timeComboBox.setMaximumSize(fieldSize);
        priorityComboBox.setMaximumSize(fieldSize);
        statusComboBox.setMaximumSize(fieldSize);
        courseField.setMaximumSize(fieldSize);
        descriptionField.setMaximumSize(descriptionSize);
        
                
        // Submit button
        JButton addEvent = new JButton("Add Event");
        detailsPanel.add(addEvent);

        // Add panels to main panel
        addEventPanel.add(headerPanel, BorderLayout.NORTH);
        addEventPanel.add(detailsPanel, BorderLayout.CENTER); 
        
        // frame settings
        frame.setSize(700, 700);
        frame.add(addEventPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        addEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlannerSystem systemInstance = PlannerSystem.getInstance();
                UserAccount userAccount = systemInstance.getUserAccount();
                
                //get event inputs
                String eventTitle = titleField.getText();
                LocalDate eventDate = (LocalDate) dateComboBox.getSelectedItem();
                String eventTime = (String) timeComboBox.getSelectedItem();
                String eventCourse = courseField.getText();
                String eventDescription = descriptionField.getText();
                String eventPriority = (String) priorityComboBox.getSelectedItem();
                String eventStatus = (String) statusComboBox.getSelectedItem();
                boolean isEventComplete = completeBox.isSelected();
                boolean isEventConflict = conflictBox.isSelected();
                
                // create Event object w/ inputs
                Event newEvent = new Event(eventTitle, eventDate, eventTime, eventCourse, eventDescription, 
                        eventPriority, eventStatus, isEventComplete, isEventConflict);
                
                //get current account events
                List<Event> existingEvents = userAccount.getEvents();
                
                // if conflict update both events 
                for (Event event : existingEvents) {
                    if (event.checkConflict(newEvent)) {
                        event.setConflict(true);
                        newEvent.setConflict(true);
                    }
                }
                
                // add event to stored UserAccount instance
                userAccount.addEvent(newEvent);
                
                // save account update to the system
                systemInstance.saveUserAccount(userAccount);
                
                frame.dispose();
                
                new MainInterfaceController();
            }
        });
    }
}
