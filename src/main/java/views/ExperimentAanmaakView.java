package views;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;
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
import models.Details;
import models.Experiment;
import models.Observable;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import services.HttpClientBuilder;

import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExperimentAanmaakView implements Observer{

    /**
     * @author Maarten
     *
     *
     */

    private Stage primaryStage;
    private PopUpVoorbeeldController controller;
    private ToolsView toolsView;
    private ApplicationController applicationController;
    @FXML public TextField projectnaam;
    @FXML public TextField projectleider1;
    @FXML public TextField projectleider2;
    @FXML public ComboBox combobox;
    @FXML public TextArea beschrijving;
    @FXML public ComboBox statuskleur;

    private Experiment.Color color;
    //Need an empty constructor for FXML
    public ExperimentAanmaakView(){}
    public ExperimentAanmaakView(Stage primaryStage, Object popUpVoorbeeldController) {
        this.primaryStage = primaryStage;
        this.controller = (PopUpVoorbeeldController) popUpVoorbeeldController;
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("choice1", "choice2","choice3");
        ObservableList<String> status = FXCollections.observableArrayList();
        status.addAll("choice1", "choice2","choice3");
        combobox.setItems(list);
        statuskleur.setItems(status);
    }

    public void addExperiment(){
        Experiment.Fase fase = Experiment.Fase.LAB_IN;
        Experiment.Color color = Experiment.Color.GREEN;
        String projectname = projectnaam.getText();
        String projectleader1 = projectleider1.getText();
        String projectleader2 = projectleider2.getText();
        String combodoos = String.valueOf(combobox.getValue());


        String description = String.valueOf(beschrijving);

        String status_kleur = String.valueOf(statuskleur.getValue());
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        Timestamp ts = Timestamp.valueOf(date);


        switch (combodoos) {
            case "Idee":
                fase = Experiment.Fase.IDEE;
                break;
            case "Lab in":
               fase = Experiment.Fase.LAB_IN;
                break;
            case "Lab uit":
                fase = Experiment.Fase.LAB_UIT;
                break;
        }
        switch (status_kleur) {
            case "Groen":
                color = Experiment.Color.GREEN;
                break;
            case "Oranje":
                color = Experiment.Color.ORANGE;
                break;
            case "Rood":
                color = Experiment.Color.RED;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status_kleur);
        }

        Experiment newExperiment = new Experiment(150, projectname, ts, fase, projectleader1, color);
        System.out.println(color);
        HttpClientBuilder requester = new HttpClientBuilder();
        int experimentId = Integer.parseInt(
                requester.httpPostAdd(newExperiment, "experimenten", "create")
        );

        Details experimentDetails = new Details();
        experimentDetails.setExperimentId(experimentId);
        experimentDetails.setNetwerk("");
        experimentDetails.setBeschrijving("");
        experimentDetails.setDoorlooptijd("");
        experimentDetails.setKostenInovatie("");
        experimentDetails.setKostenAnders("");
        experimentDetails.setStatus("");
        experimentDetails.setVoortgang("");
        experimentDetails.setArchiefType(null);
        requester.httpPostAdd(experimentDetails, "experimentDetails", "create");

//        primaryStage.hide();
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
