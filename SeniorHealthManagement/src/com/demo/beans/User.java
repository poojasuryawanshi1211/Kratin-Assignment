package com.demo.beans;


import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private String password;
    private Map<String, String> emergencyContacts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.emergencyContacts = new HashMap<>();
    }

    public String getPassword() {
        return password;
    }
    

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmergencyContacts(Map<String, String> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}

	public void trackHealth(int bloodPressure, int heartRate, double weight) {
        // Code to handle health data tracking
        System.out.println("Health data tracked.");
    }

    public void setMedicationReminder(String medicationName, String reminderTime) {
        // Code to handle medication reminder
        System.out.println("Medication reminder set.");
    }

    public Map<String, String> getEmergencyContacts() {
        return emergencyContacts;
    }
}

