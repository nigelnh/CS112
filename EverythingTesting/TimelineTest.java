import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineTest extends Application {

	public static final double SIZE = 400;
	public static final double TIME_MILLIS = 20;

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();

		pane.setOnMouseClicked(e -> {
			Mover m = new Mover(e.getX(), e.getY());
			pane.getChildren().add(m);
		});

		// set up the animation
		// build a TimeLine with a KeyFrame
		Timeline animation = new Timeline(
				// KeyFrame: when to act and what to do
				new KeyFrame(Duration.millis(TIME_MILLIS),
						// fire and ActionEvent at the given time
						e -> {
							// update all Movers
							for (Node n : pane.getChildren()) {
								if (n instanceof Mover) {
									((Mover) n).moveIt();
								}					
							}
						}));

		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();

		Scene scene = new Scene(pane, SIZE, SIZE);

		primaryStage.setTitle("Path Animation Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

class Mover extends Group {

	public static final double SIZE = 20;
	public static final double SPEED = 2;
	
	private Random rand = new Random();
	// ternary condition operator
	// change direction randomly
	private int dx = rand.nextBoolean() ? 1 : -1;
	private int dy = rand.nextBoolean() ? 1 : -1;

	public Mover(double x, double y) {
		Rectangle bg = new Rectangle(-SIZE, -SIZE, 2 * SIZE, 2 * SIZE);
		Circle fg = new Circle(0, 0, SIZE);
		bg.setFill(Color.BEIGE);
		fg.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));

		// move the group to (x, y)
		this.setTranslateX(x);
		this.setTranslateY(y);

		this.getChildren().addAll(bg, fg);
	}

	public void moveIt() {
		// make sure this group appears in a pane
		Parent parent = this.getParent();
		if (parent == null || !(parent instanceof Pane))
			return;

		Pane pane = (Pane) parent;

		double currX = this.getTranslateX();
		double currY = this.getTranslateY();
		
		// see if we are going out of bounds
		// update direction
		if (currX < SIZE || currX > pane.getWidth() - SIZE) {
			dx *= -1;
		}
		if (currY < SIZE || currY > pane.getHeight() - SIZE) {
			dy *= -1;
		}

		this.setTranslateX(currX + dx * SPEED);
		this.setTranslateY(currY + dy * SPEED);
		
		

		this.setRotate(this.getRotate() + 2);
	}
	
	public void hit() {
		
	}
}