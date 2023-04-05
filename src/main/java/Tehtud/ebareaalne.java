package Tehtud;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class ebareaalne extends Application {
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

		Scene stseen = new Scene(juur);
		peaLava.setScene(stseen);
		peaLava.show();
	}

	public static void main(String[] args) {
		launch();
	}
}