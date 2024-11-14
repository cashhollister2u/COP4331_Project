/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.time.LocalTime;

/**
 *
 * @author cashhollister
 */
public class EventDetailsWindow {
    public EventDetailsWindow(String title, Date date, LocalTime time, String course, String description, 
            String priority, boolean status, boolean complete, boolean conflict) {
        
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
        
        JLabel headerLabel = new JLabel("Planner Application");
        headerPanel.add(headerLabel);
        
        headerPanel.add(Box.createVerticalStrut(20));
        
        JLabel prompt = new JLabel("Add New Event:");
        headerPanel.add(prompt);
        
        headerPanel.add(Box.createVerticalStrut(20));
        
        // details components 
        detailsPanel.add(Box.createVerticalStrut(40));
        
        JLabel titleLabel = new JLabel("Title: " + title);
        detailsPanel.add(titleLabel);
        detailsPanel.add(Box.createVerticalStrut(20));
        
        JLabel dateLabel = new JLabel("Date: " + date.toString());
        detailsPanel.add(dateLabel);
        detailsPanel.add(Box.createVerticalStrut(20));
        
        JLabel timeLabel = new JLabel("Time: " + time.toString());
        detailsPanel.add(timeLabel);
        detailsPanel.add(Box.createVerticalStrut(20));
        
        JLabel courseLabel = new JLabel("Course: " + course);
        detailsPanel.add(courseLabel);
        detailsPanel.add(Box.createVerticalStrut(20));
        
        JLabel descriptionLabel = new JLabel("Description: " + description);
        detailsPanel.add(descriptionLabel);
        detailsPanel.add(Box.createVerticalStrut(20));
        
        JLabel priorityLabel = new JLabel("Priority: " + priority);
        detailsPanel.add(priorityLabel);
        detailsPanel.add(Box.createVerticalStrut(20));
        
        JLabel statusLabel = new JLabel("Status: " + status);
        detailsPanel.add(statusLabel);
        detailsPanel.add(Box.createVerticalStrut(20));
        
        JLabel completeLabel = new JLabel("Complete: " + complete);
        detailsPanel.add(completeLabel);
        detailsPanel.add(Box.createVerticalStrut(20));
        
        JLabel conflictLabel = new JLabel("Conflict: " + conflict);
        detailsPanel.add(conflictLabel);
        detailsPanel.add(Box.createVerticalStrut(60));
        
        
        
        // butons
        JButton editButton = new JButton("Edit Event");
        detailsPanel.add(editButton);
        
        JButton deleteButton = new JButton("Delete Event");
        detailsPanel.add(deleteButton);
        
        
        // add the panels to the frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(detailsPanel);
        
        // Display objects in frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 650);
        frame.setVisible(true);
    }
    
}
