package com.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.demo.beans.*;
import com.demo.test.*;

public class HealthService implements HealthserviceImpl
{

	private Map<String, User> users;
    private User currentUser;

    public HealthService() {
        users = new HashMap<>();
        currentUser = null;
    }
    
    
    @Override
	public void login()
	{
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
        System.out.println("Login");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username))
        {
            User user = users.get(username);
            if (user.getPassword().equals(password)) 
            {
                currentUser = user;
                System.out.println("Login successful.");
                showLoggedInMenu();
            } 
            else {
                System.out.println("Invalid password.");
               }
        } 
        else {
            System.out.println("User does not exist.");
            }
	}
    
   
    @Override
	public void register()
	{
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
        System.out.println("Register");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = new User(username, password);
        users.put(username, user);

        System.out.println("Registration successful. Please login to continue.");
	}

    
    @Override
	public void showLoggedInMenu() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
        boolean logout = false;

        while (!logout) {
            displayLoggedInMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    trackHealth();
                    break;
                case 2:
                    setMedicationReminder();
                    break;
                case 3:
                    viewEmergencyContacts();
                    break;
                case 4:
                    exerciseRecommendations();
                    break;
                case 5:
                    logout = true;
                    currentUser = null;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}

    
    public void displayLoggedInMenu() {
        System.out.println("Senior Health Management App");
        System.out.println("1. Track Health");
        System.out.println("2. Set Medication Reminder");
        System.out.println("3. View Emergency Contacts");
        System.out.println("4. View Exercise Recommendation");
        System.out.println("5. Logout ");
        System.out.print("Enter your choice: ");
    }
    
    
    @Override
    public void trackHealth()
   {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
        System.out.println("Track Health");

        System.out.print("Enter Blood Pressure (mmHg): ");
        int bloodPressure = scanner.nextInt();

        System.out.print("Enter Heart Rate (bpm): ");
        int heartRate = scanner.nextInt();

        System.out.print("Enter Weight (kg): ");
        double weight = scanner.nextDouble();

        scanner.nextLine(); // Consume the newline character
        
        if (ValidationUtil.validateHealthData(bloodPressure, heartRate, weight)) {
            currentUser.trackHealth(bloodPressure, heartRate, weight);
            System.out.println("Health data recorded successfully.");
        } else {
            System.out.println("Invalid health data. Please try again.");
        }
  }


    

       @Override
        public void setMedicationReminder() 
        {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
        System.out.println("Set Medication Reminder");

        System.out.print("Enter Medication Name: ");
        String medicationName = scanner.nextLine();

        System.out.print("Enter Reminder Time (HH:mm): ");
        String reminderTime = scanner.nextLine();
       
       
        System.out.println("\nMedication Reminder Set:");
        System.out.println("Medication Name: " + medicationName);
        System.out.println("Reminder Time: " + reminderTime);

     }
    
   
	@Override
	public void viewEmergencyContacts() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
        System.out.println("Emergency Contacts");

       
        System.out.print("Enter emergency contact name: ");
        String emergencyContactName = scanner.nextLine();

        System.out.print("Enter emergency contact number: ");
        String emergencyContactNumber = scanner.nextLine();

        System.out.println("Emergency Contacts:");
        System.out.println("Name: " + emergencyContactName);
        System.out.println("Number: " + emergencyContactNumber);
	}
   
    

	@Override
	public void exerciseRecommendations() {
		// TODO Auto-generated method stub
		  System.out.println("Exercise Recommendations");
	        System.out.println("1. Walking");
	        System.out.println("2. Stretching");
	        System.out.println("3. Light Strength Training");
	}

    
    
    public class ValidationUtil {
        public static boolean validateHealthData(int bloodPressure, int heartRate, double weight) {
            return bloodPressure >= 0 && heartRate >= 0 && weight >= 0;
        }

        public static boolean validateReminderData(String medicationName, String reminderTime) {
            return !medicationName.isEmpty() && reminderTime.matches("\\d{2}:\\d{2}");
        }
    }
	
    
}