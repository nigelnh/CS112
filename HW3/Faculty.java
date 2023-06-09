
public class Faculty extends Employee {
	private int officeHours;
	private String rank;
	
	public Faculty(String name, String address, int phoneNumber, String emailAddress, String office, double salary, String dateHired, int officeHours, String rank) { 
		super(name, address, phoneNumber, emailAddress, office , salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}

	public int getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(int officeHours) {
		if ( officeHours <= 24 ) {
			this.officeHours = officeHours;
		}	
		else {
			System.out.println("Inappropriated Office Hours");
		}
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		String employee = super.toString();
		return employee + ", and works as faculty member. He/She has an office hours " + officeHours + " and ranks " + rank;
	}
}
