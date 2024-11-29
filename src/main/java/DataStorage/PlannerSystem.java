/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStorage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.File;

/**
 * Utilizes singleton pattern to handle system operations
 * @invariant only one instance can be created
 * @author cashhollister
 */
public class PlannerSystem {
    private UserAccount userAccount;
    // create an instance of Stdout that is accessed by users
    private static PlannerSystem instance = new PlannerSystem();
    
    /**
     * Private Constructor utilized to restrict instance creation
     * @preconditions none
     * @postconditions none
     */
    private PlannerSystem() {
        this.userAccount = null;
    }
    
    /**
     * Public method utilized to get instance rather than creating an instance w/ Constructor
     * @preconditions none
     * @postconditions instance returned 
     * @return PlannerSystem
     */
    public static PlannerSystem getInstance() { return instance; }
    
    /**
     * Public Method to get the user account saved in memory
     * @precondition the account must be retrieved after creds are verified
     * @postconditions the account is accessed
     * @return UserAccount
     */
    public UserAccount getUserAccount() {
        return this.userAccount;
    }
    
    /**
     * Public method utilized to change a user's credentials
     * @preconditions new username as string, new passwd as string, UserAccount loaded in
     * @postconditions the account username and password are changed
     * @param newUsername
     * @param newPassword 
     */
    public void changeUserCredentials(String newUsername, String newPassword) {
        if (this.userAccount != null) {
            this.userAccount.setUsername(newUsername);
            this.userAccount.setPassword(newPassword);
            this.saveUserAccount(this.userAccount);
            System.out.println("User Account credentials changed: "  + newUsername + ":" + newPassword);
        } else {
            System.out.println("No UserAccount found please login");
        }
    }
    
    /**
     * Public method utilized to delete the stored UserAccount
     * @preconditions a user_account.dat file
     * @postconditions the user_account.dat file is deleted
     */
    public void deleteAccount() {
        File file = new File("user_account.dat");
        if (file.exists()) {
            boolean isDeleted = file.delete();
            if (isDeleted) {
                System.out.println("File deleted successfully.");
                this.userAccount = null; // clear userAccount from System instance
            } else {
                System.out.println("Error: File could not be deleted.");
            }
        } else {
            System.out.println("Error: File does not exist.");
        }
    }
    
    /**
     * Public method to validate a user login
     * @preconditions username / passwd input and user_account.dat file
     * @postconditions the system returns whether the inputs match saved data and saves UserAccount to System instance if validated
     * @param currUsername
     * @param currPassword
     * @return validation status Boolean
     */
    public boolean validateUser(String currUsername, String currPassword) {
        UserAccount savedAccount = this.retrieveUserAccount();
        String savedUsername = savedAccount.getUsername();
        String savedPassword = savedAccount.getPassword();
        
        if (currUsername.equals("") || currPassword.equals("")) {
            return false;
        }
        if (currUsername.equals(savedUsername) && currPassword.equals(savedPassword)) {
            this.userAccount = savedAccount; // If validated creds save the UserAccount to system instance
            return true;
        }
        return false;
    }
    
    /**
     * Public method utilized to save a UserAccount to the user_account.dat file
     * @preconditions valid UserAccount input
     * @postconditions user_account.dat file created with UserAccount
     * @param savedUserAccount 
     */
    public void saveUserAccount(UserAccount savedUserAccount) {
        try{
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("user_account.dat"));
            out.writeObject(savedUserAccount);
            out.close();
            this.userAccount = savedUserAccount;
            System.out.println("Saved userAccount to .dat file ");
        } catch (IOException e) {
            System.out.println("Error: unable to write UserAccount to .dat file ");
        }
    }
    
    /**
     * Private helper method to retrieve the UserAccount saved in the .dat file
     * @preconditions created user_account.dat file
     * @postconditions UserAccount is returned 
     * @return UserAccount 
     */
    private UserAccount retrieveUserAccount() {         
        try {
            ObjectInputStream in = new ObjectInputStream(
                      new FileInputStream("user_account.dat"));
                UserAccount retrievedUserAccount = (UserAccount) in.readObject();
                in.close();
                return retrievedUserAccount;
                
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: unable to read UserAccount from .dat file ");
            UserAccount empty = new UserAccount("", "", new ArrayList<>());
            return empty;
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: unable to find UserAccount class ");
            UserAccount empty = new UserAccount("", "", new ArrayList<>());
            return empty;
            
        } 
    }
}
