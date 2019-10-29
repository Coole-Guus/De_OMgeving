package views;

import controllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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

    public HBox topRibbon;
    private Button[] experimentButtons = new Button[3];

    public MainView() { }

    public MainView(Stage primaryStage, Object mainController) {
        this.primaryStage = primaryStage;

        this.controller = (MainController) mainController;

        experimentListView = new ExperimentListView();
        filterView = new FilterView();
        detailsView = new DetailsView();
        orderView = new OrderByView();
        toolView = new ToolsView();
        start();
        show();
    }

    public void show() {
        Parent root = ViewUtilities.loadFxml("/MainView.fxml", primaryStage, controller);

        Pane pane = (Pane)root.lookup("AnchorPane");

        primaryStage.getScene().setRoot(pane);
    }

    public void setupExperimentButtons() {
        System.out.println();
        String labels[] = {
                "Status",
                "Status",
                "Status"
        };
        for(int i = 0; i < experimentButtons.length; i++) {
            System.out.println(i);
            Button button = new Button();
            button.setText("button");
            button.setId(Integer.toString(i));
            experimentButtons[i] = button;
        }

    }

    public void loadButtons(Button buttonlist[]) {
        topRibbon.getChildren().removeAll();
        for (Button button : buttonlist) {
            topRibbon.getChildren().add(button);
        }
    }

    public void loadExperimentList() {
           loadButtons(experimentButtons);
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
    }
}
