package controllers;

import models.Details;
import models.Experiment;
import services.HttpClientBuilder;
import views.DetailsView;

public class DetailsController {
    private ApplicationController applicationController;

    private Experiment detailedExperiment;


    public DetailsController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void showDetails(String id) {
        System.out.println("load details of " + id);
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
        String details_voortgang
    ) {
        Experiment experiment = new Experiment();
        experiment.setExperiment_naam(experiment_naam);
        experiment.setFase(Experiment.Fase.valueOf(experiment_fase));
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
    }


    public void loadDetails(DetailsView detailsView) {

        final int projectId = 1;
        HttpClientBuilder requester = new HttpClientBuilder();
        Details details = (Details) requester.httpGet(Details.class, "experimentDetails", String.valueOf(projectId));

        detailedExperiment = new Experiment();

        detailedExperiment.details = details;

        detailedExperiment.registerObserver(detailsView);

        detailedExperiment.notifyObservers();
    }
}
