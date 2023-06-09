import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListTest {

	public static final int ITEMS = 100000;
	public static final int TRIALS = 50000;
	
	public static void fillList(String label, List<Integer> list) {
		long t0 = System.currentTimeMillis();
		
		//do something -- add items
		for(int i = 0; i < ITEMS; i++) {
			list.add(i);
		}
		
		long t1 = System.currentTimeMillis();
		System.out.printf("%20s:%10d\n", label, t1-t0);
	}
	
	public static void fillListFront(String label, List<Integer> list) {
		long t0 = System.currentTimeMillis();
		
		//do something -- add items at the front
		for(int i = 0; i < ITEMS; i++) {
			list.add(0, i); //add i at location 0
		}
		
		long t1 = System.currentTimeMillis();
		System.out.printf("%20s:%10d\n", label, t1-t0);
	}

	//remove TRIAL items from front
	public static void removeListFront(String label, List<Integer> list) {
		long t0 = System.currentTimeMillis();
		
		for(int i = 0; i < TRIALS; i++) {
			list.remove(0);
		}
		
		long t1 = System.currentTimeMillis();
		System.out.printf("%20s:%10d\n", label, t1-t0);
	}
	
	//remove TRIAL items from the end
	//list.remove(i)
	public static void removeListEnd(String label, List<Integer> list) {
		long t0 = System.currentTimeMillis();
		
		for(int i = 0; i < TRIALS; i++) {
			list.remove(list.size()-1);
		}
		
		long t1 = System.currentTimeMillis();
		System.out.printf("%20s:%10d\n", label, t1-t0);
	}
	
	//access random indices TRIALS times
	//add it to a long sum
	public static void accessItems(String label, List<Integer> list) {
		long sum = 0;
		Random rand = new Random(17);
		long t0 = System.currentTimeMillis();
		
		for(int i = 0; i < TRIALS; i++) {
			int index = rand.nextInt(list.size());
			sum += list.get(index);
		}
		
		long t1 = System.currentTimeMillis();
		System.out.printf("%20s:%10d\n", label, t1-t0);
	}
	
	public static void processAll(String label, List<Integer> list) {
		long sum = 0;
		long t0 = System.currentTimeMillis();
		
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		
		long t1 = System.currentTimeMillis();
		System.out.printf("%20s:%10d\n", label, t1-t0);
	}
	
	public static void processEach(String label, List<Integer> list) {
		long sum = 0;
		long t0 = System.currentTimeMillis();
		
		for(int d: list) {
			sum += d;
		}
		
		long t1 = System.currentTimeMillis();
		System.out.printf("%20s:%10d\n", label, t1-t0);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> aList = new ArrayList<>();
		LinkedList<Integer> lList = new LinkedList<>();
		
		fillList("Fill ArrayList", aList);
		fillList("Fill LinkedList", lList);
		
		fillListFront("Fill Front ArrayList", aList);
		fillListFront("Fill Front LinkedList", lList);
		
		removeListFront("Remove Front ArrayList", aList);
		removeListFront("Remove Front LinkedList", lList);
		
		removeListEnd("Remove End ArrayList", aList);
		removeListEnd("Remove End LinkedList", lList);
		
		accessItems("Access Random Items ArrayList", aList);
		accessItems("Access Random Items LinkedList", lList);
		
		processAll("Process All Items ArrayList", aList);
		processAll("Process All Items LinkedList", lList);
		
		processEach("Process Each Item ArrayList", aList);
		processEach("Process Each Item LinkedList", lList);
		//Integer i = 7;
		//aList.add(i);
	}

}
