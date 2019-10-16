package controllers;

import javafx.stage.Stage;
import views.AccountLoginView;
import views.Observer;

import java.lang.reflect.InvocationTargetException;

public class ApplicationController {
    private Stage primaryStage;

    //store all controllers
    public AccountLoginController accountLoginController;
    public ArchiveController archiveController;
    public MainController mainController;
        //etc

    public ApplicationController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("De OMgeving");

        //make all controllers
        accountLoginController = new AccountLoginController(this);
        archiveController = new ArchiveController(this);
        mainController = new MainController(this);
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
}
