import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TimelineTest extends Application {

	public static final double SIZE = 600;
	public static final double TIME_MILLIS = 20;
	public static Pane pane = new Pane();

	public void start(Stage primaryStage) {
		pane.setOnMouseClicked(e -> {
			Mover mover = new Mover(e.getX(), e.getY());
			pane.getChildren().add(mover);

			Thread t = new Thread(mover);
			t.start();
		});

		Scene scene = new Scene(pane, SIZE, SIZE);

		primaryStage.setTitle("Path Animation Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

class Mover extends Group implements Runnable {
	public static final double SIZE = 20;
	public static double SPEED = 2;
	public static final double KEY_FRAME = 20;

	private Random rand = new Random();

	// ternary condition operator
	private int dx = rand.nextBoolean() ? 1 : -1;
	private int dy = rand.nextBoolean() ? 1 : -1;
	
	
	public Mover(double x, double y) {
		Rectangle bg = new Rectangle(-SIZE, -SIZE, 2 * SIZE, 2 * SIZE);
		Circle fg = new Circle(0, 0, SIZE);
		bg.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
		fg.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
		bg.setStroke(Color.BLACK);
		fg.setStroke(Color.BLACK);

		// move the group to (x, y)
		setTranslateX(x);
		setTranslateY(y);

		getChildren().addAll(bg, fg);
	}

	@Override
	public void run() {
		Parent parent = getParent();
		if (parent == null || !(parent instanceof Pane))
			return;

		Pane pane = (Pane) parent;
		
		long t = System.currentTimeMillis();
		long t1 = t + rand.nextInt(8000) + 2000;

		while (t <= t1) {
			// see if we are going out of bounds
			// update direction
			if (getTranslateX() < SIZE || getTranslateX() > pane.getWidth() - SIZE) {
				dx *= -1;
			}
			if (getTranslateY() < SIZE || getTranslateY() > pane.getHeight() - SIZE) {
				dy *= -1;
			}
			
			detectCollision();

			Platform.runLater(() -> {
				setTranslateX(getTranslateX() + dx * SPEED);
				setTranslateY(getTranslateY() + dy * SPEED);
				setRotate(getRotate() + SPEED);
				setScaleX(getScaleX() + (rand.nextBoolean() ? 0.2 : -0.2));
				setScaleY(getScaleY() + (rand.nextBoolean() ? 0.2 : -0.2));
			});
			try {
				Thread.sleep(30);
			}
			catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			// update time 
			t = System.currentTimeMillis();
		}

//		 ConcurrentModificationException ?? // sometimes
		Platform.runLater(() -> {
			synchronized (pane) {
				pane.getChildren().remove(this);
			}
		});

		// synchronized (pane) <> Platform.runLater()
	}

	public void detectCollision() {
		Parent parent = getParent();

		if (parent == null || !(parent instanceof Pane))
			return;

		Pane pane =  (Pane) parent;

		for (Node n : pane.getChildren()) {
			if (n instanceof Mover && n != this) {
				Bounds bounds = ((Mover) n).getBoundsInParent();

				// Check if there is a collision between two Mover objects
				if (getBoundsInParent().intersects(bounds)) {
					// Change the direction
					dx *= -1;
					dy *= -1;
				}
			}
		}
	}
}
