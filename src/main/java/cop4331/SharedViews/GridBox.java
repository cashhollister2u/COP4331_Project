/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cop4331.SharedViews;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Class utilized to create grid box calendar components
 *
 * @author cashhollister, andrewcoggins
 */
public class GridBox extends JPanel {
    private Color color = Color.BLACK;
    private JPanel eventPanel;
    private JScrollPane scrollPane;
    
    /**
     * Constructor Utilized to create GridBox
     * @preconditions none
     * @postconditions GridBox created
     * @param width     
     * @param height   
     * @param dayString
     */
    public GridBox(JLabel dayString, int width, int height) {
        setPreferredSize(new Dimension(width, height)); 
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        eventPanel = new JPanel();
        eventPanel.setLayout(new BoxLayout(eventPanel, BoxLayout.Y_AXIS));
        
        eventPanel.add(dayString);
        eventPanel.add(Box.createVerticalStrut(10)); 

        scrollPane = new JScrollPane(eventPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Public method to add events to the Event Panel
     * @preconditions none
     * @postconditions events added to eventPanel and are scrollable
     * @param component 
     */
    public void addEvent(Component component) {
        eventPanel.add(component);
        eventPanel.revalidate(); // Revalidate to update the layout
        eventPanel.repaint();
    }

    /**
     * Public method utilized to pain the grid component
     * @preconditions none
     * @postconditions grid is painted
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Generate border 
        g2.setColor(color);
        g2.draw(new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1)); 
    }
}