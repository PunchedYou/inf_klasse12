package rekursion.wuerfelspiel;

public class Spiel {
    private Wuerfel w;

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

    public static void main(String[] args) {
        Wuerfel w = new Wuerfel(6);
        Spiel s = new Spiel(w);

        // s.rekurMaxFinden(10);

        System.out.println(s.rekurGibXErgebnisse(10));

    }

    public int rekurMaxFinden(int x) {
        int tmp = w.wuerfeln();
        if (x > 0) {
            int max = rekurMaxFinden(x - 1);
            if (tmp > max) {
                return tmp;
            } else {
                return max;
            }
        }
        return max;
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

    public int rekurGibXErgebnisse(int x) {
        if (x > 0) {
            t = rekurGibXErgebnisse(x - 1);
            s += Integer.toString(rekurGibXErgebnisse(x - 1)) + Integer.toString(w.wuerfeln());
            return Integer.parseInt(s);
        }
        return 0;
    }
}
