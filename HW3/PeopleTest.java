import java.util.ArrayList;

public class PeopleTest {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		
		Person p1 = new Person("Harry","300 N Washington St",37396241,"harry024");
		Student s1 = new Student("Nhan","5/92A",123123,"nguynh01",1);
		Employee e1 = new Employee("Nguyen","87/18",321321,"harry12","Apple",10000,"10/10/2023");
		Faculty f1 = new Faculty("Nam","52/3",371321,"nam01","Google",12372,"10/2/2013",10,"manager");
		Staff st1 = new Staff("Em","3/21",12702,"em1","Nothing",3212,"1/12/2021","developer");
		
		list.add(p1);
		list.add(s1);
		list.add(e1);
		list.add(f1);
		list.add(st1);
		
		System.out.println("The list of people: ");
		
		for ( int i = 0; i < list.size(); i++ ) {
			System.out.println(list.get(i));
		}
	}

}
