package Tehtud;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class EestiLipp extends Application {
	@Override
	public void start(Stage peaLava) throws IOException {
		Group juur = new Group();
		Canvas lõuend = new Canvas(535, 535);

		GraphicsContext gc = lõuend.getGraphicsContext2D();

		gc.setFill(Color.BLACK);
		gc.fillRect(48, 48, 439, 364);

		gc.setFill(Color.BLUE);
		gc.fillRect(50, 50, 435, 120);

		gc.setFill(Color.BLACK);
		gc.fillRect(50, 170, 435, 120);

		gc.setFill(Color.WHITE);
		gc.fillRect(50, 290, 435, 120);






		juur.getChildren().add(lõuend);
		Scene stseen1 = new Scene(juur);
		peaLava.setTitle("Must ruut");
		peaLava.setScene(stseen1);
		peaLava.show();
	}

	public static void main(String[] args) {
		launch();
	}
}