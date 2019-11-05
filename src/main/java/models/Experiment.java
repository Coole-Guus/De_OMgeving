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

    public Details details;

    public Experiment() {}

    public Experiment(int experimentId, String experiment_naam, String wijziging_datum, Fase fase, String experiment_leider) {
        this.experimentId = experimentId;
        this.experiment_naam = experiment_naam;
        this.wijziging_datum = wijziging_datum;
        this.fase = fase;
    }

    public int getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(int experimentId) {
        this.experimentId = experimentId;
    }

    public String getExperiment_naam() {
        return experiment_naam;
    }

    public void setExperiment_naam(String experiment_naam) {
        this.experiment_naam = experiment_naam;
    }

    public String getWijziging_datum() {
        return wijziging_datum;
    }

    public void setWijziging_datum(String wijziging_datum) {
        this.wijziging_datum = wijziging_datum;
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
}
