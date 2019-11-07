package controllers;

import models.UpdateHistory;

public class UpdateHistoryController {
    private ApplicationController applicationController;

    UpdateHistory updatehistory;

    public UpdateHistoryController(ApplicationController applicationController) {
        this.applicationController = applicationController;

        updatehistory = new UpdateHistory();

        loadHistory();
    }

    private void loadHistory() {
        updatehistory.updateList();
    }
}
