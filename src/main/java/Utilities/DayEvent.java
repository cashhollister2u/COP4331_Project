/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import GUI.EventDetailsWindow;
import DataStorage.Event;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cashhollister
 */
public class DayEvent extends JPanel {
    Color color = Color.BLACK;
    
    public DayEvent(Event event, JFrame frame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       
        // generate labels for each detail
        JLabel title = new JLabel(event.getTitle());
        JLabel course = new JLabel(event.getCourse());
        JLabel time = new JLabel(event.getTime());
        JLabel description = new JLabel(event.getDescription());
        JLabel priority = new JLabel(event.getPriority());
        JLabel status = new JLabel(event.getStatus());
        
        
        // generate details button
        JButton detailsButton = new JButton("details");
        
        // add detail labels
        add(title);
        add(course);
        add(time);
        add(description);
        add(priority);
        add(status);
        
        // handle complete status
        if (event.getComplete()) {
            color = Color.GREEN;
            JLabel complete = new JLabel("Completed");
            add(complete);
        } else {
            JLabel complete = new JLabel("Not Completed");
            add(complete);
        }
        
        // handle conflict status
        if (event.getConflict()) {
            color = Color.RED;
            JLabel conflict = new JLabel("Alert: Conflict with event");
            add(conflict);
        } else {
            JLabel conflict = new JLabel("No Conflicts with event");
            add(conflict);
        }
        
        // add details button
        add(detailsButton);
        
        // add space to bottom
        add(Box.createVerticalStrut(20));
        
        //set color based on conditions of details
        for (Component component : this.getComponents()) {
            component.setForeground(color);
        }
        
        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EventDetailsWindow(event, frame);
            }
        });
    }
    /**
     * Public method utilized to pain the grid component
     * @preconditions none
     * @postconditions grid is painted
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Generate border 
        g2.setColor(this.color);
        g2.draw(new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1));  
    }
}
