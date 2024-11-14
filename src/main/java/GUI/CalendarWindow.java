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
public class CalendarWindow {
    public CalendarWindow() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());        
        
        // set up panels to contain components
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        
        //Header labels
        headerPanel.add(Box.createVerticalStrut(20));
        
        JLabel headerLabel = new JLabel("Planner Application");
        headerPanel.add(headerLabel);
        
        headerPanel.add(Box.createVerticalStrut(20));
        
        JLabel prompt = new JLabel("Calendar:");
        headerPanel.add(prompt);
        
        headerPanel.add(Box.createVerticalStrut(20));
        
        // set up panels to contain components
        JPanel calandarCompsPanel = new JPanel();
        calandarCompsPanel.setLayout(new FlowLayout());
        JPanel calandarPanel = new JPanel();
        calandarPanel.setLayout(new GridLayout(5, 7));
        
        for (int x = 0; x < 31; x++) {
            GridBox box = new GridBox();
            JLabel boxLabel = new JLabel(box);
            calandarPanel.add(boxLabel);
        }
        
        // add the panels to the frame
        frame.add(headerPanel, BorderLayout.NORTH);
        calandarCompsPanel.add(calandarPanel);
        frame.add(calandarCompsPanel);
        
        // Display objects in frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1100, 900);
        frame.setVisible(true);
    }
}
