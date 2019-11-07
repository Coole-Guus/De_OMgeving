package models;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import views.Observer;
import views.ViewUtilities;

import java.util.ArrayList;
import java.util.Date;

public class ExperimentList implements Observable {

    private ArrayList<Observer> observers = new ArrayList<>();

    private ArrayList<Experiment> experimentList = new ArrayList<>();
    public ArrayList<GridPane> experimentCards = new ArrayList<>();

    public void makeList() {
        experimentCards.clear();
        for(Experiment experiment : experimentList) {
            GridPane card = new GridPane();
            card.setId(Integer.toString(experiment.getExperimentId()));
            card.getStyleClass().add("experiment-card");
            card.setMinWidth(ViewUtilities.screenWidth/5);
            card.setMinHeight(ViewUtilities.screenHeight/5);

            switch (experiment.getColor()) {
                case "GREEN":
                    card.getStyleClass().add("experiment-card-green");
                    break;
                case "ORANGE":
                    card.getStyleClass().add("experiment-card-yellow");
                    break;
                case "RED":
                    card.getStyleClass().add("experiment-card-red");
                    break;
            }

            Label nameLabel = new Label();
            nameLabel.setText(experiment.getExperiment_naam());
            nameLabel.getStyleClass().add("title");
            card.add(nameLabel, 0, 0, 2, 1);

            card.add(new Label("Experiment-leader:"), 0, 1);
            card.add(new Label(experiment.getExperiment_leider()), 1, 1);

            card.add(new Label("Laatst gewijzigd: "), 0, 2);
            card.add(new Label(experiment.getWijziging_datum()), 1, 2);

            card.add(new Label("Status: "), 0, 3);
            card.add(new Label(experiment.getStatus()), 1, 3);

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
        for (int i = 1; i < 75; i++) {
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