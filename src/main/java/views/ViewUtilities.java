package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewUtilities {

    //the dimensions of the client's screen
    public static double screenWidth = Screen.getPrimary().getBounds().getWidth();
    public static double screenHeight = Screen.getPrimary().getBounds().getHeight();

    public static Parent loadFxml(String location, Stage stage, Object controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();

            Parent root = fxmlLoader.<Parent>load(ViewUtilities.class.getResourceAsStream(location));

            Observer observer = (Observer)fxmlLoader.getController();
            observer.setStage(stage);
            observer.setController(controller);

            observer.start();

            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
