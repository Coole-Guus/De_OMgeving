package controllers;

import views.AccountLoginView;
import views.MainView;

public class MainController {

    /**
     * @author Stefan, Leander
     *
     *
     */
    public ApplicationController applicationController;

    public MainController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void exit() {
        applicationController.loadView(AccountLoginView.class, applicationController.accountLoginController);
    }


    public void filter(String filtertype){
        applicationController.httpClientBuilder.httpGet("experimenten", filtertype);
        applicationController.experimentListController.updateList("/" + filtertype);

    }

    public void reloadView() {
        applicationController.loadView(MainView.class, applicationController.mainController);
    }
}
