/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cop4331.gui;

import cop4331.SharedViews.CalendarViewStrategy;
import cop4331.SharedViews.DailyViewStrategy;
import cop4331.SharedViews.MonthlyViewStrategy;
import cop4331.SharedViews.TaskBarController;
import cop4331.SharedViews.WeeklyViewStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the calendar window, providing a user interface
 * for viewing and interacting with the calendar.
 *
 * @author cashhollister, andrewcogins
 */
public class CalendarController {

    private JFrame frame;
    private JPanel calendarPanel;
    private CardLayout cardLayout; // Make cardLayout a class member

    /**
     * Constructs the CalendarWindow with the specified view strategy.
     *
     * @param viewStrategy The strategy to use for creating the initial calendar view.
     */
    public CalendarController(CalendarViewStrategy viewStrategy) {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Calendar");

        // Add the taskbar panel to the west of the frame
        TaskBarController taskbarPanel = new TaskBarController(frame);
        frame.add(taskbarPanel, BorderLayout.WEST);

        // Create header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        // Create button panel components
        JButton todayButton = new JButton("Today");
        JButton weekButton = new JButton("Week");
        JButton monthButton = new JButton("Month");

        // Add components to button panel
        buttonPanel.add(todayButton);
        buttonPanel.add(weekButton);
        buttonPanel.add(monthButton);

        // Add button panel to header panel
        headerPanel.add(buttonPanel);

        // Add calendar view to main panel
        calendarPanel = new JPanel(new CardLayout());
        cardLayout = (CardLayout) calendarPanel.getLayout(); // Initialize cardLayout here
        calendarPanel.add(viewStrategy.createCalendarView(frame), "InitialView"); 

        // Frame settings
        frame.add(calendarPanel, BorderLayout.CENTER);
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Action listeners
        todayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the "Today" view  
                CalendarViewStrategy dailyStrategy = new DailyViewStrategy();
                JPanel dailyViewPanel = dailyStrategy.createCalendarView(frame);

                calendarPanel.add(dailyViewPanel, "Today");
                cardLayout.show(calendarPanel, "Today"); // Use the class member cardLayout
            }
        });

        weekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the "Week" view  
                CalendarViewStrategy weeklyStrategy = new WeeklyViewStrategy();
                JPanel weeklyViewPanel = weeklyStrategy.createCalendarView(frame);

                calendarPanel.add(weeklyViewPanel, "Week");
                cardLayout.show(calendarPanel, "Week"); // Use the class member cardLayout
            }
        });

        monthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the "Month" view  
                CalendarViewStrategy monthlyStrategy = new MonthlyViewStrategy();
                JPanel monthlyViewPanel = monthlyStrategy.createCalendarView(frame);

                calendarPanel.add(monthlyViewPanel, "Month");
                cardLayout.show(calendarPanel, "Month"); // Use the class member cardLayout
            }
        });
    }
}
