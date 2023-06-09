
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GridLines extends Application{
	public static final double WIDTH = 500;
	public static final double HEIGHT = 500;
	public static final int NUM_LINES = 3;
	
	public void start(Stage primaryStage) throws Exception {
		
		try {
			double vX = 0;
			double vY = 0;
			double hX = 0;
			double hY = 0;
			BorderPane pane = new BorderPane();
			Scene scene = new Scene(pane, WIDTH, HEIGHT);
			
			for ( int i = 0; i <= GridLines.NUM_LINES; i++ ) {
				Line vLine = new Line(vX, vY, vX, HEIGHT);
				Line hLine = new Line(hX, hY, WIDTH, hY);
				pane.getChildren().add(vLine);
				pane.getChildren().add(hLine);
				vX = vX + WIDTH/(GridLines.NUM_LINES + 1);
				hY = hY + HEIGHT/(GridLines.NUM_LINES + 1);
			}
			
			//set up my stage
			primaryStage.setTitle("Grid Lines");
			primaryStage.setScene(scene);
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

