package model;

public class Participant extends Person {

	private Participant prev;
	private Participant next;
	
	public Participant(String name, int id, String country) {
		super(name, id, country);
	}

	public Participant getPrev() {
		return prev;
	}

	public void setPrev(Participant prev) {
		this.prev = prev;
	}

	public Participant getNext() {
		return next;
	}

	public void setNext(Participant next) {
		this.next = next;
	}

	public void addParticipant(Participant part) {
		
		if (next == null) {
			part.setPrev(this);
			next = part;
		} 
		else {
			next.addParticipant(part);
		}
	}
	
	public Participant searchParticipant(int id) {
		
		if (getId() == id)
			return this; 
		else 
			return next != null ? next.searchParticipant(id) : null;
		
	}
	
}
