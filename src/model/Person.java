package model;

public class Person {

	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String gender;
	private String country;
	private String img;
	private String birthDate;
	
	public Person(String id, String firstname, String lastname, String email, String gender, String country, String img,
			String birthDate) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.img = img;
		this.birthDate = birthDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getInfo() {
		String retv = ""; 
		retv += "\nID: " + id;
		retv += "\nFirst name: " + firstname;
		retv += "\nLast name: " + lastname;
		retv += "\nEmail: " + email;
		retv += "\nGender:" + gender ;
		retv += "\nCountry: " + country;
		retv += "\nImage: " + img;
		retv += "\nBirthDate: " + birthDate;
		
		return retv;
	}
	
	
}
