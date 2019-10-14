package model;

public class Spectator extends Person implements Comparable<Spectator>{

	private Spectator left;
	private Spectator right;

	public Spectator(String id, String firstname, String lastname, String email, String gender, String country,
			String img, String birthDate) {
		super(id, firstname, lastname, email, gender, country, img, birthDate);
	}
	
	public Spectator getLeft() {
		return left;
	}

	public void setLeft(Spectator left) {
		this.left = left;
	}

	public Spectator getRight() {
		return right;
	}

	public void setRight(Spectator right) {
		this.right = right;
	}

	public void addSpectator(Spectator s) throws DuplicateIdException {
		
		if (this.compareTo(s) < 0) {
			
			if (right == null)
				right = s;
			else
				right.addSpectator(s);
			
		}
		else if (this.compareTo(s) > 0) {
			
			if (left == null)
				left = s;
			else
				left.addSpectator(s);		
		}
		else
			throw new DuplicateIdException("That ID already exists!");
			
	}

	public Spectator searchSpectator(String id) {
		
		if (getId().equals(id))
			return this;
		else if (getId().compareTo(id) > 0)
			return (left != null) ?  left.searchSpectator(id) : null;
		else 
			return (right != null) ?  right.searchSpectator(id) : null;

		
	}
	
	public int compareTo(Spectator s) {
		
		int retv = getId().compareTo(s.getId());
		return retv;
	}
	
}
