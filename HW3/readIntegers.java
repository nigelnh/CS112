import java.util.ArrayList;
import java.util.Scanner;

public class readIntegers {
	
	public static int countModN( ArrayList<Integer> list, int n ) {
		int totalDivisible = 0;
		
		if ( n == 0 ) {
//			throw new ArithmeticException("Invalid number");
			System.err.println("Fix your math!");
		}
		for ( int i = 0; i < list.size(); i++ ) {
			if ( list.get(i) % n == 0 ) {
				totalDivisible += 1;
			}
		}	
		
		return totalDivisible;
	}
	
	public static int removeModN( ArrayList<Integer> list, int n ) {
		int totalRemoved = 0;
		
		// forward
		// one way to sort dividend
		for ( int i = 0; i < list.size(); i++ ) {
			if ( list.get(i) % n == 0 ) {
				list.remove(i);
				totalRemoved += 1;
				--i;
			}	
		}
		
		// backward
		// another way to sort dividend
		for ( int i = list.size() - 1; i >= 0; i-- ) {
			if ( list.get(i) % n == 0 ) {
				list.remove(i);
				totalRemoved += 1;
			}
		}
		
		return totalRemoved;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Number of integers: ");
		
		int integers = input.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for ( int i = 0; i < integers; i++ ) {
			System.out.print("Enter an integer: ");
			int integer = input.nextInt();
			list.add(integer);
		}
		
		System.out.print("Enter number to be dividied with: ");
		int n = input.nextInt();
	
		System.out.println("Number of elements that are divisible: " + readIntegers.countModN(list, n));
		System.out.println("Number of elements removed: " + readIntegers.removeModN(list, n));
		System.out.println("Number of elements left: " + list);
		
		input.close();
	}
}
