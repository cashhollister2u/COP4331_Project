/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the window for creating a new user account.
 * It provides a user interface with fields for entering username and password.
 *
 * @author cashhollister
 */
public class CreateAccountWindow {

    /**
     * Constructs the CreateAccountWindow and initializes its components.
     */
    public CreateAccountWindow() {
        // Initialize JFrame with GridLayout
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 1));

        // Create and set up header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("Planner Application");
        headerPanel.add(title);

        JLabel prompt = new JLabel("Sign-Up:");
        headerPanel.add(prompt);

        // Create and set up field panel
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));

        JLabel usernameLabel = new JLabel("Username:");
        fieldPanel.add(usernameLabel);
        JTextField usernameField = new JTextField();
        fieldPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        fieldPanel.add(passwordLabel);
        JTextField passwordField = new JPasswordField(); // Changed to JPasswordField for passwords
        fieldPanel.add(passwordField);

        // Create and set up button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton signUpButton = new JButton("Sign-Up"); // Renamed for clarity
        buttonPanel.add(signUpButton );

        JButton loginButton = new JButton("Login"); // Renamed for clarity
        buttonPanel.add(loginButton);

        // Add panels to the frame
        frame.add(headerPanel);
        frame.add(fieldPanel);
        frame.add(buttonPanel);

        // Set frame properties and display
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}