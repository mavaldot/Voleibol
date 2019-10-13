package ui;

import java.util.Scanner;

import model.Spectator;

public class Menu {

	private Scanner s;
	
	public Menu() {
		s = new Scanner(System.in);
	}
	
	public void mainMenu() {
		
		boolean running = true;
		
		System.out.println("ARBOL");
		System.out.println("++HOLA");
		System.out.println("+ ++LEFT");
		System.out.println("++");
		
		while (running) {
			
			System.out.println("\nWelcome to the voleyball championship!");
			System.out.println("Please pick an option:");
			System.out.println("1. Read the file with the spectators");
			System.out.println("2. ");
			System.out.println("3. ");
			
			int choice = askInt(1,3);
			
			switch (choice) {
			
			case 3:
				running = false;
				break;
			}
			
		}
		
	}
	
	public int askInt() {
		int ret = 0;
		try {
			String ans = s.nextLine();
			ret = Integer.parseInt(ans);
		}
		catch (NumberFormatException nfe) {
			System.out.println("ERROR. Please enter a number");
		}
		
		return ret;
	}
	
	public int askInt(String msg) {
		System.out.println(msg);
		int ret = 0;
		try {
			String ans = s.nextLine();
			ret = Integer.parseInt(ans);
		} 
		catch (NumberFormatException nfe) {
			System.out.println("ERROR. Please enter a number");
		}
		
		return ret;
	}
	
	public int askInt(String msg, int min, int max) {
		System.out.println(msg);
		int ret = 0;
		boolean success = false;
		
		while (!success) {
			
			try {
				
				String ans = s.nextLine();
				ret = Integer.parseInt(ans);
				
				if (ret < min || ret > max)
					System.out.println("ERROR. Please enter a number between " + min + " and " + max);
				else
					success = true;
					
			} 
			catch (NumberFormatException nfe) {
				System.out.println("ERROR. Please enter a number");
			}
		}
		
		return ret;
	}
	
	public int askInt(int min, int max) {
		int ret = 0;
		boolean success = false;
		
		while (!success) {
			
			try {
				
				String ans = s.nextLine();
				ret = Integer.parseInt(ans);
				
				if (ret < min || ret > max)
					System.out.println("ERROR. Please enter a number between " + min + " and " + max);
				else
					success = true;
					
			} 
			catch (NumberFormatException nfe) {
				System.out.println("ERROR. Please enter a NUMBER");
			}
		}
		
		return ret;
	}
	
	
}
