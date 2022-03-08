public class Schaltjahre {

    private boolean abfrageSchaltjahr(int x) {
        if ((x % 4 == 0) && (x % 100 != 0)) {
            return true;
        } else if (x % 4 == 0 && x % 100 == 0 && x % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void ausgabeSchaltjahr(int x) {
        if (abfrageSchaltjahr(x)) {
            System.out.println(x + " ist ein Schaljahr.");
        } else {
            System.out.println(x + " ist kein Schaltjahr");
        }
    }

    public void alleSchaltjahre() {
        for (int i = 0; i < 2021; i++) {
            if (i % 100 == 0) {
                System.out.println();
            }

            if (abfrageSchaltjahr(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
