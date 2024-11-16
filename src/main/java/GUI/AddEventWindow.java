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
public class AddEventWindow {
    private JPanel addEventPanel;

    /**
     * Constructs the AddEventWindow and initializes its components.
     */
    public AddEventWindow() {
        addEventPanel = new JPanel();
        addEventPanel.setLayout(new BorderLayout());

        // Create header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Planner Application");
        headerPanel.add(title);

        headerPanel.add(Box.createVerticalStrut(20));

        JLabel prompt = new JLabel("Add New Event:");
        headerPanel.add(prompt);

        headerPanel.add(Box.createVerticalStrut(20));

        // Create details panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));

        // Event title
        JLabel titleLabel = new JLabel("Title: ");
        detailsPanel.add(titleLabel);
        JTextField titleField = new JTextField();
        titleField.setPreferredSize(new Dimension(200, 5));
        detailsPanel.add(titleField);

        // Event date
        JLabel dateLabel = new JLabel("Date: ");
        detailsPanel.add(dateLabel);
        JComboBox<String> dateBox = new JComboBox<>(); 
        detailsPanel.add(dateBox);

        // Event time
        JLabel timeLabel = new JLabel("Time: ");
        detailsPanel.add(timeLabel);
        JComboBox<String> timeBox = new JComboBox<>(); 
        detailsPanel.add(timeBox);

        // Event course (assuming this is relevant)
        JLabel courseLabel = new JLabel("Course: ");
        detailsPanel.add(courseLabel);
        JTextField dateField = new JTextField(); // Consider renaming to courseField
        dateField.setPreferredSize(new Dimension(200, 5));
        detailsPanel.add(dateField);

        // Event description
        JLabel descriptionLabel = new JLabel("Description: ");
        detailsPanel.add(descriptionLabel);
        JTextArea descriptionField = new JTextArea();
        descriptionField.setPreferredSize(new Dimension(200, 100));
        detailsPanel.add(descriptionField);

        // Event priority
        JLabel priorityLabel = new JLabel("Priority: ");
        detailsPanel.add(priorityLabel);
        JCheckBox priorityBox = new JCheckBox();
        detailsPanel.add(priorityBox);

        // Event status
        JLabel statusLabel = new JLabel("Status: ");
        detailsPanel.add(statusLabel);
        JCheckBox statusBox = new JCheckBox();
        detailsPanel.add(statusBox);

        // Event completion status
        JLabel completeLabel = new JLabel("Complete: ");
        detailsPanel.add(completeLabel);
        JCheckBox completeBox = new JCheckBox();
        detailsPanel.add(completeBox);

        // Event conflict status
        JLabel conflictLabel = new JLabel("Conflict: ");
        detailsPanel.add(conflictLabel);
        JCheckBox conflictBox = new JCheckBox();
        detailsPanel.add(conflictBox);

        // Submit button
        JButton submitButton = new JButton("Add Event");
        detailsPanel.add(submitButton);

        // Add panels to main panel
        addEventPanel.add(headerPanel, BorderLayout.NORTH);
        addEventPanel.add(detailsPanel, BorderLayout.CENTER); 
    }

    /**
     * Returns the main panel containing all the components of the AddEventWindow.
     *
     * @return The addEventPanel.
     */
    public JPanel getAddEventPanel() {
        return addEventPanel; 
    }
}