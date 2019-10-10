package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Observable;

import java.io.IOException;

public class MainView implements Observer {
    private ProjectListView projectListView;
    private FilterView filterView;
    private DetailsView detailsView;
    private OrderByView orderView;
    private ToolsView toolView;

    private Stage primaryStage;

    public MainView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        projectListView = new ProjectListView();
        filterView = new FilterView();
        detailsView = new DetailsView();
        orderView = new OrderByView();
        toolView = new ToolsView();

        try {
            Parent gui = this.createGUI();
            primaryStage.setScene(new Scene(gui));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Parent createGUI() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MainView.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        return root;
    }

    @Override
    public void update(Observable observable) {

    }
}
