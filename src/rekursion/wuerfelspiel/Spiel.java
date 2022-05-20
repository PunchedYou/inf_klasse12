package rekursion.wuerfelspiel;

public class Spiel {
    Wuerfel w;

    public Spiel(Wuerfel w) {
        this.w = w;
    }

    public Wuerfel getWuerfel() {
        return w;
    }

    public int addiereX(int x) {
        int e = 0;
        for (int i = 0; i < x; i++) {
            e += w.wuerfeln();
        }
        return e;
    }

    public int rekurAddiereX(int x) {
        if (x > 0) {
            return w.wuerfeln() + rekurAddiereX(x - 1);
        }
        return 0;
    }

    public int maxFinden(int x) {
        int e = 0;
        for (int i = 0; i < x; i++) {
            int t = w.wuerfeln();
            if (t > e) {
                e = t;
            }
        }
        return e;
    }

    // TODO
    public int rekurMaxFinden(int x) {
        int e = 0;
        int t = w.wuerfeln();
        if (x > 0) {
            if (t > e) {

            }
        }
        return e;
    }

    public int gibXErgebnisse(int x) {
        String s = "";
        for (int i = 0; i < x; i++) {
            s += Integer.toString(w.wuerfeln());
        }
        int e = 0;
        e = Integer.parseInt(s);
        return e;
    }

    // TODO
    public int rekurGibXErgebnisse(int x) {
        int e = 0;

        return e;
    }
}
