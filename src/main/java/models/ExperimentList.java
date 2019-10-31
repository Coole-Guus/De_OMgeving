package models;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import views.Observer;

import java.util.ArrayList;
import java.util.Date;

public class ExperimentList implements Observable {

    private ArrayList<Observer> observers = new ArrayList<>();

    private ArrayList<Experiment> experimentList = new ArrayList<>();
    public ArrayList<VBox> experimentCards = new ArrayList<>();

    public void makeList() {
        experimentCards.clear();
        for(Experiment experiment : experimentList) {
            VBox card = new VBox();
            card.setId(Integer.toString(experiment.getExperimentId()));
            card.getStyleClass().add("experiment-card");

            switch (experiment.getColor()) {
                case "GREEN":
                    card.getStyleClass().add("experiment-card-green");
                    break;
                case "YELLOW":
                    card.getStyleClass().add("experiment-card-yellow");
                    break;
                case "RED":
                    card.getStyleClass().add("experiment-card-red");
                    break;
            }

            Label nameLabel = new Label();
            nameLabel.setText(experiment.getExperiment_naam());
            card.getChildren().add(nameLabel);

            Label leaderLabel = new Label();
            leaderLabel.setText("Leider: " + experiment.getExperiment_leider());
            card.getChildren().add(leaderLabel);

//            Label dateLabel = new Label();
//            dateLabel.setText("Laatst gewijzigd: " + experiment.getWijziging_datum());
//            pane.getChildren().add(dateLabel);

            Label statusLabel = new Label();
            statusLabel.setText("Status: " + experiment.getStatus());
            card.getChildren().add(statusLabel);

            experimentCards.add(card);
        }
    }

    public void updateList() {
        fillList();
        makeList();
        notifyObservers();
    }

    public void fillList() {
        //replace with database baloney
        for (int i = 0; i < 15; i++) {
            Experiment experiment = new Experiment(i, "Experiment_naam_" + i, new Date(2323223232L), Experiment.Fase.IDEE, "Henk van Damme", Experiment.Color.GREEN);
            experimentList.add(experiment);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}