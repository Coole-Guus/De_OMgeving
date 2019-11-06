package controllers;

import models.ExperimentList;
import views.ExperimentListView;
import views.Observer;

public class ExperimentListController  {
    public ApplicationController applicationController;

    public ExperimentList experimentList = new ExperimentList();

    public ExperimentListController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void registerObserver(Observer observer) {
        experimentList.registerObserver(observer);
    }
}
