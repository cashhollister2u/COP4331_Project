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
 * This class represents the window for displaying detailed information about an event.
 *
 * @author cashhollister, andrewcoggins
 */
public class EventDetailsWindow {

    /**
     * Constructs the EventDetailsWindow and initializes its components with the provided event details.
     *
     * @param title       The title of the event.
     * @param date        The date of the event.
     * @param time        The time of the event.
     * @param course      The course associated with the event (if applicable).
     * @param description The description of the event.
     * @param priority    The priority of the event.
     * @param status      The status of the event.
     * @param complete    Indicates if the event is complete.
     * @param conflict    Indicates if there is a conflict with the event.
     */
    public EventDetailsWindow(String title, Date date, LocalTime time, String course, String description,
                              String priority, boolean status, boolean complete, boolean conflict) {

        // Initialize JFrame
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        // Create header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));

        JLabel headerLabel = new JLabel("Planner Application");
        headerPanel.add(headerLabel);
        headerPanel.add(Box.createVerticalStrut(20));

        JLabel prompt = new JLabel("Event Details:"); // Changed from "Add New Event:"
        headerPanel.add(prompt);
        headerPanel.add(Box.createVerticalStrut(20));

        // Create details panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.add(Box.createVerticalStrut(40));

        // Add event details labels
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

        // Add buttons
        JButton editButton = new JButton("Edit Event");
        detailsPanel.add(editButton);

        JButton deleteButton = new JButton("Delete Event");
        detailsPanel.add(deleteButton);

        // Add panels to frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(detailsPanel);

        // Set frame properties and display
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 650);
        frame.setVisible(true);
    }
}