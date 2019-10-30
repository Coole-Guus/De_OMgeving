package views;

import controllers.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.Observable;

public class MainView implements Observer {

    private ExperimentListView experimentListView;
    private FilterView filterView;
    private DetailsView detailsView;
    private OrderByView orderView;
    private ToolsView toolView;


    private Stage primaryStage;
    private MainController controller;

    public ImageView exitButton;

    private  Node mainNode;

    public HBox topRibbon = new HBox();
    private Button[] experimentButtons = new Button[3];

    public MainView() { }

    public MainView(Stage primaryStage, Object mainController) {
        this.primaryStage = primaryStage;

        this.controller = (MainController) mainController;

        start();
        show();
    }

    public void show() {
        Parent root = ViewUtilities.loadFxml("/MainView.fxml", primaryStage, controller);

        //load tools segment
        Node toolsNode = controller.applicationController.loadViewSegment(ToolsView.class, controller.applicationController.toolsController);
        AnchorPane toolsPane = (AnchorPane) root.lookup("#toolsTab");
        toolsPane.getChildren().add(toolsNode);

        // load filter segment
        Node filterNode = controller.applicationController.loadViewSegment(FilterView.class, controller.applicationController.filterController);
        AnchorPane filterPane = (AnchorPane) root.lookup("#filterTab");
        System.out.println(filterNode + "+" + filterPane);
        filterPane.getChildren().add(filterNode);

        // load mainsection segment set in mainNode VAR
        ScrollPane mainPane = (ScrollPane) root.lookup("#mainSection");
        mainPane.setContent(mainNode);
        mainPane.setPrefHeight(ViewUtilities.screenHeight - 120);
        mainPane.setPrefWidth(ViewUtilities.screenWidth - 200);

        Pane pane = (Pane)root.lookup("AnchorPane");

        primaryStage.getScene().setRoot(pane);
    }

    public void setupExperimentButtons() {
        String labels[] = {
                "Status 1",
                "Status 2",
                "Status 3" };
        for(int i = 0; i < experimentButtons.length; i++) {
            Button button = new Button();
//            button.addEventHandler(ActionEvent.ACTION, event -> toggleStatus());
            button.setText(labels[i]);
            button.setId(Integer.toString(i));
            button.setPrefHeight(50);
            experimentButtons[i] = button;
        }
    }

    private void toggleStatus(int status) {

    }



    public void loadButtons(Button buttonlist[]) {
            topRibbon.getChildren().removeAll();

        for (Button button : buttonlist) {
            topRibbon.getChildren().add(button);
        }
    }


    @FXML
    public void exitButton() {
        controller.exit();
    }

    @FXML
    public void toggleExitButton() {
        if (exitButton.getOpacity() == 1) {
            exitButton.setOpacity(0.3);
        }
        else {
            exitButton.setOpacity(1);
        }
    }


    @Override
    public void setStage(Stage stage) {

    }

    @Override
    public void setController(Object controller) {
        MainController mainController= (MainController) controller;
        this.controller = mainController;
    }

    @Override
    public void update(Observable observable) {

    }

    @Override
    public void start() {
        setupExperimentButtons();
        loadButtons(experimentButtons);
        mainNode = controller.applicationController.loadViewSegment(
                ExperimentListView.class, controller.applicationController.experimentListController
        );

    }

    @Override
    public Node getParent() {
        return null;
    }
}
