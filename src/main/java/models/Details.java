package models;

public class Details {

    private int experimentId;

    private String netwerk;

    private String status;

    private String statusKleur;

    private String kostenInovatie;

    private String kostenAnders;

    private String doorlooptijd;

    private String beschrijving;

    private String voortgang;

    private boolean archief = false;

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
}
