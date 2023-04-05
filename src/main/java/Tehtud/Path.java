package Tehtud;
import javafx.animation.*;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Path extends Application {
	@Override
	public void start(Stage peaLava) throws IOException {
		Group juur = new Group();

		FadeTransition ft = new FadeTransition(Duration.millis(1000), juur);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(5);
		ft.setAutoReverse(true);

		Rectangle rect1 = new Rectangle (100, 0, 100, 100);
		rect1.setArcHeight(50);
		rect1.setArcWidth(50);
		rect1.setFill(Color.VIOLET);

		Rectangle rect2 = new Rectangle (100, 0, 100, 100);
		rect2.setArcHeight(50);
		rect2.setArcWidth(50);
		rect2.setFill(Color.RED);

		javafx.scene.shape.Path path = new javafx.scene.shape.Path();
		MoveTo moveTo = new MoveTo(100, 150);
		CubicCurveTo cubicCurveTo = new CubicCurveTo(400, 40, 175, 250, 500, 150);
		path.getElements().add(moveTo);
		path.getElements().add(cubicCurveTo);

		PathTransition pathTransition1 = new PathTransition();
		pathTransition1.setDuration(Duration.millis(1000));
		pathTransition1.setNode(rect1);
		pathTransition1.setPath(path);
		pathTransition1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition1.setCycleCount(Timeline.INDEFINITE);
		pathTransition1.setAutoReverse(false);

		PathTransition pathTransition2 = new PathTransition();
		pathTransition2.setDuration(Duration.millis(1000));
		pathTransition2.setNode(rect2);
		pathTransition2.setPath(path);
		pathTransition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition2.setCycleCount(Timeline.INDEFINITE);
		pathTransition2.setAutoReverse(false);

		ParallelTransition pt1 = new ParallelTransition(rect1, ft, pathTransition1);
		pt1.play();
		SequentialTransition seqT = new SequentialTransition (rect2, ft, pathTransition2);
		seqT.play();



		juur.getChildren().add(rect1);
		juur.getChildren().add(rect2);

		Scene stseen1 = new Scene(juur);

		juur.setLayoutX(300);
		juur.setLayoutY(300);
		peaLava.setTitle("Must ruut");
		peaLava.setScene(stseen1);
		peaLava.show();
	}

	public static void main(String[] args) {
		launch();
	}
}