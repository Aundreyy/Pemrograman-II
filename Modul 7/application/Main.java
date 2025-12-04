package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Scene scene = new Scene(FXMLLoader.
            		load(getClass().
            				getResource("/views/DashboardView.fxml")));
            scene.getStylesheets().add(getClass().
            		getResource("application.css").
            		toExternalForm());
            stage.setTitle("Sistem Toko Buku");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) { e.printStackTrace(); 
        }
    }
    public static void main(String[] args) { launch(args); }
}