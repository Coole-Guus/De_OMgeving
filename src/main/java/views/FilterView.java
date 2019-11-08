package views;

import controllers.FilterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Observable;

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
    public CheckBox HoF;
    public CheckBox GY;


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
        FilterController filterController = (FilterController) controller;
        this.controller = filterController;
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

    /**
     * @author Bart Looij
     *
     *search this will take the text from the text box ent send it to the httpclient
     */

    @FXML
    public void search(){
        if (searchBar.getText().isEmpty()) {
            controller.applicationController.experimentListController.updateList("");
            uncheck();
        }
        else {
            controller.Search("filterSearch", searchBar.getText());
            uncheck();
        }

    }

    /**
     * @author Bart Looij
     *
     * Checkpress method when one of the checkboxes is used then this method wilt start it will take the checkbox id and
     * put it in the switch will cal the filter controller
     */

    @FXML
    public void Checkpress(ActionEvent actionEvent) {
        CheckBox checkBox = (CheckBox) actionEvent.getTarget();
        if (checkBox.isSelected()) {
            int ID = Integer.parseInt(checkBox.getId());
            uncheck();
            switch(ID) {
                case 1:
                    LabIn.setSelected(true);
                    controller.filter("filterLabIn");
                    break;
                case 2:
                    Idee.setSelected(true);
                    controller.filter("filterIdee");
                    break;
                case 3:
                    LabUit.setSelected(true);
                    controller.filter("filterLabUit");
                    break;
                case 4:
                    NaamOp.setSelected(true);
                    controller.filter("orderNameAsc");
                    break;
                case 5:
                    NaamAf.setSelected(true);
                    controller.filter("orderNameDesc");
                    break;
                case 6:
                    LeiderOp.setSelected(true);
                    controller.filter("orderLiederAsc");
                    break;
                case 7:
                    LeiderAf.setSelected(true);
                    controller.filter("orderLiederDesc");
                    break;
                case 8:
                    GewijzigdOp.setSelected(true);
                    controller.filter("orderEditedAsc");
                    break;
                case 9:
                    GewijzigdAf.setSelected(true);
                    controller.filter("orderEditedDesc");
                    break;
                case 10:
                    HoF.setSelected(true);
                    controller.filter("filterHoF");
                    break;
                case 11:
                    GY.setSelected(true);
                    controller.filter("filterGY");
                    break;
            }
        }
        else {
            uncheck();
            controller.applicationController.experimentListController.updateList("");
        }
    }

    /**
     * @author Bart Looij
     *
     * unchecks all checkboxes when checkbox is used
     */

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
        HoF.setSelected(false);
        GY.setSelected(false);

    }
}