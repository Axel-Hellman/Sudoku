package sudoku;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Interface extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("Sudoku");
		primaryStage.setScene(scene);

		HBox bottomBox = new HBox();
		Button b1 = new Button("Solve");
		Button b2 = new Button("Clear");

		bottomBox.setPadding(new Insets(10, 10, 10, 10));
		bottomBox.setSpacing(10);
		bottomBox.setStyle("-fx-background-color: #336699;");
		bottomBox.getChildren().addAll(b1, b2);
		root.setBottom(bottomBox);
		

		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}