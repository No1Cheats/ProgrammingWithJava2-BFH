package ch.bfh;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloWorld extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        final StackPane stackPane = new StackPane();
        stackPane.getChildren().add(new Label("Hello from my first JavaFX app!"));
        stage.setScene(new Scene(stackPane, 250, 75));
        stage.setTitle("Hello World");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}