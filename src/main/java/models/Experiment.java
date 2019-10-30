package models;

public class Experiment {

    private int experimentId;

    private String experiment_naam;

    private String wijziging_datum;

    private Fase fase;

    public enum Fase
    {
        LAB_IN,
        LAB_UIT,
        IDEE
    }

    private String experiment_leider;

    public Experiment(int experimentId, String experiment_naam, String wijziging_datum, Fase fase, String experiment_leider) {
        this.experimentId = experimentId;
        this.experiment_naam = experiment_naam;
        this.wijziging_datum = wijziging_datum;
        this.fase = fase;
    }
}
