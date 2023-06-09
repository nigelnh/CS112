import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathAnimTest extends Application{

	public static final int SIZE = 400;
	
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		//set up a shapes 
		Circle  circle = new Circle(0, 0, 50);
		Rectangle rect = new Rectangle(0, 0, 40, 20);
		Line line = new Line(0, SIZE/2, SIZE, SIZE/2);
		//path does not have to be part of the scene
		Circle circlePath = new Circle(SIZE/2,SIZE/2,SIZE/4);
		
		pane.getChildren().addAll(circle, line, rect);
		
		PathTransition pathAnim = new PathTransition();
		//set the node to animate
		pathAnim.setNode(rect);
		//give it a path to follow
		pathAnim.setPath(circlePath);
		
		//make it repeat
		pathAnim.setCycleCount(Timeline.INDEFINITE);
		
		//go back from end
//		pathAnim.setAutoReverse(true);
		
		//set the length of time it takes
		pathAnim.setDuration(Duration.seconds(2));
		
		pathAnim.setInterpolator(Interpolator.LINEAR);
		
		//make the object perpendicular to the direction of the path
		pathAnim.setOrientation(
				PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		
		//start the animation
		pathAnim.play();
		
		pane.setOnMousePressed(e -> {pathAnim.pause();});
		pane.setOnMouseReleased(e -> {pathAnim.play();});
		
		Scene scene = new Scene(pane, SIZE, SIZE);
		
		primaryStage.setTitle("Path Animation Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
