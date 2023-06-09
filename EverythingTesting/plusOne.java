
public class plusOne {
	public static long[] plusOne(long[] digits) {
		String num1 = "";

		for ( int i = 0; i < digits.length; i++ ) {
			num1 += "" + digits[i];
		}

		long num2 = Integer.parseInt(num1);
		num2 += 1;

		String preAns = "";
		preAns = "" + num2;
		long[] finalAns = new long[preAns.length()];

		for ( int i = 0; i < preAns.length(); i++ ) {
			char letter = preAns.charAt(i);
			finalAns[i] = Integer.parseInt(String.valueOf(letter));
		}

		return finalAns;


	}
	
	public static void main(String[] args) {
		try {
		long[] list = new long[]{9,8,7,6,5,4,3,2,1};
		System.out.println(plusOne(list));
		
		}
		catch( NumberFormatException nfe ) {
			nfe.printStackTrace();
		}
	}

}
