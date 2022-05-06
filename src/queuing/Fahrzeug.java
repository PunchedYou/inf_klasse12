package queuing;

public class Fahrzeug {
    private String model;
    private String farbe;
    private String kennzeichen;
    private int verkehrstgl;

    public Fahrzeug(String model, String farbe, String kennzeichen, int verkehrstgl) {
        this.model = model;
        this.farbe = farbe;
        this.kennzeichen = kennzeichen;
        this.verkehrstgl = verkehrstgl;
    }

    public String getModel() {
        return model;
    }

    public String getFarbe() {
        return farbe;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public int getVerkehrstgl() {
        return verkehrstgl;
    }
}