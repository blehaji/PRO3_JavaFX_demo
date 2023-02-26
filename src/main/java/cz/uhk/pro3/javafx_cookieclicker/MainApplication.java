package cz.uhk.pro3.javafx_cookieclicker;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainApplication extends Application {
    MainController controller;
    Timer timer;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        stage.setTitle("JavaFX Cookie Clicker");
        stage.setScene(scene);
        stage.setOnCloseRequest(this::stopTimer);
        stage.show();

        controller = fxmlLoader.getController();
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(controller::tick);
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void stopTimer(WindowEvent evt) {
        timer.cancel();
    }

    public static void main(String[] args) {
        launch();
    }
}