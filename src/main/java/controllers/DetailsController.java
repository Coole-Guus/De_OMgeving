package controllers;

import com.sun.javaws.exceptions.InvalidArgumentException;
import models.Account;
import models.Details;
import models.Experiment;
import models.Message;
import services.HttpClientBuilder;
import views.DetailsView;
import views.Observer;

import java.util.Date;

public class DetailsController {

    /**
     * @author Stefan, Leander
     *
     *
     */
    public ApplicationController applicationController;

    private Experiment detailedExperiment = new Experiment();


    public DetailsController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void showDetails(String projectId) {
        HttpClientBuilder requester = new HttpClientBuilder();
        try {
            Details details = (Details) requester.httpGet(Details.class, "experimentDetails", String.valueOf(projectId));

            Experiment detailedExperiment = (Experiment) requester.httpGet(Experiment.class, "experimenten", String.valueOf(projectId));



            detailedExperiment.details = details;

            detailedExperiment.observers = this.detailedExperiment.observers;

            this.detailedExperiment = detailedExperiment;

        this.detailedExperiment.notifyObservers();
        this.applicationController.updateHistoryController.showUpdateHistory(projectId);
        } catch (Exception e) {

        }

    }

    public void registerObserver(Observer observer) {
        detailedExperiment.registerObserver(observer);
    }

    public void clickedUpdate(
        int experiment_id,
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
        boolean archived,
        String archivedType
    ) {
        Experiment experiment = new Experiment();
        experiment.setExperiment_naam(experiment_naam);

        try {
            experiment.setFase(Experiment.Fase.valueOf(experiment_fase));
        }catch(IllegalArgumentException e){}

        experiment.setExperiment_leider(experiment_leider);
        experiment.setExperimentID(experiment_id);
        experiment.setWijziging_datum(new Date());
        experiment.setColor(Experiment.Color.valueOf(details_status_kleur));

        Details experimentDetails = new Details();
        experimentDetails.setArchief(archived);
        experimentDetails.setArchiefType(archivedType);
        experimentDetails.setExperimentId(experiment_id);
        experimentDetails.setNetwerk(details_netwerk);
        experimentDetails.setStatus(details_status);
        experimentDetails.setStatusKleur(details_status_kleur);
        experimentDetails.setKostenInovatie(details_kosten_inovatie);
        experimentDetails.setKostenAnders(details_kosten_anders);
        experimentDetails.setDoorlooptijd(details_doorlooptijd);
        experimentDetails.setBeschrijving(details_beschrijving);
        experimentDetails.setVoortgang(details_voortgang);

        experiment.setDetails(experimentDetails);
        HttpClientBuilder requester = new HttpClientBuilder();

        requester.httpPostAdd(experiment, "experimenten", "update", String.valueOf(experiment.getExperimentId()));

        requester.httpPostAdd(experimentDetails, "experimentDetails", "update", String.valueOf(experiment.getExperimentId()));
    }

    public void postMessage(String message, String experimentid){
        applicationController.httpClientBuilder.httpGet ("accounts", "users", "accountId", "accountRol");
        for(Account account : applicationController.httpClientBuilder.getAccounts()) {
            if(account.getAccountNaam().contains(applicationController.accountLoginController.getUsername())) {
                Message newMessage = new Message();
                newMessage.setAccountId(Integer.parseInt(String.valueOf(account.getAccountId())));
                newMessage.setBericht(message);
                newMessage.setExperimentId(Integer.parseInt(experimentid));

                applicationController.httpClientBuilder.httpPostAdd(newMessage, "messages", "addMessage");
                this.applicationController.updateHistoryController.showUpdateHistory(String.valueOf(detailedExperiment.getExperimentId()));
            }
        }

    }
}
