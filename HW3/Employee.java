
public class Employee extends Person{
	protected String office; 
	protected double salary;
	protected String dateHired;
	
	public Employee(String name, String address, int phoneNumber, String emailAddress, String office, double salary, String dateHired) {
		super(name, address, phoneNumber, emailAddress);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDateHired() {
		return dateHired;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}
	
	@Override 
	public String toString() {
		String person = super.toString();
		return person + ". He/She works at " + office + ", is hired on " + dateHired + ", has a salary of " + salary;
	}
	
}
