package views;

import controllers.ApplicationController;
import controllers.DetailsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Details;
import models.Experiment;
import models.Observable;
import services.HttpClientBuilder;
import sun.plugin.javascript.navig.Anchor;

import javax.xml.soap.Text;

public class DetailsView implements Observer {

    public TextArea details_voortgang = new TextArea();
    public TextArea details_beschrijving = new TextArea();
    public TextField details_doorlooptijd = new TextField();
    public TextField details_kosten_anders = new TextField();
    public TextField details_kosten_inovatie = new TextField();
    public TextField details_status_kleur = new TextField();
    public TextField details_status = new TextField();
    public TextField details_netwerk = new TextField();
    public TextField experiment_leider = new TextField();
    public TextField experiment_fase = new TextField();
    public TextField experiment_naam = new TextField();
    public TextArea message = new TextArea();

    public VBox column1 = new VBox();
    public VBox column2 = new VBox();

    public Button editButton = new Button();
    public Button saveButton = new Button();
    public Button postMessage = new Button();


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
        toggleEditable();

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
                details_voortgang.getText()
        );
    }

    public void backButton() {
        toggleEditable();
        controller.applicationController.experimentListController.experimentList.notifyObservers();
    }

    @FXML
    public void editDetails() {
        toggleEditable();
    }

    private void toggleEditable() {
        Boolean bool = editButton.isDisabled();
        System.out.println(bool);

        editButton.setDisable(!bool);
        saveButton.setDisable(bool);
        postMessage.setDisable(bool);

        for (Node node : column1.getChildren()) {
            if (node.getStyleClass().contains("detailText")) {
                TextField textField = (TextField) node;
                textField.setEditable(!bool);
            }
        }
        for (Node node : column2.getChildren()) {
            if (node.getStyleClass().contains("detailText")) {
                TextField textField = (TextField) node;
                textField.setEditable(!bool);
            }
            else if (node.getStyleClass().contains("detailTextArea")) {
                TextArea textArea = (TextArea) node;
                textArea.setEditable(!bool);
            }
        }

        message.setEditable(!bool);
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
        try {
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
            details_status_kleur.setText(updatedExperiment.getColor());
            details_voortgang.setText(details.getVoortgang());
        } catch (NullPointerException e) {
            System.out.println("details failed");
            e.printStackTrace();
            editingId = 0;
            experiment_fase.setText("");
            experiment_leider.setText("");
            experiment_naam.setText("");

            details_beschrijving.setText("");
            details_kosten_anders.setText("");
            details_doorlooptijd.setText("");
            details_kosten_inovatie.setText("");
            details_netwerk.setText("");
            details_status.setText("");
            details_status_kleur.setText("");
            details_voortgang.setText("");
        }

    }

    @Override
    public void start() {
        loadUpdateHistory();
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
//    public void addDetails(){
//        experimentID = (int) applicationController.httpClientBuilder.httpGet(Integer.class, "experimenten", "lastID");
//        System.out.println(experimentID);
////        Details newDetails = new Details();
////        (new HttpClientBuilder()).httpPostAdd(newDetails, "experimentDetails", "create");
//    }
    public void postMessage(){
//        controller.postMessage(message.getText());
        System.out.println(message.getText());
    }
}