/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// MainInterface.java
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the main interface of the planner application.
 * It contains the taskbar and a central panel for displaying different views.
 *
 * @author andrewcoggins
 */
public class MainInterface {
    private JFrame frame;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private CalendarWindow calendarWindow;
    private UserProfileWindow userProfileWindow;
    private AddEventWindow addEventWindow;

    /**
     * Constructs the MainInterface and initializes its components.
     */
    public MainInterface() {
        // Create the main frame
        frame = new JFrame("Planner Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(new BorderLayout());

        // Create the content panel with CardLayout
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        // Create the taskbar panel
        JPanel taskbarPanel = new JPanel();
        taskbarPanel.setLayout(new GridLayout(4, 1));

        // Create taskbar buttons
        JButton homeButton = new JButton("Home");
        JButton userProfileButton = new JButton("User Profile");
        JButton addEventsButton = new JButton("Add Events");
        JButton calendarButton = new JButton("Calendar");

        // Add buttons to the taskbar panel
        taskbarPanel.add(homeButton);
        taskbarPanel.add(userProfileButton);
        taskbarPanel.add(addEventsButton);
        taskbarPanel.add(calendarButton);

        // Add the taskbar panel to the west of the frame
        frame.add(taskbarPanel, BorderLayout.WEST);

        // Create instances of the windows
        calendarWindow = new CalendarWindow();
        userProfileWindow = new UserProfileWindow("username", "password");
        addEventWindow = new AddEventWindow();

        // Get the panels from the windows
        JPanel calendarPanel = calendarWindow.getCalendarPanel();
        JPanel calendarHeader = calendarWindow.getHeaderPanel();
        JPanel userProfilePanel = userProfileWindow.getUserProfilePanel();
        JPanel addEventPanel = addEventWindow.getAddEventPanel();

        // Create a panel to hold the calendar header and calendarPanel
        JPanel calendarViewPanel = new JPanel(new BorderLayout());
        calendarViewPanel.add(calendarHeader, BorderLayout.NORTH);
        calendarViewPanel.add(calendarPanel, BorderLayout.CENTER);

        // Add the views to contentPanel
        contentPanel.add(calendarViewPanel, "CalendarView");
        contentPanel.add(userProfilePanel, "UserProfileView");
        contentPanel.add(addEventPanel, "AddEventView");

        // Add action listeners to the buttons
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the home view (you'll need to implement this)
                System.out.println("Home button clicked!");
            }
        });

        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "UserProfileView");
            }
        });

        addEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "AddEventView");
            }
        });

        calendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "CalendarView");
            }
        });

        // Add contentPanel to the center of the frame
        frame.add(contentPanel, BorderLayout.CENTER);

        // Show the UserProfileView initially
        cardLayout.show(contentPanel, "UserProfileView"); 

        frame.setVisible(true);
    }

    /**
     * Main method to start the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainInterface());
    }
}
