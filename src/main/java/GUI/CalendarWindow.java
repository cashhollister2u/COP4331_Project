/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the calendar window, providing a user interface
 * for viewing and interacting with the calendar.
 *
 * @author cashhollister, andrewcogins
 */
public class CalendarWindow extends JFrame {
    private JPanel calendarPanel;
    private JPanel headerPanel;

    /**
     * Constructs the CalendarWindow and initializes its components.
     */
    public CalendarWindow() {
        this.setLayout(new BorderLayout());
        this.setTitle("Calendar");
        
        // Add the taskbar panel to the west of the frame
        TaskBar taskbarPanel = new TaskBar(this);
        this.add(taskbarPanel, BorderLayout.WEST);
        
        calendarPanel = new JPanel(new CardLayout());

        // Create header panel
        headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));

        
        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        
        // create button panel components
        JButton todayButton = new JButton("Today");
        JButton weekButton = new JButton("Week");
        JButton monthButton = new JButton("Month");
        
        // add componenets to button panel
        buttonPanel.add(todayButton);
        buttonPanel.add(weekButton);
        buttonPanel.add(monthButton);
        
        // add button panel to header panel
        headerPanel.add(buttonPanel);

        // Create containers for different calendar views
        // month container
        JPanel calendarContainerPanel = new JPanel(new FlowLayout());
        JPanel calendarCompsPanel = new JPanel(new GridLayout(5, 7));
        calendarContainerPanel.add(calendarCompsPanel);
        
        // week container
        JPanel weekContainerPanel = new JPanel(new FlowLayout());
        JPanel weekCompsPanel = new JPanel(new GridLayout(1, 7));
        weekContainerPanel.add(weekCompsPanel);
        
        // day containter
        JPanel todayContainerPanel = new JPanel(new FlowLayout());
        JPanel todayCompsPanel = new JPanel(new GridLayout(1, 7));
        todayContainerPanel.add(todayCompsPanel);

        // Populate calendar components
        for (int x = 0; x < 31; x++) {
            GridBox box = new GridBox(String.valueOf(x), 150, 150);
            JLabel boxLabel = new JLabel(box);
            calendarCompsPanel.add(boxLabel);
        }

        // Populate week components
        List<String> weekDays = Arrays.asList(".  Sunday", ".  Monday", ".  Tuesday", ".  Wednesday", ".  Thursday", ".  Friday", ".  Saturday");
        for (int x = 0; x < 7; x++) {
            GridBox box = new GridBox(String.valueOf(x) + weekDays.get(x), 150, 800);
            JLabel boxLabel = new JLabel(box);
            weekCompsPanel.add(boxLabel);
        }

        // Populate Today components
        for (int x = 0; x < 1; x++) {
            GridBox box = new GridBox("Today", 800, 800);
            JLabel boxLabel = new JLabel(box);
            todayCompsPanel.add(boxLabel);
        }

        // Add calendar view containers to main panel
        calendarPanel.add(todayContainerPanel, "Today");
        calendarPanel.add(calendarContainerPanel, "Month");
        calendarPanel.add(weekContainerPanel, "Week");

        // Button actions to switch views
        CardLayout cardLayout = (CardLayout) calendarPanel.getLayout();
        cardLayout.show(calendarPanel, "Month"); // Initially show the "Month" view
        
        
        // frame settings
        this.add(calendarPanel, BorderLayout.CENTER);
        this.add(headerPanel, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        
        // action listeners
        todayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(calendarPanel, "Today");
            }
        });

        weekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(calendarPanel, "Week");
            }
        });

        monthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(calendarPanel, "Month");
            }
        });
    }
}