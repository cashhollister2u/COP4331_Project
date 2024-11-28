/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI;

import DataStorage.PlannerSystem;
import DataStorage.UserAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        JFrame frame = new JFrame("Planner Application");
        frame.setLayout(new GridLayout(4, 1));

        JLabel prompt = new JLabel("Sign-Up:");

        
        // Create and set up field panel
        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.X_AXIS));
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));

        // create text input components 
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(); // Changed to JPasswordField for passwords
        
        //add to field panel
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        
        // Set maximum size
        Dimension fieldSize = new Dimension(400, 30);
        usernameField.setMaximumSize(fieldSize);
        passwordField.setMaximumSize(fieldSize);
        
        
        // Create and set up button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        // create button components
        JButton createAccountButton = new JButton("Create Account");
        JButton loginButton = new JButton("Return to Login");
        
        // add to button panel
        buttonPanel.add(createAccountButton);
        buttonPanel.add(loginButton);
        
        
        // Add panels to the frame
        frame.add(prompt, BorderLayout.NORTH);
        frame.add(usernamePanel, BorderLayout.CENTER);
        frame.add(passwordPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Set frame properties and display
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    

        // Add action listener to the "Create Account" button
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword(); // Use getPassword() for JPasswordField
                String password = new String(passwordChars);

                // Save username and password (replace with preferred storage method)
                PlannerSystem systemInstance = PlannerSystem.getInstance();
                UserAccount newAccount = new UserAccount(username, password, new ArrayList<>());
                systemInstance.saveUserAccount(newAccount);

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

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
    }

}
