package sudoku;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Interface extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Sudoku");
		primaryStage.setScene(scene);

		OneLetterTextField[][] fields = new OneLetterTextField[9][9];
		TilePane tilepane = new TilePane();
		tilepane.setPrefColumns(9);
		tilepane.setPrefRows(9);
		tilepane.setHgap(3);
		tilepane.setVgap(3);
		tilepane.setAlignment(Pos.CENTER);
		tilepane.setMaxWidth(300);
		tilepane.setMinWidth(300);
		tilepane.setMaxHeight(300);
		tilepane.setMinHeight(300);
		
		for (int posX = 0; posX < 9; posX++) {
			for (int posY = 0; posY < 9; posY++) {
				OneLetterTextField tf = new OneLetterTextField();
				int bigBoxNum = posX / 3 + posY / 3;
				if ((bigBoxNum % 2) == 0) {
					tf.setStyle("-fx-background-color: lightsalmon;");
				}
				fields[posX][posY] = tf;
				tf.setPrefColumnCount(1);
				tf.setPrefHeight(1);
				tilepane.getChildren().add(tf);
			}
		}

		HBox topBox = new HBox();
		HBox bottomBox = new HBox();
		Button solveButton = new Button("Solve");
		Button clearButton = new Button("Clear");

		topBox.setStyle("-fx-background-color: #0D0D0D;");
		root.setTop(topBox);
		topBox.getChildren().addAll(tilepane);

		bottomBox.getChildren().addAll(solveButton, clearButton);
		bottomBox.setPadding(new Insets(10, 0, 10, 10));
		bottomBox.setSpacing(10);
		root.setBottom(bottomBox);

		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}