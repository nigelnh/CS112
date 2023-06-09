
public class Person {
	protected String name;
	protected String address;
	protected int phoneNumber;
	protected String emailAddress;
	
	public Person(String name, String address, int phoneNumber, String emailAddress) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	
	public String toString() {
		return "This person is " + name + ", who's address is " + address + ", phone number " + phoneNumber + ", and email " + emailAddress;
	}
}
