/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package GUI;

import java.util.Date;
import java.time.LocalTime;

/**
 *
 * @author cashhollister
 */
public class Project_COP4331 {

    public static void main(String[] args) {
        LoginWindow loginPage = new LoginWindow();
        CreateAccountWindow signUpPage = new CreateAccountWindow();
        UserProfileWindow userProfilePage = new UserProfileWindow("CashHollister", "test12345");
        AddEventWindow addEventPage = new AddEventWindow();
        
        Date date = new Date();
        LocalTime eventTime = LocalTime.now();
        EventDetailsWindow eventDetailsPage = new EventDetailsWindow("COP4331 Project", date, eventTime, "COP4331", "Final project for class", "High"
                , true, true,true);
    }
}
