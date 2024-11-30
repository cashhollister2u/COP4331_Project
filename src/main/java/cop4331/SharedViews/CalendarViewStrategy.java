/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cop4331.SharedViews;

import javax.swing.*;

/**
 * Interface for defining the strategy for creating different calendar views.
 * @author andrewcoggins
 */

public interface CalendarViewStrategy {
    /**
     * Creates and returns a JPanel representing the calendar view.
     *
     * @param frame The JFrame to which the calendar view will be added.
     * @return A JPanel representing the calendar view.
     */
    JPanel createCalendarView(JFrame frame);
}
