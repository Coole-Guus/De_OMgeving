package models;

import views.DetailsView;
import views.Observer;

import java.util.ArrayList;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Date;
public class Experiment implements Observable {

    private int experimentID;

    private String experiment_naam;

    private Date wijziging_datum;

    private Fase fase;

    public ArrayList<Observer> observers = new ArrayList<>();

    private String status;

    private Color color;

    public enum Color {
        GREEN,
        YELLOW,
        RED
    }

    public enum Fase
    {
        LAB_IN,
        LAB_UIT,
        IDEE,
        ERROR

    }
    private String experiment_leider;

    public Details details;

    public Experiment() {}

    public Experiment(int experimentId, String experiment_naam, Date wijziging_datum, Fase fase, String experiment_leider, Experiment.Color color) {
        this.experimentID = experimentId;
        this.experiment_naam = experiment_naam;
        this.wijziging_datum = wijziging_datum;
        this.experiment_leider = experiment_leider;
        this.color = color;
        try {
            this.fase = fase;
        }catch (IllegalArgumentException e) {
            this.fase = Fase.ERROR;
        }

    }

    public String getExperiment_naam() {
        return experiment_naam;
    }

    public void setExperiment_naam(String experiment_naam) {
        this.experiment_naam = experiment_naam;
    }

    public int getExperimentId() {
        return experimentID;
    }

    public String getWijziging_datum() {
        return wijziging_datum.toString();
    }

    public String getStatus() {
        return fase.toString();
    }

    public String getColor() {
        return Color.values()[(int) Math.floor(Math.random() * Color.values().length)].toString();
    }
    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public String getExperiment_leider() {
        return experiment_leider;
    }

    public void setExperiment_leider(String experiment_leider) {
        this.experiment_leider = experiment_leider;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("notifying observers...");
        for (Observer observer : observers) {
            System.out.println("notifying: " + observer);
            System.out.println(observer);
            observer.update(this);
        }
    }
}
