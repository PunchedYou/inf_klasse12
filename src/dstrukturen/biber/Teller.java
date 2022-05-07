package dstrukturen.biber;

public class Teller {
    int tiefe;

    // 0 für flach; 1 für tief
    public Teller(int tiefe) {
        if (tiefe == 0 || tiefe == 1) {
            this.tiefe = tiefe;
        } else {
            System.out.println("Keine valide Größe!");
            this.tiefe = 0;
        }
    }

    public int getTiefe() {
        return tiefe;
    }

    public void setTiefe(int n) {
        if (n == 0 || n == 1) {
            tiefe = n;
        } else {
            System.out.println("Keine valide Größe ein!");
        }

    }
}
