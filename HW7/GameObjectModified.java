import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameObjectModified extends ImageView {

	public GameObjectModified(double x, double y) {
		Image image = new Image("C:\\Users\\nigel.nh\\Downloads");
		
		setImage(image);
		setX(x);
		setY(y);
		setFitWidth(20);
		setFitHeight(20);
	}

	void moveTo(int rows, int cols) {
		
	}
}
