/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the user profile window for the application.
 * It displays user information and allows for changing credentials or deleting the account.
 *
 * @author cashhollister, andrewcogins
 */
public class UserProfileWindow {
    private JPanel userProfilePanel;
    private String username;
    private String password;

    /**
     * Constructs the UserProfileWindow with the given username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public UserProfileWindow(String username, String password) {
        this.username = username;
        this.password = password;

        // Initialize the userProfilePanel
        userProfilePanel = new JPanel();
        userProfilePanel.setLayout(new GridLayout(3, 1));

        // Create and set up header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("Planner Application");
        headerPanel.add(title);

        JLabel prompt = new JLabel("User Profile Information:");
        headerPanel.add(prompt);

        // Create and set up field panel
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));

        JLabel usernameLabel = new JLabel("Current Username: " + username);
        fieldPanel.add(usernameLabel);
        JTextField usernameField = new JTextField();
        fieldPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Current Password: " + password);
        fieldPanel.add(passwordLabel);
        JTextField passwordField = new JPasswordField(); // Changed to JPasswordField for passwords
        fieldPanel.add(passwordField);

        // Create and set up button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton changeCredentialsButton = new JButton("Change Credentials");
        buttonPanel.add(changeCredentialsButton); //Name changed for clarity

        JButton deleteAccountButton = new JButton("Delete Account");
        buttonPanel.add(deleteAccountButton); //Name changed for clarity

        // Add panels to the main panel
        userProfilePanel.add(headerPanel);
        userProfilePanel.add(fieldPanel);
        userProfilePanel.add(buttonPanel);
    }

    /**
     * Returns the main panel containing all the user profile components.
     *
     * @return The userProfilePanel.
     */
    public JPanel getUserProfilePanel() {
        return userProfilePanel;
    }
}