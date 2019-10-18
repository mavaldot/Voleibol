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
		
		if (s == null) 
			return;
		
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
	
	public String printData(int lvl, String country) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n");
		sb.append(printSpaces(lvl));
		sb.append(getId());
		sb.append(printSpaces(lvl));
		sb.append(getFirstname());
		sb.append(printSpaces(lvl));
		sb.append(getLastname());
		sb.append(printSpaces(lvl));
		sb.append(getEmail());
		sb.append(printSpaces(lvl));
		sb.append(getGender());
		sb.append(printSpaces(lvl));
		sb.append(getCountry());
		sb.append(printSpaces(lvl));
		sb.append(getImg());
		sb.append(printSpaces(lvl));
		sb.append(getBirthDate());
		
		
		if (left != null) 
			sb.append(left.printData(lvl+1, country));

		if (right != null) 
			sb.append(right.printData(lvl+1, country));
		
		String ret = sb.toString();
		
		return ret;
	}
	
	public String printSpaces(int lvl) {
		
		StringBuilder sb = new StringBuilder();
		
		int spaces = lvl * 5 - 5;
		
		sb.append("\n");
		
		
		
		for (int i = 0; i < spaces; i++) {
			sb.append(" ");	
		}
		
		sb.append("|   ");
		
		
		String ret = sb.toString();
		
		return ret;
		
	}
}
