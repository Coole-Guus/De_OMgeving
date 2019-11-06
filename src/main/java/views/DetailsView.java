package views;

import controllers.DetailsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Details;
import models.Experiment;
import models.Observable;

public class DetailsView implements Observer {

    public TextField details_voortgang;
    public TextField details_beschrijving;
    public TextField details_doorlooptijd;
    public TextField details_kosten_anders;
    public TextField details_kosten_inovatie;
    public TextField details_status_kleur;
    public TextField details_status;
    public TextField details_netwerk;
    public TextField experiment_leider;
    public TextField experiment_fase;
    public TextField experiment_naam;

    private DetailsController controller;
    private Stage primaryStage;

    public DetailsView() { }

    public DetailsView(Stage primaryStage, Object filterController) {
        this.primaryStage = primaryStage;

        this.controller = (DetailsController) filterController;
    }

    public void clickedUpdate(ActionEvent actionEvent) {

        this.controller.clickedUpdate(
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
        System.out.println("getting update");
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
        controller.loadDetails(this);
        controller.registerObserver(this);

    }

    @Override
    public Node getParent() {
        Parent node = ViewUtilities.loadFxml("/DetailsView.fxml", primaryStage, controller, this);
        return node;
    }
}