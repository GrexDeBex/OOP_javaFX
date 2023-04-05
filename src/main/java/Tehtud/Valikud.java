package Tehtud;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class Valikud extends Application {
	@Override
	public void start(Stage peaLava) throws IOException {
		VBox juur = new VBox();

		Text t = new Text("Millisel koduloomal on 4 jalga?");
		t.setFont(Font.font(30));
		juur.getChildren().add(t);

		RadioButton rb1 = new RadioButton("Koer");
		RadioButton rb2 = new RadioButton("Inimene");
		RadioButton rb3 = new RadioButton("Kala");
		ToggleGroup tg = new ToggleGroup();

		rb1.setFont(Font.font(30));
		rb2.setFont(Font.font(30));
		rb3.setFont(Font.font(30));

		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb3.setToggleGroup(tg);

		juur.getChildren().add(rb1);
		juur.getChildren().add(rb2);
		juur.getChildren().add(rb3);

		rb1.setOnAction(event -> {
			rb1.setTextFill(Color.GREEN);
			rb2.setTextFill(Color.BLACK);
			rb3.setTextFill(Color.BLACK);
		});

		rb2.setOnAction(event -> {
			rb1.setTextFill(Color.BLACK);
			rb2.setTextFill(Color.RED);
			rb3.setTextFill(Color.BLACK);
		});

		rb3.setOnAction(event -> {
			rb1.setTextFill(Color.BLACK);
			rb2.setTextFill(Color.BLACK);
			rb3.setTextFill(Color.RED);
		});


		Scene stseen = new Scene(juur);
		peaLava.setScene(stseen);
		peaLava.show();
	}

	public static void main(String[] args) {
		launch();
	}
}