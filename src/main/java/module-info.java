module com.example.oop_javafx {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.example.oop_javafx to javafx.fxml;
	exports com.example.oop_javafx;
}