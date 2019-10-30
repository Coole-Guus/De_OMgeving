package views;

import controllers.FilterController;
import controllers.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Observable;

import javax.swing.*;


public class FilterView implements Observer {
    private Stage primaryStage;
    private FilterController controller;

    public VBox vbox;
    public CheckBox LabIn;
    public CheckBox LabUit;
    public CheckBox Idee;
    public CheckBox NaamOp;
    public CheckBox NaamAf;
    public CheckBox LeiderOp;
    public CheckBox LeiderAf;
    public CheckBox GewijzigdOp;
    public CheckBox GewijzigdAf;
    public TextField searchBar;


    public FilterView() { }




    public FilterView(Stage primaryStage, Object filterController) {
        this.primaryStage = primaryStage;

        this.controller = (FilterController) filterController;

        start();
    }

    @Override
    public void setStage(Stage stage) {
        this.primaryStage = stage;
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
        Parent node = ViewUtilities.loadFxml("/FilterView.fxml", primaryStage, controller);

        return node;
    }

    @FXML
    public void search(){
        System.out.println(searchBar.getText());

    }

    @FXML
    public void Checkpress(ActionEvent actionEvent) {
        CheckBox checkBox = (CheckBox) actionEvent.getTarget();
        int ID = Integer.parseInt(checkBox.getId());

        switch(ID){
            case 1:
                uncheck();
                LabIn.setSelected(true);
                break;
            case 2:
                uncheck();
                Idee.setSelected(true);
                break;
            case 3:
                uncheck();
                LabUit.setSelected(true);
                break;
            case 4:
                uncheck();
                NaamOp.setSelected(true);
                break;
            case 5:
                uncheck();
                NaamAf.setSelected(true);
                break;
            case 6:
                uncheck();
                LeiderOp.setSelected(true);
                break;
            case 7:
                uncheck();
                LeiderAf.setSelected(true);
                break;
            case 8:
                uncheck();
                GewijzigdOp.setSelected(true);
                break;
            case 9:
                uncheck();
                GewijzigdAf.setSelected(true);
                break;
        }
    }

    public void uncheck(){
        LabUit.setSelected(false);
        LabIn.setSelected(false);
        Idee.setSelected(false);
        NaamOp.setSelected(false);
        NaamAf.setSelected(false);
        LeiderOp.setSelected(false);
        LeiderAf.setSelected(false);
        GewijzigdOp.setSelected(false);
        GewijzigdAf.setSelected(false);

    }
}