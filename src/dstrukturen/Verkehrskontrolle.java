package dstrukturen;

public class Verkehrskontrolle {
    Queue<Fahrzeug> schlange = new Queue<Fahrzeug>();
    private int kontrolliert;
    private int mangelautos;

    public Verkehrskontrolle() {

    }

    public void herauswinken(Fahrzeug f) {
        // Ein Fahrzeug wird in die Warteschlange gewunken
        schlange.enqueue(f);
    }

    public boolean fahrzeugUeberpruefen() {
        // Wenn ein Auto in der Warteschlange ist, wird es aus seine
        // Verkehrstauglichkeit überprüft
        if (!schlange.isEmpty()) {
            kontrolliert += 1;
            if ((schlange.front()).getVerkehrstgl() < 10) {
                mangelautos += 1;
                schlange.dequeue();
                return true;
            }
        }
        return false;
    }

    public void kolonneAufloesen() {
        // Alle Autos werden aus der Warteschlange entfernt
        while (!schlange.isEmpty()) {
            schlange.dequeue();
        }
    }
}
