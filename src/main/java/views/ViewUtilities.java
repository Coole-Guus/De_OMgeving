package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewUtilities {

    //the dimensions of the client's screen
    public static double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
    public static double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
    public static double screenMinX = Screen.getPrimary().getVisualBounds().getMinX();
    public static double screenMinY = Screen.getPrimary().getVisualBounds().getMinY();

    public static Parent loadFxml(String location, Stage stage, Object controller) {
        return loadFxml(location, stage, controller, null);
    }

    public static Parent loadFxml(String location, Stage stage, Object controller, Observer viewController) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            if(viewController != null){

                fxmlLoader.setController(viewController);
            }
            Parent root = fxmlLoader.<Parent>load(ViewUtilities.class.getResourceAsStream(location));

            if(viewController == null){
                Observer observer = (Observer) fxmlLoader.getController();
                observer.setStage(stage);
                observer.setController(controller);

                observer.start();
            } else {
                viewController.start();
            }

            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

