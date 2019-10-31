package views;

import controllers.PopUpVoorbeeldController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Observable;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

import java.awt.*;

public class PopUpVoorbeeldView implements Observer{

    private Stage primaryStage;
    private PopUpVoorbeeldController controller;
    private ToolsView toolsView;
    @FXML public TextField projectnaam;
    @FXML public TextField projectleider1;
    @FXML public TextField projectleider2;
    @FXML public ComboBox combobox;

    //Need an empty constructor for FXML
    public PopUpVoorbeeldView(){}
    public PopUpVoorbeeldView(Stage primaryStage, Object popUpVoorbeeldController) {
        this.primaryStage = primaryStage;
        this.controller = (PopUpVoorbeeldController) popUpVoorbeeldController;
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("choice1", "choice2","choice3");
        combobox.setItems(list);

    }
    @FXML
    private void loginSubmitClick(ActionEvent e){
        System.out.println(projectnaam.getText());
        System.out.println(projectleider1.getText());
        System.out.println(projectleider2.getText());
        System.out.println(combobox.getValue());
    }

    public void show() {

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

    @Override
    public Node getParent() {
        return null;
    }
}
