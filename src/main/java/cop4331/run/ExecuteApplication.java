/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cop4331.run;

import cop4331.gui.LoginController;
import javax.swing.SwingUtilities;

/**
 * Class utilized to kick off the Planner application
 * @invariant always executes the LoginController
 * @author cashhollister
 */
public class ExecuteApplication {

    /**
     * Main method utilized to run the Planner Application
     * @preconditions none
     * @postconditions application runs
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginController());
    }
}
