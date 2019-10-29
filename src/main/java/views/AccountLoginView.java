package views;

import controllers.AccountLoginController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Observable;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import services.HttpClientBuilder;


import javax.print.attribute.standard.RequestingUserName;

public class AccountLoginView implements Observer {

    private HttpClientBuilder httpClientBuilder = new HttpClientBuilder ();
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

    @FXML
    public void loginButton(){
        controller.login();
//        httpClientBuilder.httpGet ("experimenten", username.getText (), password.getText ());
    }

}