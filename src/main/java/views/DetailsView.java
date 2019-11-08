package views;

import controllers.ApplicationController;
import controllers.DetailsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

    /**
     * @author Stefan
     *
     *
     */

    public TextArea details_voortgang = new TextArea();
    public TextArea details_beschrijving = new TextArea();
    public TextField details_doorlooptijd = new TextField();
    public TextField details_kosten_anders = new TextField();
    public TextField details_kosten_inovatie = new TextField();
    public ComboBox details_status_kleur = new ComboBox();
    public TextField details_status = new TextField();
    public TextField details_netwerk = new TextField();
    public TextField experiment_leider = new TextField();
    public ComboBox experiment_fase = new ComboBox();
    public TextField experiment_naam = new TextField();
    public TextArea message = new TextArea();
    public ComboBox details_archived = new ComboBox();

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

        String archivedStr = details_archived.getSelectionModel().getSelectedItem().toString();
        boolean archived = !archivedStr.equals("Niet gearchiveerd");
        String archivedType = archived ? (archivedStr.equals("Hall Of Fame") ? "HoF" : "GY" )
                : null;

        System.out.println(archivedStr);

        this.controller.clickedUpdate(
                editingId,
                experiment_naam.getText(),
                experiment_fase.getItems().get(experiment_fase.getSelectionModel().getSelectedIndex()).toString(),
                experiment_leider.getText(),
                details_netwerk.getText(),
                details_status.getText(),
                details_status_kleur.getItems().get(details_status_kleur.getSelectionModel().getSelectedIndex()).toString(),
                details_kosten_inovatie.getText(),
                details_kosten_anders.getText(),
                details_doorlooptijd.getText(),
                details_beschrijving.getText(),
                details_voortgang.getText(),
                archived,
                archivedType

        );
    }

    public void backButton() {
        if(editButton.isDisabled())
            toggleEditable();
        controller.applicationController.experimentListController.experimentList.notifyObservers();
    }

    @FXML
    public void editDetails() {
        toggleEditable();
    }

    private void toggleEditable() {
        Boolean bool = editButton.isDisabled();


        editButton.setDisable(!bool);
        saveButton.setDisable(bool);
        postMessage.setDisable(bool);

        for (Node node : column1.getChildren()) {
            if (node.getStyleClass().contains("detailText")) {
                if(node instanceof TextField) {
                    TextField textField = (TextField) node;
                    textField.setEditable(!bool);
                } else if(node instanceof ComboBox){
                    ComboBox textField = (ComboBox) node;
                    textField.setDisable(bool);
                }
            }
        }
        for (Node node : column2.getChildren()) {
            if (node.getStyleClass().contains("detailText")) {
                if(node instanceof TextField) {
                    TextField textField = (TextField) node;
                    textField.setEditable(!bool);
                } else if(node instanceof ComboBox){
                    ComboBox textField = (ComboBox) node;
                    textField.setDisable(bool);
                }
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
            experiment_fase.getSelectionModel().select(
                    experiment_fase.getItems().indexOf(updatedExperiment.getFase().toString())
            );
            experiment_leider.setText(updatedExperiment.getExperiment_leider());
            experiment_naam.setText(updatedExperiment.getExperiment_naam());

            details_beschrijving.setText(details.getBeschrijving());
            details_kosten_anders.setText(details.getKostenAnders());
            details_doorlooptijd.setText(details.getDoorlooptijd());
            details_kosten_inovatie.setText(details.getKostenInovatie());
            details_netwerk.setText(details.getNetwerk());
            details_status.setText(details.getStatus());
            details_status_kleur.getSelectionModel().select(
                    details_status_kleur.getItems().indexOf(updatedExperiment.getColor())
            );
            details_voortgang.setText(details.getVoortgang());
            details_archived.getSelectionModel().select(
                    details.isArchief() ? (details.getArchiefType().equals("HoF") ? 1 : 2)
                            : 0
            );
        } catch (NullPointerException e) {
            System.out.println("details failed");
            e.printStackTrace();
            editingId = 0;
            experiment_fase.getSelectionModel().select("IDEE");
            experiment_leider.setText("");
            experiment_naam.setText("");

            details_beschrijving.setText("");
            details_kosten_anders.setText("");
            details_doorlooptijd.setText("");
            details_kosten_inovatie.setText("");
            details_netwerk.setText("");
            details_status.setText("");
            details_status_kleur.getSelectionModel().select("GROEN");
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


    /**
     * @author Bart Looij
     *
     * postMessage method This will be called when the post button is pressed in the details view
     * It wil take the experiment id and the text end send it ot the database
     */

    public void postMessage(){
        if(message.getText() .equals("") || message.getText() .equals(" ") || message.getText() .equals("Plz don't do that")){
            message.setText("Plz don't do that");
        }else{
            String experimentid = Integer.toString(editingId);
            System.out.println(message.getText() + experimentid);
            controller.postMessage(message.getText(), experimentid);
            message.clear();
        }

    }
}