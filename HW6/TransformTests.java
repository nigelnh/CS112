import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class TransformTests extends Application {
	public static final double WIDTH = 600;
	public static final double HEIGHT = 600;
	
	public void start(Stage primaryStage) throws Exception {

		try {
			BorderPane pane1 = new BorderPane();
			Group group = new Group();
			Scene scene1 = new Scene(pane1, WIDTH, HEIGHT);
			
			HBox pane2 = new HBox();
			pane2.setPadding(new Insets(10, 10, 10, 10));
			pane1.setTop(pane2);
					
			Polygon triangle = new Polygon( WIDTH/2, HEIGHT/2 - 50, WIDTH/2 - 50, HEIGHT/2 + 38, WIDTH/2 + 50, HEIGHT/2 + 38);
			Circle circle1 = new Circle( WIDTH/2, HEIGHT/2 - 50, 50);
			Circle circle2 = new Circle( WIDTH/2 - 50, HEIGHT/2 + 38, 50);
			Circle circle3 = new Circle( WIDTH/2 + 50, HEIGHT/2 + 38, 50);
			triangle.setFill(Color.ALICEBLUE);
			circle1.setFill(Color.BEIGE);
			circle2.setFill(Color.BEIGE);
			circle3.setFill(Color.BEIGE);
			circle1.setStroke(Color.BROWN);
			circle2.setStroke(Color.BROWN);
			circle3.setStroke(Color.BROWN);
			triangle.setStroke(Color.BLACK);
			
			group.getChildren().addAll(circle1, circle2, circle3, triangle);
			pane1.getChildren().add(group);	
			
			Button upX = new Button("Scale Up X");
			upX.setOnAction(e -> {
				group.setScaleX(group.getScaleX() + 0.2);
				
			});
			
			Button upY = new Button("Scale Up Y");
			upY.setOnAction(e -> {
				group.setScaleY(group.getScaleY() + 0.2);	
			});
			
			Button downX = new Button("Scale Down X");
			downX.setOnAction(e -> {
				group.setScaleX(group.getScaleX() - 0.2);
			});
			
			Button downY = new Button("Scale Down Y");
			downY.setOnAction(e -> {
				group.setScaleY(group.getScaleY() - 0.2);
			});
					
			Button rotClockW = new Button("Clockwise");
			rotClockW.setOnAction(e -> {
				group.setRotate(group.getRotate() + 30);
			});
			
			Button rotCoutClockW = new Button("Counter Clockwise");
			rotCoutClockW.setOnAction(e -> {
				group.setRotate(group.getRotate() - 30);
			});
			
			pane2.getChildren().addAll(upX, upY, downX, downY, rotClockW, rotCoutClockW );
			
			pane1.setOnMouseClicked(e -> {
				group.relocate(e.getX() - 100, e.getY() - 100);
			});
			
			
			//set up my stage
			primaryStage.setTitle("Transform Test");
			primaryStage.setScene(scene1);
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
