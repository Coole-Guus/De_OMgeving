package controllers;

import com.sun.javaws.exceptions.InvalidArgumentException;
import models.Details;
import models.Experiment;
import services.HttpClientBuilder;
import views.DetailsView;
import views.Observer;

public class DetailsController {
    public ApplicationController applicationController;

    private Experiment detailedExperiment = new Experiment();


    public DetailsController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void showDetails(String projectId) {
        HttpClientBuilder requester = new HttpClientBuilder();
        Details details = (Details) requester.httpGet(Details.class, "experimentDetails", String.valueOf(projectId));

        Experiment detailedExperiment = new Experiment();

        detailedExperiment.details = details;

        detailedExperiment.observers = this.detailedExperiment.observers;

        this.detailedExperiment = detailedExperiment;

        this.detailedExperiment.notifyObservers();
    }

    public void registerObserver(Observer observer) {
        detailedExperiment.registerObserver(observer);
    }

    public void clickedUpdate(
        String experiment_naam,
        String experiment_fase,
        String experiment_leider,
        String details_netwerk,
        String details_status,
        String details_status_kleur,
        String details_kosten_inovatie,
        String details_kosten_anders,
        String details_doorlooptijd,
        String details_beschrijving,
        String details_voortgang,
        String message
    ) {
        Experiment experiment = new Experiment();
        experiment.setExperiment_naam(experiment_naam);

        try {
            experiment.setFase(Experiment.Fase.valueOf(experiment_fase));
        }catch(IllegalArgumentException e){}

        experiment.setExperiment_leider(experiment_leider);

        Details experimentDetails = new Details();
        experimentDetails.setNetwerk(details_netwerk);
        experimentDetails.setStatus(details_status);
        experimentDetails.setStatusKleur(details_status_kleur);
        experimentDetails.setKostenInovatie(details_kosten_inovatie);
        experimentDetails.setKostenAnders(details_kosten_anders);
        experimentDetails.setDoorlooptijd(details_doorlooptijd);
        experimentDetails.setBeschrijving(details_beschrijving);
        experimentDetails.setVoortgang(details_voortgang);

        experiment.setDetails(experimentDetails);
    }

    public void postMessage(String message){
//        applicationController.httpClientBuilder.httpGet("experimenten", message, );
    }


    public void loadDetails(DetailsView detailsView) {

//        final int projectId = 1;
//        HttpClientBuilder requester = new HttpClientBuilder();
//        Details details = (Details) requester.httpGet(Details.class, "experimentDetails", String.valueOf(projectId));
//
//        detailedExperiment = new Experiment();
//
//        detailedExperiment.details = details;
//
//        registerObserver((Observer) detailsView);
//        detailedExperiment.registerObserver(detailsView);
//
//        detailedExperiment.notifyObservers();
    }
}
