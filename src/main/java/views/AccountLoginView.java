package views;

import controllers.AccountLoginController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Observable;

public class AccountLoginView implements Observer {

    private Stage primaryStage;
    private AccountLoginController controller;
    @FXML
    public TextField username;
    @FXML
    public TextField password;

    //Need an empty constructor for FXML
    public AccountLoginView(){}
    public AccountLoginView(Stage primaryStage, Object accountLoginController) {
        this.primaryStage = primaryStage;
        this.controller = (AccountLoginController) accountLoginController;
        show();
    }

    private void show() {
        Parent root = ViewUtilities.loadFxml("/AccountLoginView.fxml", primaryStage, controller);

        Pane pane = (Pane)root.lookup("AnchorPane");

        primaryStage.getScene().setRoot(pane);
    }

    @Override
    public void setStage(Stage stage) {

    }

    @Override
    public void setController(Object controller) {
        AccountLoginController accountloginController = (AccountLoginController) controller;
        this.controller = accountloginController;
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

    @FXML
    public void loginButton(){
        controller.login (username.getText (), password.getText ());

    }

}