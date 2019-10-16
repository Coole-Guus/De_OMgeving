package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import models.Observable;

import java.io.IOException;

public class ExperimentListView implements Observer {
    private final String GUI_FILE = this.getClass().getSimpleName().concat(".fxml");
    private Parent GUI;

    @Override
    public void setStage(Stage stage) {

    }

    @Override
    public void setController(Object controller) {

    }

    @Override
    public void update(Observable observable) {

    }

    @Override
    public void start() {

    }

    public Parent createGUI() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(GUI_FILE));
        loader.setController(this);

        this.GUI = loader.load();
        return this.GUI;
    }
}