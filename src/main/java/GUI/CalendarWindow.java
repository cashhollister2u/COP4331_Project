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
 *
 * @author cashhollister
 */
public class CalendarWindow {
    public CalendarWindow() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        // Set up header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));

        JPanel subHeaderPanel = new JPanel();
        subHeaderPanel.setLayout(new BoxLayout(subHeaderPanel, BoxLayout.Y_AXIS));

        JLabel headerLabel = new JLabel("Planner Application");
        subHeaderPanel.add(headerLabel);

        subHeaderPanel.add(Box.createVerticalStrut(20));

        JLabel prompt = new JLabel("Calendar");
        subHeaderPanel.add(prompt);

        headerPanel.add(subHeaderPanel);

        // Add buttons to header
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        JButton todayButton = new JButton("Today");
        buttonPanel.add(todayButton);

        JButton weekButton = new JButton("Week");
        buttonPanel.add(weekButton);

        JButton monthButton = new JButton("Month");
        buttonPanel.add(monthButton);

        headerPanel.add(buttonPanel);
        frame.add(headerPanel, BorderLayout.NORTH);

        // Set up card layout for calendar components
        JPanel calendarPanel = new JPanel(new CardLayout());
        
        JPanel calandarContainerPanel = new JPanel(new FlowLayout());
        JPanel calandarCompsPanel = new JPanel(new GridLayout(5, 7));
        calandarContainerPanel.add(calandarCompsPanel);
        
        JPanel weekContainerPanel = new JPanel(new FlowLayout());
        JPanel weekCompsPanel = new JPanel(new GridLayout(1, 7));
        weekContainerPanel.add(weekCompsPanel);
        
        JPanel todayContainerPanel = new JPanel(new FlowLayout());
        JPanel todayCompsPanel = new JPanel(new GridLayout(1, 7));
        todayContainerPanel.add(todayCompsPanel);
        

        // Populate calendar components
        for (int x = 0; x < 31; x++) {
            GridBox box = new GridBox(String.valueOf(x), 150, 150);
            JLabel boxLabel = new JLabel(box);
            calandarCompsPanel.add(boxLabel);
            
        }

        // Populate week components
        List<String> weekDays = Arrays.asList(".  Sunday", ".  Monday", ".  Tuesday", ".  Wednesday", ".  Thursday",".  Friday",".  Saturday");
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
        
        calendarPanel.add(todayContainerPanel, "Today");
        calendarPanel.add(calandarContainerPanel, "Month");
        calendarPanel.add(weekContainerPanel, "Week");
        
        frame.add(calendarPanel, BorderLayout.CENTER);

        // Button actions to switch views
        CardLayout cardLayout = (CardLayout) (calendarPanel.getLayout());
        
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

        // Display frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 900);
        frame.setVisible(true);
    }
}