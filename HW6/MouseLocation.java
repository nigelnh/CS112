import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
//import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseLocation extends Application { 
	public static final double WIDTH = 600;
	public static final double HEIGHT = 600;
	public static final int TRIALS = 5;
	public static int i = 0;
	
//	private int count;
//	private long time
	
	public void start(Stage primaryStage) throws Exception {

		try {
			BorderPane pane = new BorderPane();
			
			TextField text1 = new TextField();
			Button b = new Button("Click here");
//			TextField text2 = new TextField();
			pane.setTop(text1);
			pane.setCenter(b);
//			pane.setBottom(text2);
			
			Scene scene = new Scene(pane, WIDTH, HEIGHT);
			
//			Circle c = new Circle(10);
			
//			pane.getChildren().add(text1);
//			pane.getChildren().add(text2);
			
			b.setOnAction(e -> {
				text1.setText("Number of time " + i++);
//				text2.setText("" + e.getY());
			});
			
//			Text text = new Text("Press a key to start");
//			text.setTranslateX(WIDTH/2 -50);
//			text.setTranslateY(HEIGHT/2);
//			pane.getChildren().add(text);
			
//			scene.setOnKeyPressed(e -> {
//				if ( count == 0 || count == EyeHand.TRIALS - 1 ) {
//					pane.getChildren().clear();
//					gameStart(c,EyeHand.WIDTH, EyeHand.HEIGHT);		
//					pane.getChildren().add(c);
//				}
//			});
			
//			Button b = new Button("Start");
//			pane.getChildren().add(b);
//			b.setOnAction(e -> {
//				pane.getChildren().clear();
//				gameStart(c,EyeHand.WIDTH, EyeHand.HEIGHT);
//				pane.getChildren().add(c);
//			});
			
//			c.setOnMouseClicked(e -> {
//				if ( count < EyeHand.TRIALS - 1) {
//					count++;
//					pane.getChildren().clear();
//					gameStart(c, EyeHand.WIDTH, EyeHand.HEIGHT);
//					pane.getChildren().add(c);
//				}
//				else {
//					count = 0;
//					pane.getChildren().clear();
//					time = System.currentTimeMillis(); 
//					Text newT = new Text("Time takes: " + time + " ms");
//					pane.getChildren().add(newT);
//					newT.setTranslateX(WIDTH/2 - 75);
//					newT.setTranslateY(HEIGHT/2);
////					pane.setCenter(newT);
//				}
//			});
			
			//set up my stage
			primaryStage.setTitle("Mouse Location");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void gameStart(Circle c, double width, double height) {
		c.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
		c.setCenterX(Math.random()*width);
		c.setCenterY(Math.random()*height);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

