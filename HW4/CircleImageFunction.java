
public class CircleImageFunction extends ImageFunction {
	private int max;
	
	public CircleImageFunction(int max) { 
		this.max = max;
	}

	public int getMax() {
		return max;
	}
	
	@Override
	public int computeValue(int x, int y) {
		return (x*x + y*y)%(max+1);
	}
}
