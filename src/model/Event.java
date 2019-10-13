package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Event {

	private Participant first;
	private Spectator root;
	
	public Event() {
		
	}
	
	public String loadSpectators(String path) {
		
		String msg = "The spectators where loaded successfully!";
		
		File f = new File(path);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			String line = null;
			
			br.readLine();
			
			while ( (line = br.readLine()) != null) {
				
				String[] data = line.split(",");
				
				Spectator s = new Spectator(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]);
				
				System.out.println(s.getInfo());
				
				addSpectator(new Spectator(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]));
				
				
			}
		}
		catch (FileNotFoundException e) {
			msg = "ERROR. Could not find the file you specified";
		}
		catch (IOException e) {
			msg = "ERROR. There was problem reading the file";
		}
		catch (Exception e) {
			//
		}
		
		System.out.println();
		
		return msg;
		
	}
	
	
	
	public boolean addParticipant(Participant p) {
	
		boolean success = true;
		
		if (first == null)
			first = p; 
		else if (first.findId(p.getId()))
			success = false;
		else
			first.addParticipant(p);
	
		return success;
		
	}
	
	public boolean addSpectator(Spectator s) {
		
		boolean success = true;
		
		if (root == null) {
			root = s;
		}
		else {
			try {
				root.addSpectator(s);
			} catch (DuplicateIdException e) {
				success = false;
			}
		}
		
		return success;
	}
	
	public String searchSpectator(String id) {
		
		String result = "";
		
		Spectator s;
		
		double t1 = System.nanoTime();
		
		if ((s = root.searchSpectator(id)) != null) {
			result += "SPECTATOR FOUND:\n" + s.getInfo();
		}
		else
			result += "Could not find a spectator with that id";
		
		double t2 = System.nanoTime() - t1;
		
		result += "\n\nTotal search time: " + t2 + " nanoseconds";
		
		return result;
		
	}
	
	public String searchParticipant(String id) {
		
		String result = "";
		
		Participant p;
		
		double t1 = System.nanoTime();
		
		if ((p = first.searchParticipant(id)) != null) {
			result += "PARTICIPANT FOUND:\n" + p.getInfo();
		}
		else
			result += "Could not find a spectator with that id";
		
		double t2 = System.nanoTime() - t1;
		
		result += "\n\nTotal search time: " + t2 + " nanoseconds";
		
		return result;
		
	}
	
}
