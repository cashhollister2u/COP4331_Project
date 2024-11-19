/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the login window for the application.
 * It provides a user interface for entering username and password to log in.
 *
 * @author cashhollister, andrewcoggins
 */
public class LoginWindow {

    /**
     * Constructs the LoginWindow and initializes its components.
     */
    public LoginWindow() {
        // Initialize JFrame with GridLayout
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 1));

        // Create and set up header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("Planner Application");
        headerPanel.add(title);

        JLabel prompt = new JLabel("Login:");
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
        JPasswordField passwordField = new JPasswordField(); // Changed to JPasswordField for passwords
        fieldPanel.add(passwordField);

        // Create and set up button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton loginButton = new JButton("Login");
        buttonPanel.add(loginButton);

        JButton signUpButton = new JButton("Sign-Up");
        buttonPanel.add(signUpButton);

        // Add panels to the frame
        frame.add(headerPanel);
        frame.add(fieldPanel);
        frame.add(buttonPanel);

        // Set frame properties and display
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);
        
        
        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
 {
                // Get username and password from the fields
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Perform authentication (replace with your actual authentication logic)
                if (authenticateUser(username, password)) {
                    // If authentication is successful, close the LoginWindow and open MainInterface
                    frame.dispose();
                    new MainInterface(); 
                } else {
                    // If authentication fails, display an error message
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the LoginWindow and open CreateAccountWindow
                frame.dispose();
                new CreateAccountWindow();
            }
        });
        
    }
    


    /**
     * Simulates user authentication. Replace this with actual authentication logic.
     *
     * @param username The entered username.
     * @param password The entered password.
     * @return true if authentication is successful, false otherwise.
     */
    private boolean authenticateUser(String username, String password) {
        // Replace this with actual authentication logic
        // For now, just checks if both fields are non-empty
        return !username.isEmpty() && !password.isEmpty(); 
    }

    /**
     * Main method to start the application with the LoginWindow.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginWindow());
    }
}
