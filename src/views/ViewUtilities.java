package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
            System.out.println("getController returns: " + (Observer)fxmlLoader.getController());
            System.out.println("observer: " + observer);
            observer.setStage(stage);
            System.out.println("stage: " + stage);
            observer.setController(controller);

            observer.start();

            return root;
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

}
