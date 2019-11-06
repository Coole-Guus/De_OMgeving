package controllers;

import javafx.scene.Node;
import javafx.stage.Stage;
import services.HttpClientBuilder;
import views.AccountLoginView;
import views.Observer;

import java.lang.reflect.InvocationTargetException;

public class ApplicationController {
    private Stage primaryStage;

    //store all controllers
    public AccountLoginController accountLoginController;
    public ArchiveController archiveController;
    public MainController mainController;
    public PopUpVoorbeeldController popUpVoorbeeldController;
    public FilterController filterController;
    public ToolsController toolsController;
    public ExperimentListController experimentListController;
    public HttpClientBuilder httpClientBuilder = new HttpClientBuilder ();
    public DetailsController detailsController;
    public UpdateHistoryController updateHistoryController;

    //etc

    public ApplicationController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("De OMgeving");

        //make all controllers
        accountLoginController = new AccountLoginController(this);
        archiveController = new ArchiveController(this);
        mainController = new MainController(this);
        popUpVoorbeeldController = new PopUpVoorbeeldController(this);
        toolsController = new ToolsController(this);
        filterController = new FilterController(this);
        experimentListController = new ExperimentListController(this);
        detailsController = new DetailsController(this);
        updateHistoryController = new UpdateHistoryController(this);

            //etc

        //load the first view
        loadView(AccountLoginView.class, accountLoginController);
    }

    //to load a new view
    public void loadView(Class<? extends Observer> view, Object controller) {
        try {
            view.getDeclaredConstructor(Stage.class, Object.class).newInstance(primaryStage, controller);
        } catch (InstantiationException e) {
            System.err.println("Cannot create instance for " + view.toString());
        } catch (IllegalAccessException e) {
            System.err.println("Cannot access " + view.toString());
        } catch (NoSuchMethodException e) {
            System.err.println("Constructor does not exist or has the wrong parameters in " + view.toString());
        } catch (InvocationTargetException e) {
            System.err.println("Exception thrown by " + view.toString());
            e.printStackTrace();
        }

    }

    public Node loadViewSegment(Class<? extends Observer> view, Object controller) {
        try {
            return view.getDeclaredConstructor(Stage.class, Object.class).newInstance(primaryStage, controller).getParent();
        } catch (InstantiationException e) {
            System.err.println("Cannot create instance for " + view.toString());
        } catch (IllegalAccessException e) {
            System.err.println("Cannot access " + view.toString());
        } catch (NoSuchMethodException e) {
            System.err.println("Constructor does not exist or has the wrong parameters in " + view.toString());
        } catch (InvocationTargetException e) {
            System.err.println("Exception thrown by " + view.toString());
            e.printStackTrace();
        }
        return null;
    }
}
