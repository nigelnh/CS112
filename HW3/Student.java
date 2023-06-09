
public class Student extends Person {
	private static final int FRESHMAN = 2026;
	private static final int SOPHOMORE  = 2025;
	private static final int JUNIOR = 2024;
	private static final int SENIOR = 2023;
	private int classOf;
	
	public Student(String name, String address, int phoneNumber, String emailAddress, int classStatus) {
		
		super(name, address, phoneNumber, emailAddress);
		if ( classStatus == FRESHMAN ) {
			this.classOf = 2026;
		}
		else if ( classStatus == SOPHOMORE ) {
			this.classOf = 2025;
		}
		else if ( classStatus == JUNIOR ) {
			this.classOf = 2024;
		}
		else if ( classStatus == SENIOR ) {
			this.classOf = 2023;
		}
	}
	
	public static int getFreshman() {
		return FRESHMAN;
	}

	public static int getSophomore() {
		return SOPHOMORE;
	}

	public static int getJunior() {
		return JUNIOR;
	}

	public static int getSenior() {
		return SENIOR;
	}

	public int getClassOf() {
		return classOf;
	}

	public void setClassOf(int classOf) {
		this.classOf = classOf;
	}

	@Override
	public String toString() {
		String person = super.toString();
		return person + ", is a " + classOf;
	}
}
