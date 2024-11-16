/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 * This class implements a custom icon that displays a rectangle with a label.
 * It can be used to create grid-like layouts with labeled cells.
 *
 * @author cashhollister, andrewcoggins
 */
public class GridBox implements Icon {
    private Color color = Color.BLACK;
    private int width;
    private int height;
    private String day;

    /**
     * Constructs a GridBox icon with the specified label, width, and height.
     *
     * @param day    The label to be displayed within the grid box.
     * @param width  The width of the grid box.
     * @param height The height of the grid box.
     */
    public GridBox(String day, int width, int height) {
        this.day = day;
        this.height = height;
        this.width = width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIconWidth() {
        return this.width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIconHeight() {
        return this.height;
    }

    /**
     * Sets the color of the grid box.
     *
     * @param newColor The new color for the grid box.
     */
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, width, height);
        g2.setColor(this.color);
        g2.drawString(day, 10, 20);
        g2.draw(rectangle);
    }
}