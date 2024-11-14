/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author cashhollister
 */
public class UserProfileWindow {
    public UserProfileWindow(String Username, String password) {
        // init JFrame
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 1));        
        
        // set up panels to contain components
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(2, 1));
        
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        //Header labels
        JLabel title = new JLabel("Planner Application");
        headerPanel.add(title);
        
        JLabel prompt = new JLabel("User Profile Information:");
        headerPanel.add(prompt);
        
        
        // text fields 
        JLabel usernameLabel = new JLabel("Current Username: " + Username);
        fieldPanel.add(usernameLabel);
        JTextField usernameField = new JTextField();
        fieldPanel.add(usernameField);
        JLabel passwordLabel = new JLabel(" Current Password: " + password);
        fieldPanel.add(passwordLabel);
        JTextField passwordField = new JTextField();
        fieldPanel.add(passwordField);
        
        
        // butons
        JButton submitButton = new JButton("Change Credentials");
        buttonPanel.add(submitButton);
        
        JButton signUpButton = new JButton("Delete Account");
        buttonPanel.add(signUpButton);
        
        
        // add the panels to the frame
        frame.add(headerPanel);
        frame.add(fieldPanel);
        frame.add(buttonPanel);
        
        // Display objects in frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
