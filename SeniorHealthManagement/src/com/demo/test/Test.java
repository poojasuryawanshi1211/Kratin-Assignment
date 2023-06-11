package com.demo.test;

import java.util.Scanner;

import com.demo.beans.User;
import com.demo.service.*;

public class Test 
{
	 static HealthserviceImpl hservice=new HealthService();
	 
	public static void main(String args[])
	{
	        Scanner scanner = new Scanner(System.in);
	        boolean exit = false;
	       
	    

	        while (!exit) 
	        {
	            //displayMainMenu();
	        	
	        	 System.out.println("Senior Health Management App");
	             System.out.println("1. Login");
	             System.out.println("2. Register");
	             System.out.println("3. Exit");
	             System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character
	            switch (choice) 
	            {
	            	case 1:
	            		hservice.login();
	            		break;
	            	case 2:
	            		hservice.register();
	            		break;
	            	
	            	case 3:
	            		exit = true;
	            		break;
	            	default:
	            		System.out.println("Invalid choice. Please try again.");
	            }
	      }
	}

}
