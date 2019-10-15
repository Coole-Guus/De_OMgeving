package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Observable;

import java.io.IOException;

public class MainView implements Observer {
    private final String GUI_FILE = this.getClass().getSimpleName().concat(".fxml");

    private ExperimentListView experimentListView;
    private FilterView filterView;
    private DetailsView detailsView;
    private OrderByView orderView;
    private ToolsView toolView;

    private Stage primaryStage;

    public MainView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        experimentListView = new ExperimentListView();
        filterView = new FilterView();
        detailsView = new DetailsView();
        orderView = new OrderByView();
        toolView = new ToolsView();

        try {
            Parent gui = this.createGUI();

            BorderPane g = (BorderPane) gui.lookup("#mainBorderPane");
            g.setCenter(experimentListView.createGUI());
            System.out.println(g);
            primaryStage.setScene(new Scene(gui));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Parent createGUI() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(GUI_FILE));
        loader.setController(this);
        return loader.load();
    }

    @Override
    public void update(Observable observable) {

    }
}
