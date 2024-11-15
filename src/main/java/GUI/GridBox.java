/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

/**
 *
 * @author cashhollister
 */
public class GridBox implements Icon {
    // local variables
    private Color color = Color.BLACK;
    private int width;
    private int height;
    private String day;
    
    public GridBox(String day, int width, int height) {
        this.day = day;
        this.height = height;
        this.width = width;
    }
  
    /**
     * Constructs a Rectangle icon of a given color.
     * @param color 
     * @proconditions a color of type color
     * @postcondition rectangle icon object created 
     */
  
    
    /**
     * Public method get rectangle width
     * @preconditions none
     * @postconditions return value of width
     * @return width 
     */
    @Override
    public int getIconWidth()
    {
       return this.width;
    }
    
    /**
     * Public method get rectangle height 
     * @preconditions none
     * @postconditions return value of height
     * @return 
     */
    @Override
    public int getIconHeight()
    {
       return this.height;
    }
    
    /**
     * Public method change rectangle color attribute
     * @param newColor 
     * @preconditions newColor must be type Color
     * @postconditions rectangle color attribute is changed
     */
    public void setColor(Color newColor) {
        this.color = newColor;
    }
    
    /**
     * Public method create or re-create existing rectangle icon 
     * @param c
     * @param g
     * @param x
     * @param y 
     * @preconditions no null variables, valid x/y coordinates
     * @postconditions the icon is created or re-created
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
       Graphics2D g2 = (Graphics2D) g;
       Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, width, height);
       g2.setColor(this.color);
       g2.drawString(day,10, 20);
       g2.draw(rectangle);
       
    }
    
}
