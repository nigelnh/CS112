import javafx.scene.image.Image;

public class PlayerModified extends GameObjectModified {
	public static final double COLSJUMP = 820 / 41;
	public static final double ROWSJUMP = 600 / 30;
	
	public PlayerModified(double x, double y) {
		super(x, y);
		Image player = new Image("C:\\Users\\nigel.nh\\Downloads\\player.png");
		setImage(player);
	}
	
	@Override
	void moveTo(int rows, int cols) {
		this.setX(this.getX() + cols * COLSJUMP);
		this.setY(this.getY() + rows * ROWSJUMP);
	}
}
