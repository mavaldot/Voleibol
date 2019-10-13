package model;

public class Person {

	private String name;
	private int id;
	private String country;
	
	public Person(String name, int id, String country) {
		super();
		this.name = name;
		this.id = id;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
