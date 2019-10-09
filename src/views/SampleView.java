package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SampleView {
    private Scene scene;
    private Stage primaryStage;

    public SampleView(Stage primaryStage) {
    }
    public void setStage(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.createScene();
        primaryStage.setScene(scene);
    }

    private void createScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            this.scene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
