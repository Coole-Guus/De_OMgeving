package views;

import controllers.ApplicationController;
import controllers.DetailsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Details;
import models.Experiment;
import models.Observable;
import services.HttpClientBuilder;
import sun.plugin.javascript.navig.Anchor;

public class DetailsView implements Observer {

    public TextField details_voortgang = new TextField();
    public TextField details_beschrijving = new TextField();
    public TextField details_doorlooptijd = new TextField();
    public TextField details_kosten_anders = new TextField();
    public TextField details_kosten_inovatie = new TextField();
    public TextField details_status_kleur = new TextField();
    public TextField details_status = new TextField();
    public TextField details_netwerk = new TextField();
    public TextField experiment_leider = new TextField();
    public TextField experiment_fase = new TextField();
    public TextField experiment_naam = new TextField();
    public TextField message = new TextField();



    public AnchorPane updateHistoryPane = new AnchorPane();

    private int editingId;
    private int experimentID;
    private ApplicationController applicationController;

    private DetailsController controller;
    private Stage primaryStage;
    private Integer integer;
    private Parent root;

    public DetailsView() { }




    public DetailsView(Stage primaryStage, Object filterController) {
        this.primaryStage = primaryStage;

        this.controller = (DetailsController) filterController;
    }

    public void clickedUpdate(ActionEvent actionEvent) {

        this.controller.clickedUpdate(
                editingId,
                experiment_naam.getText(),
                experiment_fase.getText(),
                experiment_leider.getText(),
                details_netwerk.getText(),
                details_status.getText(),
                details_status_kleur.getText(),
                details_kosten_inovatie.getText(),
                details_kosten_anders.getText(),
                details_doorlooptijd.getText(),
                details_beschrijving.getText(),
                details_voortgang.getText(),
                message.getText()
        );
    }


    @Override
    public void setStage(Stage stage) {

    }

    @Override
    public void setController(Object controller) {

    }

    @Override
    public void update(Observable observable) {
        Experiment updatedExperiment = (Experiment) observable;
        Details details = updatedExperiment.details;
        editingId = updatedExperiment.getExperimentId();
        experiment_fase.setText(updatedExperiment.getFase().toString());
        experiment_leider.setText(updatedExperiment.getExperiment_leider());
        experiment_naam.setText(updatedExperiment.getExperiment_naam());


        details_beschrijving.setText(details.getBeschrijving());
        details_kosten_anders.setText(details.getKostenAnders());
        details_doorlooptijd.setText(details.getDoorlooptijd());
        details_kosten_inovatie.setText(details.getKostenInovatie());
        details_netwerk.setText(details.getNetwerk());
        details_status.setText(details.getStatus());
        details_status_kleur.setText(details.getStatusKleur());
        details_voortgang.setText(details.getVoortgang());
    }

    @Override
    public void start() {
        loadUpdateHistory();
        System.out.println();
        controller.registerObserver(this);
    }

    private void loadUpdateHistory() {
        updateHistoryPane.getChildren().add(controller.applicationController.loadViewSegment(
                UpdateHistoryView.class, controller.applicationController.updateHistoryController
        ));
    }

    @Override
    public Node getParent() {
        Parent node = ViewUtilities.loadFxml("/DetailsView.fxml", primaryStage, controller, this);
        return node;
    }
    public void addDetails(){
        experimentID = (int) applicationController.httpClientBuilder.httpGet(Integer.class, "experimenten", "lastID");
        System.out.println(experimentID);
//        Details newDetails = new Details();
//        (new HttpClientBuilder()).httpPostAdd(newDetails, "experimentDetails", "create");
    }
    public void postMessage(){
//        controller.postMessage(message.getText());
        System.out.println(message.getText());
    }
}