/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// MainInterface.java
package GUI;

import DataStorage.PlannerSystem;
import DataStorage.UserAccount;
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
    PlannerSystem systemInstance = PlannerSystem.getInstance();
    

    /**
     * Constructs the MainInterface and initializes its components.
     */
    public MainInterface() {
        
    }
}
