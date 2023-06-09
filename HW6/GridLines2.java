
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GridLines2 extends Application{
	public static final double WIDTH = 500;
	public static final double HEIGHT = 500;
	public static final int NUM_LINES = 5;
	
	public void start(Stage primaryStage) throws Exception {
		
		try {
			double vX = 0;
			double vY = 0;
			double hX = 0;
			double hY = 0;
			Pane pane = new Pane();
			Scene scene = new Scene(pane, WIDTH, HEIGHT);
			
			for ( int i = 0; i <= GridLines2.NUM_LINES; i++ ) {
				Line vLine = new Line(vX, vY, vX, HEIGHT); // vY not change
				Line hLine = new Line(hX, hY, WIDTH, hY); // hx not change
				pane.getChildren().add(vLine);
				pane.getChildren().add(hLine);
				vLine.startXProperty().bind(pane.widthProperty().divide(GridLines2.NUM_LINES + 1).multiply(i));
				vLine.endXProperty().bind(pane.widthProperty().divide(GridLines2.NUM_LINES + 1).multiply(i));
				vLine.endYProperty().bind(pane.heightProperty());
				hLine.startYProperty().bind(pane.heightProperty().divide(GridLines2.NUM_LINES + 1).multiply(i));
				hLine.endXProperty().bind(pane.widthProperty());
				hLine.endYProperty().bind(pane.heightProperty().divide(GridLines2.NUM_LINES + 1).multiply(i));
				vX = vX + WIDTH/(GridLines2.NUM_LINES + 1);
				hY = hY + HEIGHT/(GridLines2.NUM_LINES + 1);
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

