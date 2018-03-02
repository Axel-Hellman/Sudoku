package sudoku;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Interface extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		SudokuSolver game = new SudokuSolver();

		// Skapar Root och en scen, grunden för rutan.
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Sudoku");
		primaryStage.setScene(scene);

		// skapar textrutorna
		OneLetterTextField[][] fields = new OneLetterTextField[9][9];
		TilePane tilepane = new TilePane();
		tilepane.setPrefColumns(9);
		tilepane.setPrefRows(9);
		tilepane.setHgap(3);
		tilepane.setVgap(3);
		tilepane.setAlignment(Pos.CENTER);

		// sätter färgen på textrut-grupperna
		for (int posX = 0; posX < 9; posX++) {
			for (int posY = 0; posY < 9; posY++) {
				OneLetterTextField tf = new OneLetterTextField();
				int bigBoxNum = posX / 3 + posY / 3;
				if ((bigBoxNum % 2) == 0) {
					tf.setStyle("-fx-background-color: lightGreen;");
				}
				fields[posX][posY] = tf;
				tf.setPrefColumnCount(1);
				tf.setPrefHeight(30);
				tf.setPrefWidth(30);
				tilepane.getChildren().add(tf);
			}
		}

		// skapar topBox och bottomBox och lägger in dess funktioner
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

		Alert errorWindow = new Alert(AlertType.ERROR);
		errorWindow.setTitle("FELMEDDELANDE");
		errorWindow.setHeaderText(null);
		errorWindow.setContentText("FEL: Ingen lösning tillgänglig");

		// Handlingen vid tryck av solveButton
		solveButton.setOnAction(event -> {
			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					OneLetterTextField tf = fields[row][col];
					if (!tf.getText().isEmpty()) {
						game.put(row, col, Integer.parseInt(tf.getText()));
					} else {
						game.put(row, col, 0);

					}

				}
			}

			if (game.solver()) {
				for (int row = 0; row < 9; row++) {
					for (int col = 0; col < 9; col++) {
						OneLetterTextField tf = fields[row][col];
						tf.replaceText(0, 0, "" + game.getNbr(row, col));
					}
				}
			} else {
				errorWindow.showAndWait();
			}
		});

		// Handlingen vid tryck av clearButton
		clearButton.setOnAction(event -> {
			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					OneLetterTextField tf = fields[row][col];
					if (!tf.getText().isEmpty()) {
						tf.replaceText(0, 1, "");
						game.put(row, col, 0);
					}
				}
			}
		});


		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}