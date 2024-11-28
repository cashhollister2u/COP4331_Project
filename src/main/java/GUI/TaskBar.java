/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author cashhollister
 */
public class TaskBar extends JPanel{
    private JFrame currentFrame;
    
    public TaskBar(JFrame frame) {
        this.currentFrame = frame;
        
        // Create the taskbar panel
        JPanel taskbarPanel = new JPanel();
        taskbarPanel.setLayout(new GridLayout(4, 1));

        // Create taskbar buttons
        JButton homeButton = new JButton("Main Interface");
        JButton userProfileButton = new JButton("User Profile");
        JButton addEventsButton = new JButton("Add Events");
        JButton calendarButton = new JButton("Calendar");

        // Add buttons to the taskbar panel
        taskbarPanel.add(homeButton);
        taskbarPanel.add(userProfileButton);
        taskbarPanel.add(addEventsButton);
        taskbarPanel.add(calendarButton);
        
        this.add(taskbarPanel);
        
        // Add action listeners to the buttons
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new MainInterface();
            }
        });

        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new UserProfileWindow();
            }
        });

        addEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new AddEventWindow();
            }
        });

        calendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new CalendarWindow();
            }
        });
    }
}
