package model;

public class Participant extends Person {
	private Participant prev;
	private Participant next;

	public Participant(String id, String firstname, String lastname, String email, String gender, String country,
			String img, String birthDate) {
		super(id, firstname, lastname, email, gender, country, img, birthDate);
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
	
	
	public Participant searchParticipant(String id) {
		
		if (getId().equals(id))
			return this; 

		return (next != null) ? next.searchParticipant(id) : null;
		
	}
	
	public boolean findId(String id) {
		
		if (getId().equals(id))
			return true; 
		
		return (next != null) ? next.findId(id) : false;
		
	}
	
	
}
