package ui;

import java.util.Scanner;

import model.Event;

public class Menu {

	private Scanner s;
	private Event e;
	
	public Menu() {
		s = new Scanner(System.in);
		e = new Event();
	}
	
	public void mainMenu() {
		
		boolean running = true;
		
		while (running) {
			
			System.out.println("\nWelcome to the voleyball championship!\n");
			System.out.println("Please pick an option:");
			System.out.println("1. Read the file with the spectators");
			System.out.println("2. Search for a spectator");
			System.out.println("3. Search for a participant");
			System.out.println("4. Print all of a country's spectators");
			System.out.println("5. Print all of a country's participants");
			System.out.println("6. Exit");
			
			int choice = askInt(1,6);
			
			switch (choice) {
			
			case 1:
				
				String path = askString("Please enter the relative file path. Please use backslash (/) to separate directories.\nExample: res/files/data.csv");
				System.out.println(e.loadSpectators(path));
				break;
				
			case 2:
				
				String sId = askString("Please enter the spectator's ID");
				System.out.println(e.searchSpectator(sId));
				
				break;
				
			case 3:
				
				String pId = askString("Please enter the participant's ID");
				System.out.println(e.searchParticipant(pId));
				
				break;

			case 4:
				
				String specCountry = askString("Please enter the country of the spectators");
				System.out.println(e.showSpectators(specCountry));
				break;
				
			case 5:
				
				String partCountry = askString("Please enter the country of the participants");
				System.out.println(e.showParticipants(partCountry));
				break;
				
			case 6:
				System.out.println("Goodbye! :)");
				running = false;
				break;
			}
			
		}
		
	}
	
	public String askString(String msg) {
		System.out.println(msg);
		String ret = s.nextLine();
		return ret;
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
