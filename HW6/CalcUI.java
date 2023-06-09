import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalcUI extends Application {
	public static final double WIDTH = 350;
	public static final double HEIGHT = 500;
	
	public void start(Stage primaryStage) throws Exception {
		
		try {
			BorderPane mainPane = new BorderPane();
			GridPane pane1 = new GridPane();
			GridPane pane2 = new GridPane();
			GridPane pane3 = new GridPane();
	
			pane1.setAlignment(Pos.CENTER);
			pane2.setAlignment(Pos.CENTER);
			pane3.setAlignment(Pos.CENTER);
			Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
			
			int i = 1;
			for ( int r = 0; r < 3; r++ ) {
				for ( int c = 0 ; c < 3; c++ ) {
					if ( i < 10) {
						Button button = new Button("" + i);
						pane1.add(button, c, r);
						i++;
					}
				}
			}
			
			Button button0 = new Button("0");
			pane1.add(button0, 1, 3);
			pane1.setPadding(new Insets(10, 10, 10, 10));
			
			Button plus = new Button("+");
			Button minus = new Button("-");
			Button multiply = new Button("*");
			Button divide = new Button("/");
			
			pane2.add(plus, 0, 0); // ( c, r )
			pane2.add(minus, 0, 1);
			pane2.add(multiply, 0, 2);
			pane2.add(divide, 0, 3);
			
			pane2.setPadding(new Insets(10, 10, 10, 10));
			
			Button clear = new Button("Clear");
			Button decimalPoint = new Button(".");
			Button equal = new Button("=");
			
			
			TextField text = new TextField();
			text.setAlignment(Pos.CENTER);
			
			pane3.add(clear, 1, 1);
			pane3.add(decimalPoint, 2, 1);
			pane3.add(equal, 3, 1);
			pane3.add(text, 0, 1);
				
			pane3.setPadding(new Insets(10, 10, 10, 10));
			
			mainPane.setCenter(pane1);
			mainPane.setLeft(pane2);
			mainPane.setBottom(pane3);
			
			//set up my stage
			primaryStage.setTitle("Calculator UI");
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
