package encryption;

public class Blockchiffre {
    public Blockchiffre() {

    }

    public static void main(String[] args) {
        Blockchiffre bc = new Blockchiffre();
        bc.wortEntschluesseln(bc.wortVerschluesseln("a"));
    }

    public String wortVerschluesseln(String s) {
        System.out.println("Verschlüsseln: (" + s + ")");
        s = toBinary(s);

        s = oneTimePad(s, "11110000");
        s = transposition(s, "3142");

        s = oneTimePad(s, "10101110");
        s = transposition(s, "4312");

        System.out.print(s + " => ");

        String d = "";
        for (int i = 0; i < s.length() / 8; i++) {
            d += (char) Integer.parseInt(s.substring(i, i + 8), 2);
        }
        System.out.println(d);
        s = d;

        return s;
    }

    public String wortEntschluesseln(String s) {
        System.out.println("Entschlüsseln: (" + s + ")");
        String b = toBinary(s);

        b = transposition(b, "3421");
        b = oneTimePad(b, "10101110");

        b = transposition(b, "2413");
        b = oneTimePad(b, "11110000");

        String d = "";
        for (int i = 0; i < b.length() / 8; i++) {
            d += (char) Integer.parseInt(b.substring(i, i + 8), 2);
        }

        System.out.println(toBinary(s) + " => " + b);
        System.out.println(s + " => " + d);

        return d;
    }

    public String binaryASCII(char c) {
        String s = Integer.toBinaryString(c);
        while (s.length() < 8) {
            s = "0" + s;
        }
        return s;
    }

    public String toBinary(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            r += binaryASCII(s.charAt(i));
        }
        return r;
    }

    public String transposition(String s, String p) {
        String r = "";
        for (int i = 0; i < s.length() / 4; i++) {
            for (int j = 0; j < 4; j++) {
                r += s.charAt((4 * i) + (Integer.parseInt(String.valueOf(p.charAt(j))) - 1));
            }
        }
        return r;
    }

    public String oneTimePad(String s, String p) {
        String r = "";
        for (int i = 0; i < s.length() / 8; i++) {
            for (int j = 0; j < 8; j++) {
                r += (s.charAt(i + j) == p.charAt(j)) ? 0 : 1;
            }
        }
        return r;
    }

}