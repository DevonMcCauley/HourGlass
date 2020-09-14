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

    @Override
    public void start(Stage stage) {
        App.stage = stage;


        Parent main = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginScreen.fxml"));
            main = loader.load();
            Scene scene = new Scene(main);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("HourGlass");
            stage.setResizable(false);
            //stage.getIcons().add(new Image("resources/images/hourglass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //getStage method for setting titles of windows & changing scenes
    public static Stage getStage() {
        return stage;
    }

    //Method to change the scene
    public static void changeScene(String screen, String title) {
        Parent main = null;
        try {
            main = FXMLLoader.load(App.class.getResource(screen));
            Scene scene = new Scene(main);
            Stage stage = App.getStage();
            stage.setScene(scene);
            stage.show();
            stage.setTitle(title);
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