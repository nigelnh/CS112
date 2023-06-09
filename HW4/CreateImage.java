import java.util.Scanner;

public class CreateImage {

	public static void main(String[] args) {
		Scanner inFromUser = new Scanner(System.in);
		
		System.out.print("Enter file name: ");
		String filename = inFromUser.nextLine();
		
		System.out.print("Enter height: ");
		int height = inFromUser.nextInt();
		System.out.print("Enter width: ");
		int width = inFromUser.nextInt();
		
		PGMImage image = new PGMImage(height, width);
		
		ImageFunction function1 = new ImageFunction();
		image.addFunction(function1);
		
		CircleImageFunction function2 = new CircleImageFunction(128);
		image.addFunction(function2);
		
		image.writeToFIle(filename);
		
		inFromUser.close();
	}

}
