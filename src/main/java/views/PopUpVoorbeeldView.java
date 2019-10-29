package views;

import controllers.PopUpVoorbeeldController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Observable;

public class PopUpVoorbeeldView implements Observer{

    private Stage primaryStage;
    private PopUpVoorbeeldController controller;

    //Need an empty constructor for FXML
    public PopUpVoorbeeldView(){}
    public PopUpVoorbeeldView(Stage primaryStage, Object popUpVoorbeeldController) {
        this.primaryStage = primaryStage;
        this.controller = (PopUpVoorbeeldController) popUpVoorbeeldController;

        show();
    }

    public void show() {
        Parent root = ViewUtilities.loadFxml("/Pop-up_voorbeeld.fxml", primaryStage, controller);

        Pane pane = (Pane)root.lookup("AnchorPane");

        Scene scene = new Scene(root, 500, 200);
        Stage stagePopUp = new Stage(StageStyle.DECORATED);
        stagePopUp.initOwner(primaryStage);
        stagePopUp.initModality(Modality.APPLICATION_MODAL);
        stagePopUp.setScene(scene);
        stagePopUp.show();
    }

    @FXML
    public void buttonFunction() {
        controller.buttonFunction();
    }

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
}
