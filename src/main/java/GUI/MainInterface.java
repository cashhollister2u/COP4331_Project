/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// MainInterface.java
package GUI;

import Utilities.GridBox;
import Utilities.CurrentMonth;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
        
        // init CurrentMonth Object
        CurrentMonth currentMonth = new CurrentMonth();
        
        // Populate week components
        List<String> weekDays = currentMonth.getCurrentWeek();
        String todayDate = currentMonth.getTodayDate();
        for (int x = 0; x < weekDays.size(); x++) {
            String currDate = weekDays.get(x);
            Color dateColor = Color.BLACK;
            
            // change color based on current day
            if (currDate.substring(0,2).equals(todayDate)) {
                dateColor = Color.RED;
            }
            
            // generate grid box for each day
            GridBox box = new GridBox(currDate, 150, 800, dateColor);
            JLabel boxLabel = new JLabel(box);
            weekCompsPanel.add(boxLabel);
        }

        // Populate Today components
        String today = currentMonth.getToday();
        GridBox box = new GridBox(today, 400, 800, Color.BLACK);
        JLabel boxLabel = new JLabel(box);
        todayCompsPanel.add(boxLabel);
        
        // frame settings
        this.add(todayContainerPanel, BorderLayout.CENTER);
        this.add(weekContainerPanel, BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
