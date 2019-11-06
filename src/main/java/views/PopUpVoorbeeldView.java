package views;

import controllers.ApplicationController;
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
import models.Experiment;
import models.Observable;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import services.HttpClientBuilder;

import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PopUpVoorbeeldView implements Observer{

    private Stage primaryStage;
    private PopUpVoorbeeldController controller;
    private ToolsView toolsView;
    private ApplicationController applicationController;
    @FXML public TextField projectnaam;
    @FXML public TextField projectleider1;
    @FXML public TextField projectleider2;
    @FXML public ComboBox combobox;
    @FXML public TextArea beschrijving;
    //Need an empty constructor for FXML
    public PopUpVoorbeeldView(){}
    public PopUpVoorbeeldView(Stage primaryStage, Object popUpVoorbeeldController) {
        this.primaryStage = primaryStage;
        this.controller = (PopUpVoorbeeldController) popUpVoorbeeldController;
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("choice1", "choice2","choice3");
        combobox.setItems(list);

    }
//    @FXML
//    private void loginSubmitClick(ActionEvent e){
//        System.out.println(projectnaam.getText());
//        System.out.println(projectleider1.getText());
//        System.out.println(projectleider2.getText());
//        System.out.println(combobox.getValue());
//        Date date = new Date();
//        System.out.println(date);
//        System.out.println(beschrijving.getText());
////        applicationController.httpClientBuilder.httpGet ("experimentDetails", projectnaam.getText(), projectleider1.getText(), projectleider2.getText(), String.valueOf(combobox));
//    }
    @FXML
    public void addExperiment(){
        String projectname = projectnaam.getText();
        String projectleader1 = projectleider1.getText();
        String projectleader2 = projectleider2.getText();
        String combodoos = String.valueOf(combobox);
        String description = String.valueOf(beschrijving);
        String pattern = "yyyy-MM-dd HH:mm:ss";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date = simpleDateFormat.format(new Date());
//        Timestamp ts = Timestamp.valueOf(date);
        Date date = new Date();
        Experiment.Fase fase = Experiment.Fase.LAB_IN;
        if(combodoos.equals("Idee"))
            fase = Experiment.Fase.IDEE;
        else if(combodoos.equals("Lab in"))
            fase = Experiment.Fase.LAB_IN;
        else if(combodoos.equals("Lab uit"))
            fase = Experiment.Fase.LAB_UIT;
        Experiment.Color color = Experiment.Color.GREEN;
//        Experiment newExperiment = new Experiment(0, projectname, ts,  fase, projectleader1);
        Experiment newExperiment = new Experiment(0, projectname, date, fase, projectleader1, color);
        (new HttpClientBuilder()).httpPostAdd(newExperiment);

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
