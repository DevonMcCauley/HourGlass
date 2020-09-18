package org.devon.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.devon.utilities.DBConnection;

import java.io.IOException;


public class App extends Application {

    static Stage stage;

    //getStage method for setting titles of windows & changing scenes
    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) {
        App.stage = stage;

        Parent main;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginScreen.fxml"));
            main = loader.load();
            Scene scene = new Scene(main);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("HourGlass");
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBConnection.startConnection();
        launch(args);
        DBConnection.closeConnection();
    }
}