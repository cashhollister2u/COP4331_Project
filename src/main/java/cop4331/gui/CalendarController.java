/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cop4331.gui;

import cop4331.System.PlannerSystem;
import cop4331.SharedModels.UserAccount;
import cop4331.SharedViews.TaskBarController;
import cop4331.SharedModels.CurrentMonth;
import cop4331.SharedViews.DayEvent;
import cop4331.SharedViews.GridBox;
import cop4331.SharedViews.WeekEvent;
import cop4331.SharedViews.MonthEvent;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * This class represents the calendar window, providing a user interface
 * for viewing and interacting with the calendar.
 *
 * @author cashhollister, andrewcogins
 */
public class CalendarController {
    private PlannerSystem systemInstance = PlannerSystem.getInstance();
    private UserAccount userAccount = systemInstance.getUserAccount();
    private List<cop4331.SharedModels.Event> accountEvents = userAccount.getEvents();
    private JPanel calendarPanel;
    private JPanel headerPanel;
    private JFrame frame;

    /**
     * Constructs the CalendarWindow and initializes its components.
     */
    public CalendarController() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Calendar");
        
        // Add the taskbar panel to the west of the frame
        TaskBarController taskbarPanel = new TaskBarController(frame);
        frame.add(taskbarPanel, BorderLayout.WEST);
        
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

        // init CurrentMonth Object
        CurrentMonth currentMonth = new CurrentMonth();
        String todayDate = currentMonth.getTodayDate();
        
        // Populate calendar components
        List<LocalDate> monthDates = currentMonth.getDates();
        for (int x = 0; x < monthDates.size(); x++) {
            String currDate = monthDates.get(x).toString().substring(8,10);
            JLabel dateString = new JLabel(currDate);
            
            // change color based on current day
            if (currDate.substring(0,2).equals(todayDate)) {
                dateString.setForeground(Color.BLUE);
            }
            
            // generate grid box for each day
            GridBox box = new GridBox(dateString, 150, 150);
            
            // assign events to day of month
            assignMonthEvents(currDate, box);
            
            calendarCompsPanel.add(box);
        }
        
        // Populate week components
        List<String> weekDays = currentMonth.getCurrentWeek();
        for (int x = 0; x < weekDays.size(); x++) {
            String currDate = weekDays.get(x);
            JLabel dateString = new JLabel(currDate);
            
            // change color based on current day
            if (currDate.substring(0,2).equals(todayDate)) {
                dateString.setForeground(Color.BLUE);
            }
            
            // generate grid box for each day
            GridBox box = new GridBox(dateString, 150, 800);
            
            // assign events to day of week
            assignWeekEvents(currDate, box);
            
            weekCompsPanel.add(box);
        }

        // Populate Today components
        String today = currentMonth.getToday();
        JLabel dateString = new JLabel(today);
        GridBox box = new GridBox(dateString, 450, 800);
        assignTodayEvents(today, box);
        todayCompsPanel.add(box);

        // Add calendar view containers to main panel
        calendarPanel.add(todayContainerPanel, "Today");
        calendarPanel.add(calendarContainerPanel, "Month");
        calendarPanel.add(weekContainerPanel, "Week");

        // Button actions to switch views
        CardLayout cardLayout = (CardLayout) calendarPanel.getLayout();
        cardLayout.show(calendarPanel, "Month"); // Initially show the "Month" view
        
        
        // frame settings
        frame.add(calendarPanel, BorderLayout.CENTER);
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
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
    
    /**
     * Private method used to assign months to calendar locations for month days
     * @preconditions valid current day string and grid box object 
     * @postconditions scrollable grid box created with all associated events
     * @param currDay
     * @param box 
     */
    private void assignMonthEvents(String currDay, GridBox box) {
        String currDate = currDay.substring(0, 2);
        
        for (cop4331.SharedModels.Event event : this.accountEvents) {
            String eventDate = event.getDate().toString().substring(8,10); 
            if (currDate.equals(eventDate)){
                MonthEvent monthEvent = new MonthEvent(event, frame);
                box.addEvent(monthEvent);
            }
        }
    }
    
    /**
     * Private method used to assign months to calendar locations for weekdays
     * @preconditions valid current day string and grid box object 
     * @postconditions scrollable grid box created with all associated events
     * @param currDay
     * @param box 
     */
    private void assignWeekEvents(String currDay, GridBox box) {
        String currDate = currDay.substring(0, 2);
        
        for (cop4331.SharedModels.Event event : this.accountEvents) {
            String eventDate = event.getDate().toString().substring(8,10); 
            if (currDate.equals(eventDate)){
                WeekEvent weekEvent = new WeekEvent(event, frame);
                box.addEvent(weekEvent);
            }
        }
    }
    
    /**
     * Private method used to assign months to calendar locations for current day
     * @preconditions valid current day string and grid box object 
     * @postconditions scrollable grid box created with all associated events
     * @param currDay
     * @param box 
     */
    private void assignTodayEvents(String currDay, GridBox box) {
        String currDate = currDay.substring(0, 2);
        
        for (cop4331.SharedModels.Event event : this.accountEvents) {
            String eventDate = event.getDate().toString().substring(8,10); 
            if (currDate.equals(eventDate)){
                DayEvent dayEvent = new DayEvent(event, frame);
                box.addEvent(dayEvent);
            }
        }
    }
}