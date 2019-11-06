package models;

import java.sql.Timestamp;

public class Experiment {

    private int experimentID;

    private String experiment_naam;

    private Timestamp wijziging_datum;

    private Fase fase;

    public enum Fase
    {
        LAB_IN,
        LAB_UIT,
        IDEE
    }

    private String experiment_leider;

    private String status_kleur = "Groen";

    public Experiment(int experimentId, String experiment_naam, Timestamp wijziging_datum, Fase fase, String experiment_leider) {
        this.experimentID = experimentId;
        this.experiment_naam = experiment_naam;
        this.wijziging_datum = wijziging_datum;
        this.fase = fase;
    }
}
