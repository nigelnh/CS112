import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorAndFont extends Application {

	public static final double WIDTH = 300;
	public static final double HEIGHT = 150;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			HBox main = new HBox();
			main.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(main, WIDTH, HEIGHT );
			
			for ( int i = 0; i < 5; i++ ) {
				Text t = new Text("Java");
				t.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
				t.setRotate(90);
				t.setOpacity(Math.random());
				t.setFill(Color.color(Math.random(), Math.random(), Math.random()));
				main.getChildren().add(t);
			}
			
			//set up my stage
			primaryStage.setTitle("Color And Font");
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
