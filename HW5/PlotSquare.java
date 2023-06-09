import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class PlotSquare extends Application{
	public static final double WIDTH = 500;
	public static final double HEIGHT = 500;
	
	
	public void start(Stage primaryStage) throws Exception {
		
		try {
			Polyline polyline = new Polyline();
			ObservableList<Double> list = polyline.getPoints();
			double scaleFactor = 0.0125;
			for ( int x = -100; x <= 100; x++ ) {
				list.add(x + 200.0);
				list.add(scaleFactor*-x*x);
			}
			int x = 0;
			int y = 0;
			
			BorderPane group = new BorderPane(polyline);
			Scene scene = new Scene(group, WIDTH, HEIGHT );
			
			Line lineX = new Line(x + WIDTH/4, y + HEIGHT*5/8, x + WIDTH*3/4, y + HEIGHT*5/8);
			Line lineY = new Line(x + WIDTH/2, y + HEIGHT/4, x + WIDTH/2, y + HEIGHT*3/4);
			Line leftArrowX = new Line(x + WIDTH*3/4, y + HEIGHT*5/8, x + WIDTH*3/4 - 20, y + HEIGHT*5/8 - 20);
			Line rightArrowX = new Line(x + WIDTH*3/4, y + HEIGHT*5/8, x + WIDTH*3/4 - 20, y + HEIGHT*5/8 + 20);
			Line leftArrowY = new Line(x + WIDTH/2, y + HEIGHT/4, x + WIDTH/2 - 20, y + HEIGHT/4 + 20);
			Line rightArrowY = new Line(x + WIDTH/2, y + HEIGHT/4, x + WIDTH/2 + 20, y + HEIGHT/4 + 20);
			
			group.getChildren().add(lineX);
			group.getChildren().add(lineY);
			group.getChildren().add(leftArrowX);
			group.getChildren().add(rightArrowX);
			group.getChildren().add(leftArrowY);
			group.getChildren().add(rightArrowY);
			
			//set up my stage
			primaryStage.setTitle("Plot Square");
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
