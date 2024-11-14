/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author cashhollister
 */
public class AddEventWindow {
    public AddEventWindow() {
        // init JFrame
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());        
        
        // set up panels to contain components
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        
        //Header labels
        headerPanel.add(Box.createVerticalStrut(20));
        
        JLabel title = new JLabel("Planner Application");
        headerPanel.add(title);
        
        headerPanel.add(Box.createVerticalStrut(20));
        
        JLabel prompt = new JLabel("Add New Event:");
        headerPanel.add(prompt);
        
        headerPanel.add(Box.createVerticalStrut(20));
        
        // details components 
        JLabel titleLabel = new JLabel("Title: ");
        detailsPanel.add(titleLabel);
        JTextField titleField = new JTextField();
        titleField.setPreferredSize(new Dimension(200, 5));
        detailsPanel.add(titleField);
        
        JLabel dateLabel = new JLabel("Date: ");
        detailsPanel.add(dateLabel);
        JComboBox dateBox = new JComboBox();
        detailsPanel.add(dateBox);
        
        JLabel timeLabel = new JLabel("Time: ");
        detailsPanel.add(timeLabel);
        JComboBox timeBox = new JComboBox();
        detailsPanel.add(timeBox);
        
        JLabel courseLabel = new JLabel("Course: ");
        detailsPanel.add(courseLabel);
        JTextField dateField = new JTextField();
        dateField.setPreferredSize(new Dimension(200, 5));
        detailsPanel.add(dateField);
        
        JLabel descriptionLabel = new JLabel("Description: ");
        detailsPanel.add(descriptionLabel);
        JTextArea descriptionField = new JTextArea();
        descriptionField.setPreferredSize(new Dimension(200, 100));
        detailsPanel.add(descriptionField);
        
        JLabel priorityLabel = new JLabel("Priority: ");
        detailsPanel.add(priorityLabel);
        JCheckBox priorityBox = new JCheckBox();
        detailsPanel.add(priorityBox);
        
        JLabel statusLabel = new JLabel("Status: ");
        detailsPanel.add(statusLabel);
        JCheckBox statusBox = new JCheckBox();
        detailsPanel.add(statusBox);
        
        JLabel completeLabel = new JLabel("Complete: ");
        detailsPanel.add(completeLabel);
        JCheckBox completeBox = new JCheckBox();
        detailsPanel.add(completeBox);
        
        JLabel conflictLabel = new JLabel("Conflict: ");
        detailsPanel.add(conflictLabel);
        JCheckBox conflictBox = new JCheckBox();
        detailsPanel.add(conflictBox);
        
        
        
        // butons
        JButton submitButton = new JButton("Add Event");
        detailsPanel.add(submitButton);
        
        
        // add the panels to the frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(detailsPanel);
        
        // Display objects in frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
}
