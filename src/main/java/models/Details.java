package models;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class Details {

    @Expose
    private int experimentId;

    @Expose
    private String netwerk;

    @Expose
    private String status;

    @Expose
    private String statusKleur;

    @Expose
    private String kostenInovatie;

    @Expose
    private String kostenAnders;

    @Expose
    private String doorlooptijd;

    @Expose
    private String beschrijving;

    @Expose
    private String voortgang;

    @Expose
    private boolean archief = false;

    @Expose
    private String archiefType;

    private String name;

    public int getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(int experimentId) {
        this.experimentId = experimentId;
    }

    public String getNetwerk() {
        return netwerk;
    }

    public void setNetwerk(String netwerk) {
        this.netwerk = netwerk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusKleur() {
        return statusKleur;
    }

    public void setStatusKleur(String statusKleur) {
        this.statusKleur = statusKleur;
    }

    public String getKostenInovatie() {
        return kostenInovatie;
    }

    public void setKostenInovatie(String kostenInovatie) {
        this.kostenInovatie = kostenInovatie;
    }

    public String getKostenAnders() {
        return kostenAnders;
    }

    public void setKostenAnders(String kostenAnders) {
        this.kostenAnders = kostenAnders;
    }

    public String getDoorlooptijd() {
        return doorlooptijd;
    }

    public void setDoorlooptijd(String doorlooptijd) {
        this.doorlooptijd = doorlooptijd;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getVoortgang() {
        return voortgang;
    }

    public void setVoortgang(String voortgang) {
        this.voortgang = voortgang;
    }

    public boolean isArchief() {
        return archief;
    }

    public void setArchief(boolean archief) {
        this.archief = archief;
    }

    public String getArchiefType() {
        return archiefType;
    }

    public void setArchiefType(String archiefType) {
        this.archiefType = archiefType;
    }
    public Details(int experiment_ID, String netwerk, String status,String status_kleur,String kosten_inovatie, String kosten_anders,String doorlooptijd,String beschrijving,String voortgang,boolean archief,String archief_type){

    }
}
