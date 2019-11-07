package views;

import controllers.AccountLoginController;
import controllers.ToolsController;
import controllers.UserManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.ExperimentList;
import models.Observable;
import models.UserManagement;

public class UserManagementView implements Observer {
    public AnchorPane accountList = new AnchorPane();
    private UserManagementController controller;
    private Stage primaryStage;

    @FXML
    public TextField inputUsername;
    @FXML
    public TextField inputPassword;
    @FXML
    public ComboBox inputRol;
    @FXML
    public TextField deleteUsername;



    //Need an empty constructor for FXML
    public UserManagementView(){}
    public UserManagementView(Stage primaryStage, Object userManagementController) {

        start ();
    }

    @Override
    public void setStage(Stage stage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void setController(Object controller) {
        this.controller = (UserManagementController) controller;
    }

    @Override
    public void update(Observable observable) {
        System.out.println("updating accounts...");
        updateList((UserManagement) observable);
    }

    private void updateList(UserManagement userManagement) {
        System.out.println ("set getChildren");
        accountList.getChildren().add(userManagement.accountCard);
    }

    @Override
    public void start() {
        controller.registerObserver(this);
        controller.Usermanagerment ();
    }

    @Override
    public Node getParent() {
        Parent node = ViewUtilities.loadFxml("/UserManagementView.fxml", primaryStage, controller);
        return node;
    }

    public void addUser(ActionEvent actionEvent) {
        if(inputRol.getSelectionModel ().getSelectedItem () != null)
            controller.addUser (inputUsername.getText (), inputPassword.getText (), inputRol.getSelectionModel ().getSelectedItem ().toString ());
    }

    public void removeUser(ActionEvent actionEvent) {
        controller.removeUser(deleteUsername.getText ());
    }
}
