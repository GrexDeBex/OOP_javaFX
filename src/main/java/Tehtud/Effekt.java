package Tehtud;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Effekt extends Application {
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

		BoxBlur bb = new BoxBlur();
		bb.setWidth(5);
		bb.setHeight(5);
		bb.setIterations(3);

		lõuend.setEffect(bb);

		juur.getChildren().add(lõuend);
		Scene stseen1 = new Scene(juur);


		peaLava.setTitle("Must ruut");
		peaLava.setScene(stseen1);
		peaLava.show();
	}

	public static void main(String[] args) {
		launch();
	}

	public static class Nupp extends Application {
		@Override
		public void start(Stage peaLava) throws IOException {
			Group juur = new Group();
			Scene stseen = new Scene(juur);
			peaLava.setScene(stseen);

			Button b = new Button("button");
			b.setOnMouseEntered(event -> {
				double korgus = stseen.getHeight()*Math.random()*0.9;
				double laius = stseen.getWidth()*Math.random()*0.9;
				b.setLayoutX(laius);
				b.setLayoutY(korgus);

			});

			juur.getChildren().add(b);


			peaLava.show();
		}

		public static void main(String[] args) {
			launch();
		}
	}

	public static class Lambda extends Application {
		@Override
		public void start(Stage peaLava) throws IOException {
			Group juur = new Group();

			FlowPane f = new FlowPane();

			BorderPane bp = new BorderPane();
			Circle circ1 = new Circle(100, Color.RED);
			Circle circ2 = new Circle(100, Color.RED);
			bp.setRight(circ1);
			bp.setLeft(circ2);

			f.getChildren().add(bp);

			Rectangle rect = new Rectangle(400,5);
			RotateTransition rt = new RotateTransition(Duration.millis(300), rect);
			rt.setByAngle(180);
			rt.setCycleCount(Timeline.INDEFINITE);
			rt.play();

			f.getChildren().add(rect);

			juur.getChildren().add(f);

			circ1.setOnMouseEntered(event ->
					circ1.setFill(Color.BLUE));
			circ2.setOnMouseEntered(event ->
					circ2.setFill(Color.BLUE));



			Scene stseen = new Scene(juur);
			stseen.setOnKeyPressed(e -> {
				circ1.setFill(Color.RED);
				circ2.setFill(Color.RED);
			});

			peaLava.setScene(stseen);
			peaLava.show();
		}

		public static void main(String[] args) {
			launch();
		}
	}
}