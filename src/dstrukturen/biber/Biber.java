package dstrukturen.biber;

public class Biber {
    int groesse;

    // 0 für klein; 1 für groß
    public Biber(int groesse) {
        if (groesse == 0 || groesse == 1) {
            this.groesse = groesse;
        } else {
            System.out.println("Keine valide Größe!");
            this.groesse = 0;
        }
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int n) {
        if (n == 0 || n == 1) {
            groesse = n;
        } else {
            System.out.println("Keine valide Größe ein!");
        }

    }
}
