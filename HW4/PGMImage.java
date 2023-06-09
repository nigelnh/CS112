import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PGMImage {
	private static final int MAX_VALUE = 255;
	private int width;
	private int height;
	private int data[][];
	
	public PGMImage(int width, int height) {
		this.width = width;
		this.height = height;
		this.data = new int[height][width];
	}
	
	public int getValue(int x, int y) {
		if ( x >= 0 && x < height && y >= 0 && y < width ) {
			return data[x][y];
		}
		else {
			throw new IndexOutOfBoundsException("x or y are out of bound");
		}
	}
	
	public void setValue(int x, int y, int p) {
		
		if ( x < 0 || x >= height || y < 0 || y >= width ) {
			throw new IndexOutOfBoundsException("x or y are out of bound");
		}
//		else if ( p >= 0 && p <= MAX_VALUE ) {
//			data[x][y] = p;
//		}
		else if ( p > MAX_VALUE ) {
			data[x][y] = MAX_VALUE;
		}
		else if ( p < 0 ) {
			data[x][y] = 0;
		}
		else {
			data[x][y] = p;
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public void addFunction( ImageFunction object ) {
		for ( int x = 0; x < height; x++ ) {
			for ( int y = 0; y < width; y++ ) {
				setValue(x, y, data[x][y] + object.computeValue(x, y));
			}
		}
	}
	
	public void writeToFIle( String filename ) {
		try {
			PrintWriter output = new PrintWriter( filename );
			output.println("P2");
			output.println( width + " " + height);
			output.println(MAX_VALUE);
			for ( int x = 0; x < height; x++ ) {
				for ( int y = 0; y < width; y++ ) {
					output.print(data[x][y] + " ");
				}
				output.println();
			}
			output.close();
		}
		catch( FileNotFoundException fnfe ) {
			fnfe.printStackTrace();
		}
	}
}
