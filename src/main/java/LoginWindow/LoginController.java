/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package LoginWindow;

import CreateAccountWindow.CreateAccountController;
import PlannerSystem.PlannerSystem;
import MainInterfaceWindow.MainInterfaceController;
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
public class LoginController {

    /**
     * Constructs the LoginWindow and initializes its components.
     */
    public LoginController() {
        // Initialize JFrame with GridLayout
        JFrame frame = new JFrame("Planner Application");
        frame.setLayout(new GridLayout(4, 1));

        JLabel prompt = new JLabel("Login:");

        // Create and set up field panels
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
        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign-Up");
        
        // add to button panel
        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);
        
        
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
        
        
        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get username and password from the fields
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
                
                PlannerSystem systemInstance = PlannerSystem.getInstance();
                boolean validated = systemInstance.validateUser(username, password);
                
                // Perform authentication (replace with your actual authentication logic)
                if (validated) {
                    // If authentication is successful, close the LoginController and open MainInterfaceController
                    frame.dispose();
                    new MainInterfaceController(); 
                } else {
                    // If authentication fails, display an error message
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the LoginController and open CreateAccountController
                frame.dispose();
                new CreateAccountController();
            }
        });
        
    }
}
