import java.util.Scanner;

public class PGMImageTest {

	public static void main(String[] args) {
		System.out.print("Enter a file: ");
		PGMImage test1 = new PGMImage(20, 10);
		
		Scanner inFromUser = new Scanner(System.in);
		
		String input = inFromUser.nextLine();
		
		test1.writeToFIle(input);
//		System.out.println(test1.getWidth());
//		System.out.println(test1.getHeight());
		
		inFromUser.close();
	}

}
