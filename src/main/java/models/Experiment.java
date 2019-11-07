package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import views.DetailsView;
import views.Observer;

import java.util.ArrayList;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Date;
public class Experiment implements Observable {

    @Expose
    @SerializedName("experimentId")
    private int experimentID;

    @Expose
    private String experiment_naam;

    @Expose
    private Date wijziging_datum;

    @Expose
    private Fase fase;

    public ArrayList<Observer> observers = new ArrayList<>();

    private String status;

    @Expose
    private Color color;

    public void setExperimentID(int experiment_id) {
        this.experimentID = experiment_id;
    }

    public void setWijziging_datum(Date date) {
        this.wijziging_datum = date;
    }

    public void setDetails(Details experimentDetails) {
        this.details = experimentDetails;
    }


    public enum Color {
        @SerializedName("Groen") GREEN,
        @SerializedName("Oranje") ORANGE,
        @SerializedName("Rood") RED
    }

    public enum Fase
    {
        @SerializedName("Lab in") LAB_IN,
        @SerializedName("Lab uit") LAB_UIT,
        @SerializedName("Idee") IDEE,
        ERROR

    }
    @Expose
    private String experiment_leider;

    public Details details;

    public Experiment() {}

    public Experiment(int experimentId, String experiment_naam, Date wijziging_datum, Fase fase, String experiment_leider, Color color) {
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
    public String getKleur(){
        return color.toString();
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