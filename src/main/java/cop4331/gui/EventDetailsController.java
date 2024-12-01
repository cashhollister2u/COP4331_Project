/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cop4331.gui;

import cop4331.System.PlannerSystem;
import cop4331.SharedModels.UserAccount;
import cop4331.EventComposite.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the window for displaying detailed information about an event.
 *
 * @author cashhollister, andrewcoggins
 */
public class EventDetailsController {
    private JPanel detailsPanel;
    /**
     * Constructor to generate an Event Details Window
     * @precondtions none
     * @postconditions Window generated
     * @param event
     */
    public EventDetailsController(Event event, JFrame currentframe) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Event Details");
        
        detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        
        // generate labels for each detail
        JLabel title = new JLabel(event.getTitle());
        JLabel course = new JLabel(event.getCourse());
        JLabel time = new JLabel(event.getTime());
        JLabel description = new JLabel(event.getDescription());
        JLabel priority = new JLabel(event.getPriority());
        JLabel status = new JLabel(event.getStatus());


        // generate details button
        JButton deleteButton = new JButton("Delete Event");

        // add detail labels
        detailsPanel.add(title);
        detailsPanel.add(course);
        detailsPanel.add(time);
        detailsPanel.add(description);
        detailsPanel.add(priority);
        detailsPanel.add(status);

        // handle complete status
        if (event.getComplete()) {
            JLabel complete = new JLabel("Completed");
            complete.setForeground(Color.GREEN);
            detailsPanel.add(complete);
        } else {
            JLabel complete = new JLabel("Not Completed");
            detailsPanel.add(complete);
        }

        // handle conflict status
        if (event.getConflict()) {
            JLabel conflict = new JLabel("Alert: Conflict with event");
            conflict.setForeground(Color.RED);
            detailsPanel.add(conflict);
        } else {
            JLabel conflict = new JLabel("No Conflicts with event");
            detailsPanel.add(conflict);
        }

        // add details button
        detailsPanel.add(deleteButton);

        // add space to bottom
        detailsPanel.add(Box.createVerticalStrut(20));
        
        frame.add(detailsPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlannerSystem systemInstance = PlannerSystem.getInstance();
                UserAccount userAccount = systemInstance.getUserAccount();
                userAccount.removeEvent(event);
                systemInstance.saveUserAccount(userAccount);
                frame.dispose();
                currentframe.dispose();
                new MainInterfaceController();
            }
        });
    }
}