/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// MainInterface.java
package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * This class represents the main interface of the planner application.
 * It contains the taskbar and a central panel for displaying different views.
 *
 * @author andrewcoggins
 */
public class MainInterface extends JFrame{

    /**
     * Constructs the MainInterface and initializes its components.
     */
    public MainInterface() {
        this.setLayout(new BorderLayout());
        this.setTitle("Main Interface");
        
        // Add the taskbar panel to the west of the frame
        TaskBar taskbarPanel = new TaskBar(this);
        this.add(taskbarPanel, BorderLayout.WEST);
        // week container
        JPanel weekContainerPanel = new JPanel(new FlowLayout());
        JPanel weekCompsPanel = new JPanel(new GridLayout(1, 7));
        weekContainerPanel.add(weekCompsPanel);
        
        // day containter
        JPanel todayContainerPanel = new JPanel(new FlowLayout());
        JPanel todayCompsPanel = new JPanel(new GridLayout(1, 7));
        todayContainerPanel.add(todayCompsPanel);
        
        // Populate week components
        java.util.List<String> weekDays = Arrays.asList(".  Sunday", ".  Monday", ".  Tuesday", ".  Wednesday", ".  Thursday", ".  Friday", ".  Saturday");
        for (int x = 0; x < 7; x++) {
            GridBox box = new GridBox(String.valueOf(x) + weekDays.get(x), 125, 800);
            JLabel boxLabel = new JLabel(box);
            weekCompsPanel.add(boxLabel);
        }

        // Populate Today components
        for (int x = 0; x < 1; x++) {
            GridBox box = new GridBox("Today", 575, 800);
            JLabel boxLabel = new JLabel(box);
            todayCompsPanel.add(boxLabel);
        }
        
        // frame settings
        this.add(todayContainerPanel, BorderLayout.CENTER);
        this.add(weekContainerPanel, BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
