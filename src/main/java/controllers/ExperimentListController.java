package controllers;

import models.Experiment;
import models.ExperimentList;
import services.HttpClientBuilder;

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


    public void updateList(String argument) {
        experimentList.clearList();

        HttpClientBuilder get = new HttpClientBuilder();
        Experiment[] experimenten = (Experiment[]) get.httpGet(Experiment[].class, "experimenten" + argument);

        for (Experiment experiment : experimenten) {
            experimentList.addToList(experiment);
        }
        experimentList.prepareList();

    }
}
