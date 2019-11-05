package controllers;

import models.Details;
import models.Experiment;

public class DetailsController {
    private ApplicationController applicationController;
    public DetailsController(ApplicationController applicationController) {
        this.applicationController = applicationController;
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
}
