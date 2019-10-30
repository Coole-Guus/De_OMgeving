package views;

import javafx.scene.Node;
import javafx.stage.Stage;
import models.Observable;

public interface Observer {

    public void setStage(Stage stage);

    public void setController(Object controller);

    public void update(Observable observable);

    public void start();

    public Node getParent();
}
