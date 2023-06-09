import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EyeHand extends Application { 
	public static final double WIDTH = 600;
	public static final double HEIGHT = 600;
	public static final int TRIALS = 5;
	
	private int count;
	private long timeStart;
	private long timeEnd;
	
	public void start(Stage primaryStage) throws Exception {

		try {
			Pane pane = new Pane();
			Scene scene = new Scene(pane, WIDTH, HEIGHT);
			
			Circle c = new Circle(10);
			
			Text text = new Text("Press a key to start");
			text.setTranslateX(WIDTH/2 -50);
			text.setTranslateY(HEIGHT/2);
			pane.getChildren().add(text);
			
			scene.setOnKeyPressed(e -> {
				if ( count == 0 ) {
					pane.getChildren().clear();
					timeStart = System.currentTimeMillis();
					gameStart(c,EyeHand.WIDTH, EyeHand.HEIGHT);		
					pane.getChildren().add(c);
				}
			});
			
			c.setOnMouseClicked(e -> {
				if ( count < EyeHand.TRIALS - 1) {
					count++;
					pane.getChildren().clear();
					gameStart(c, EyeHand.WIDTH, EyeHand.HEIGHT);
					pane.getChildren().add(c);
				}
				else {
					pane.getChildren().clear();
					timeEnd = System.currentTimeMillis(); 
					long time = timeEnd - timeStart;
					Text newT = new Text("Time takes: " + time + " ms");
					newT.setTranslateX(WIDTH/2 -50);
					newT.setTranslateY(HEIGHT/2);
					pane.getChildren().add(newT);
					newT.setTranslateX(WIDTH/2 - 75);
					newT.setTranslateY(HEIGHT/2);				
				}
			});
			
			//set up my stage
			primaryStage.setTitle("Eye Hand");
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
