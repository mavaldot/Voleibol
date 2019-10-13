package model;

public class Spectator extends Person {

	private Spectator left;
	private Spectator right;
	
	public Spectator(String name, int id, String country) {
		super(name, id, country);
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
		
		if (getId() < s.getId()) {
			
			if (right == null)
				right = s;
			else
				right.addSpectator(s);
			
		}
		else if (getId() > s.getId()) {
			
			if (left == null)
				left = s;
			else
				left.addSpectator(s);		
		}
		else
			throw new DuplicateIdException("That ID already exists");
			
	}

	public Spectator searchSpectator(int id) {
		
		if (getId() == id)
			return this;
		else if (getId() > id)
			return left != null ?  left.searchSpectator(id) : null;
		else 
			return right != null ?  right.searchSpectator(id) : null;

		
	}
	
}
