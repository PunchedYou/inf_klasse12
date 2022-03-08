public class Tauschen {
    public String tauscheBuchstaben(String input) {
        String s = "";

        s += input.charAt(input.length() - 1);

        for (int i = 1; i < input.length() - 1; i++) {
            s += input.charAt(i);
        }

        s += input.charAt(0);

        return s;
    }

    public String abwechselndTauschen(String input) {
        String s = "";

        for (int i = 0; i < input.length() - 1; i += 2) {
            s += input.charAt(i + 1);
            s += input.charAt(i);
        }

        if (input.length() % 2 == 1) {
            s += input.charAt(input.length() - 1);
        }

        return s;
    }

    public String teilerTausch(String input) {
        if (input.length() % 4 != 0) {
            return "ERROR: Wort ist nicht durch 4 teilbar.";
        }

        String s = "";

        int x = (input.length() - 1) / 4;

        for (int i = 0; i <= x; i++) {
            s += input.charAt(x);
        }
        for (int i = 0; i <= x; i++) {
            s += input.charAt(x * 4);
        }
        for (int i = 0; i <= x; i++) {
            s += input.charAt(x * 2);
        }
        for (int i = 0; i <= x; i++) {
            s += input.charAt(x * 3);
        }

        return s;
    }

    public String viererTausch(String input) {
        String s = "";

        for (int i = 0; i < input.length() - 1; i += 4) {
            s += input.charAt(i);
            s += input.charAt(i + 3);
            s += input.charAt(i + 1);
            s += input.charAt(i + 2);
        }

        if (input.length() % 4 != 0) {
            s += input.charAt(input.length() - 1);
            s += input.charAt(input.length() - 2);
            s += input.charAt(input.length() - 3);
        }

        return s;
    }
}
