package models;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Date;

public class Experiment {

    private int experimentId;

    private String experiment_naam;

    private Date wijziging_datum;

    private Fase fase;

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

    public Experiment(int experimentId, String experiment_naam, Date wijziging_datum, Fase fase, String experiment_leider, Experiment.Color color) {
        this.experimentId = experimentId;
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

    public int getExperimentId() {
        return experimentId;
    }

    public String getExperiment_leider() {
        return experiment_leider;
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
}
