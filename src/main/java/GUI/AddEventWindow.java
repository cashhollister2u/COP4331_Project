/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the window for adding new events to the calendar.
 * It provides a user interface with fields for entering event details.
 *
 * @author cashhollister, andrewcogins
 */
public class AddEventWindow extends JFrame {
    private JPanel addEventPanel;

    /**
     * Constructs the AddEventWindow and initializes its components.
     */
    public AddEventWindow() {
        this.setLayout(new BorderLayout());
        this.setTitle("Add New Event");

        // Add the taskbar panel to the west of the frame
        TaskBar taskbarPanel = new TaskBar(this);
        this.add(taskbarPanel, BorderLayout.WEST);
        
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
        JTextField dateField = new JTextField(10);
        // Event time
        JLabel timeLabel = new JLabel("Time: ");
        JTextField timeField = new JTextField(10);
        // Event course 
        JLabel courseLabel = new JLabel("Course: ");
        JTextField courseField = new JTextField();
        // Event description
        JLabel descriptionLabel = new JLabel("Description: ");
        JTextArea descriptionField = new JTextArea();
        descriptionField.setLineWrap(true);
        // Event priority
        JLabel priorityLabel = new JLabel("Priority: ");
        JCheckBox priorityBox = new JCheckBox();
        // Event status
        JLabel statusLabel = new JLabel("Status: ");
        JCheckBox statusBox = new JCheckBox();
        // Event completion status
        JLabel completeLabel = new JLabel("Complete: ");
        JCheckBox completeBox = new JCheckBox();
        // Event conflict status
        JLabel conflictLabel = new JLabel("Conflict: ");
        JCheckBox conflictBox = new JCheckBox();
        
        // add components to specific panels
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);
        datePanel.add(dateLabel);
        datePanel.add(dateField);
        timePanel.add(timeLabel);
        timePanel.add(timeField);
        coursePanel.add(courseLabel);
        coursePanel.add(courseField);
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(descriptionField);
        priorityPanel.add(priorityLabel);
        priorityPanel.add(priorityBox);
        statusPanel.add(statusLabel);
        statusPanel.add(statusBox);
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
        dateField.setMaximumSize(fieldSize);
        timeField.setMaximumSize(fieldSize);
        courseField.setMaximumSize(fieldSize);
        descriptionField.setMaximumSize(descriptionSize);
        
                
        // Submit button
        JButton submitButton = new JButton("Add Event");
        detailsPanel.add(submitButton);

        // Add panels to main panel
        addEventPanel.add(headerPanel, BorderLayout.NORTH);
        addEventPanel.add(detailsPanel, BorderLayout.CENTER); 
        
        // frame settings
        this.setSize(700, 700);
        this.add(addEventPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
