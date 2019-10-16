package views;

import controllers.AccountLoginController;
import controllers.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Observable;

import java.io.IOException;

public class MainView implements Observer {

    private ExperimentListView experimentListView;
    private FilterView filterView;
    private DetailsView detailsView;
    private OrderByView orderView;
    private ToolsView toolView;


    private Stage primaryStage;
    private MainController controller;


    public MainView() {}
    public MainView(Stage primaryStage, Object mainController) {
        this.primaryStage = primaryStage;

        this.controller = (MainController) mainController;

        experimentListView = new ExperimentListView();
        filterView = new FilterView();
        detailsView = new DetailsView();
        orderView = new OrderByView();
        toolView = new ToolsView();

        show();
    }

    public void show() {
        System.out.println("hier niet null");

        Parent root = ViewUtilities.loadFxml("/MainView.fxml", primaryStage, controller);

        Pane pane = (Pane)root.lookup("AnchorPane");

        primaryStage.getScene().setRoot(pane);
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
}
