package com.example.worldrallycrosschampionship;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class WorldRallyCrossChampionship extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WorldRallyCrossChampionship.class.getResource("welcomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("World Rally Cross Championship");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

