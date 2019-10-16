package views;

import javafx.stage.Stage;
import models.Observable;

public interface Observer {

    public void setStage(Stage stage);

    public void setController(Object controller);

    public void update(Observable observable);

    public void start();
}
