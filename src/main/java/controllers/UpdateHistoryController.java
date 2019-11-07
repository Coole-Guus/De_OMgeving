package controllers;

import models.Details;
import models.UpdateHistory;
import models.UpdateMessage;
import services.HttpClientBuilder;
import views.UpdateHistoryView;

import java.util.ArrayList;

public class UpdateHistoryController {
    private ApplicationController applicationController;

    UpdateHistory updatehistory;

    public UpdateHistoryController(ApplicationController applicationController) {
        this.applicationController = applicationController;

        updatehistory = new UpdateHistory();

        loadHistory();
    }

    public void showUpdateHistory(String projectId) {
        HttpClientBuilder requester = new HttpClientBuilder();
        UpdateMessage[] updateHistory = (UpdateMessage[]) requester.httpGet(UpdateMessage[].class, "messages", String.valueOf(projectId));

        for(UpdateMessage updateMessage : updateHistory)
            updatehistory.updateList.add(updateMessage);
        updatehistory.notifyObservers();
    }

    private void loadHistory() {
        updatehistory.updateList();
    }

    public void registerObserver(UpdateHistoryView updateHistoryView) {
        this.updatehistory.registerObserver(updateHistoryView);
    }
}
