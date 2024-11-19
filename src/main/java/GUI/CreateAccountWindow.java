/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

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
        JPasswordField passwordField = new JPasswordField(); // Use JPasswordField for passwords
        fieldPanel.add(passwordField);

        // Create and set up button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton createAccountButton = new JButton("Create Account");
        buttonPanel.add(createAccountButton);

        JButton loginButton = new JButton("Return to Login");
        buttonPanel.add(loginButton);

        // Add panels to the frame
        frame.add(headerPanel);
        frame.add(fieldPanel);
        frame.add(buttonPanel);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 300);

        // Add action listener to the "Create Account" button
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword(); // Use getPassword() for JPasswordField
                String password = new String(passwordChars);

                // Save username and password (replace with preferred storage method)
                saveCredentials(username, password);

                // Close the CreateAccountWindow and open LoginWindow
                frame.dispose();
                new LoginWindow();
            }
        });

        // Add action listener to the "Login" button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the CreateAccountWindow and open LoginWindow
                frame.dispose();
                new LoginWindow();
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    /**
     * Saves the username and password.
     * Replace this with actual credential storage logic.
     *
     * @param username The username to be saved.
     * @param password The password to be saved.
     */
    private void saveCredentials(String username, String password) {
        // Replace this with actual credential storage logic
        // This might involve saving to a file, a database, or using another secure storage mechanism
        // For now just prints the credentials to the console since unsure what we wanted
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
