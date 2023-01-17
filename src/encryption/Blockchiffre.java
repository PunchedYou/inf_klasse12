package encryption;

public class Blockchiffre {
    public Blockchiffre() {

    }

    public static void main(String[] args) {
        Blockchiffre bc = new Blockchiffre();
        bc.wortEntschluesseln(bc.wortVerschluesseln("Affenalarm"));
    }

    public String wortVerschluesseln(String s) {
        System.out.println("Verschlüsseln:");
        String bin = toBinary(s);

        for (int i = 0; i < 3; i++) {
            bin = oneTimePad(bin, "11110000");
            bin = transposition(bin, "3142");

            bin = oneTimePad(bin, "10101110");
            bin = transposition(bin, "4312");
        }

        String asc = toASCII(bin);
        System.out.println(s + " => " + asc);
        // System.out.println("Klartext: " + toBinary(s) + "\nChiffre: " + bin);

        return asc;
    }

    public String wortEntschluesseln(String s) {
        System.out.println("Entschlüsseln:");
        String bin = toBinary(s);

        for (int i = 0; i < 3; i++) {
            bin = transposition(bin, "3421");
            bin = oneTimePad(bin, "10101110");

            bin = transposition(bin, "2413");
            bin = oneTimePad(bin, "11110000");
        }

        String asc = toASCII(bin);
        System.out.println(s + " => " + asc);
        // System.out.println("Chiffre: " + toBinary(s) + "\nKlartext: " + bin);

        return asc;
    }

    private String formatBinary(char c) {
        String s = Integer.toBinaryString(c);
        while (s.length() < 8) {
            s = "0" + s;
        }
        return s;
    }

    private String toBinary(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            r += formatBinary(s.charAt(i));
        }
        return r;
    }

    private String toASCII(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i += 8) {
            r += (char) Integer.parseInt(s.substring(i, i + 8), 2);
        }
        return r;
    }

    private String transposition(String s, String p) {
        String r = "";
        for (int i = 0; i < s.length(); i += 4) {
            for (int j = 0; j < 4; j++) {
                r += s.charAt(i + (Integer.parseInt(String.valueOf(p.charAt(j))) - 1));
            }
        }
        return r;
    }

    private String oneTimePad(String s, String p) {
        String r = "";
        for (int i = 0; i < s.length(); i += 8) {
            for (int j = 0; j < 8; j++) {
                r += (s.charAt(i + j) == p.charAt(j)) ? 0 : 1;
            }
        }
        return r;
    }
}