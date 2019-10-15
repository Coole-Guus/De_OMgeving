package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import models.Observable;

import java.io.IOException;

public class ExperimentListView implements Observer {
    private final String GUI_FILE = this.getClass().getSimpleName().concat(".fxml");
    private Parent GUI;

    @Override
    public void update(Observable observable) {

    }

    public Parent createGUI() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(GUI_FILE));
        loader.setController(this);

        this.GUI = loader.load();
        return this.GUI;
    }
}