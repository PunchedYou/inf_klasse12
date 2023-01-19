package encryption;

public class Blockchiffre {
    public Blockchiffre() {

    }

    public static void main(String[] args) {
        Blockchiffre bc = new Blockchiffre();
        // bc.wortEntschluesseln(bc.wortVerschluesseln("Affenalarm"));
        bc.passEntschluesseln(bc.passVerschluesseln("icbineintesttext", "ichtestedich"), "ichtestedich");
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
            bin = transposition(bin, reverseTransp("4312"));
            bin = oneTimePad(bin, "10101110");

            bin = transposition(bin, reverseTransp("3142"));
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

    private String reverseTransp(String p) {
        // 3142 > 2413
        // 4312 > 3421
        String r = "";
        for (int i = 1; i <= p.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (i == Integer.parseInt(String.valueOf(p.charAt(j)))) {
                    r += (j + 1);
                }
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

    /**
     * Eine Methode die einen Text mit Hilfe einer von einem Passwort generierte
     * Blockchiffre verschlüsselt
     * 
     * @param s    Der zu verschlüsselnde Text
     * @param pass Das Passwort mit dem die Verschlüsselung durchgeführt werden soll
     * @return Der verschlüsselte Text
     */
    public String passVerschluesseln(String s, String pass) {
        if (pass.length() < 8) {
            return "ERROR: Passwort muss mind. 8 Zeichen enthalten";
        }

        System.out.println("Verschlüsseln:");
        String bin = toBinary(s);

        int rounds = generateRounds(pass);

        for (int i = 0; i < rounds; i++) {
            bin = oneTimePad(bin, generateOTP1(pass));
            bin = transposition(bin, generateTransp(pass, false));

            bin = oneTimePad(bin, generateOTP2(pass));
            bin = transposition(bin, generateTransp(pass, true));
        }

        String asc = toASCII(bin);
        System.out.println(s + " => " + asc);
        // System.out.println("Klartext: " + toBinary(s) + "\nChiffre: " + bin);

        return asc;
    }

    /**
     * Eine Methode die die Verschlüsselung eines Textes mit Hilfe des Passwortes
     * umkehrt
     * 
     * @param s    Der entschlüsselnde Text
     * @param pass Das Passwort mit dem die Verschlüsselung durchgeführt wurde
     * @return Der entschlüsselte Text
     */
    public String passEntschluesseln(String s, String pass) {
        if (pass.length() < 8) {
            return "ERROR: Das Passwort muss mind. 8 Zeichen enthalten!";
        }

        System.out.println("Entschlüsseln:");
        String bin = toBinary(s);

        int rounds = generateRounds(pass);

        for (int i = 0; i < rounds; i++) {
            bin = transposition(bin, reverseTransp(generateTransp(pass, true)));
            bin = oneTimePad(bin, generateOTP2(pass));

            bin = transposition(bin, reverseTransp(generateTransp(pass, false)));
            bin = oneTimePad(bin, generateOTP1(pass));
        }

        String asc = toASCII(bin);
        System.out.println(s + " => " + asc);
        // System.out.println("Chiffre: " + toBinary(s) + "\nKlartext: " + bin);

        return asc;
    }

    private int generateRounds(String pass) {
        pass = toBinary(pass);
        int rounds = 0;
        for (int i = 0; i < pass.length(); i += 4) {
            rounds += Integer.valueOf("" + pass.charAt(i));
        }
        return rounds;
    }

    private String generateTransp(String pass, boolean reverse) {
        if (reverse) {
            StringBuilder sb = new StringBuilder(pass);
            pass = sb.reverse().toString();
        }

        String transp = "";

        for (int i = 0; i < pass.length(); i++) {
            String hash = String.valueOf((pass.charAt(i) + "").hashCode() % 4 + 1);
            if (!transp.contains(hash)) {
                transp += hash;
            } else if (transp.length() == 4) {
                break;
            }
        }

        if (transp.length() < 4) {
            for (int i = 1; i <= 4; i++) {
                if (!transp.contains(String.valueOf(i))) {
                    transp += i;
                }
            }
        }

        return transp;
    }

    private String generateOTP1(String pass) {
        pass = toBinary(pass);
        int parts = (pass.length() - 5) / 8;
        String otpcode = "";

        for (int i = 5; i < pass.length(); i += parts) {
            otpcode += pass.charAt(i);

            if (otpcode.length() == 8) {
                break;
            }
        }

        return otpcode;
    }

    private String generateOTP2(String pass) {
        pass = toBinary(pass);
        int parts = (pass.length() - 7) / 8;
        String otpcode = "";

        for (int i = 7; i < pass.length(); i += parts) {
            otpcode += pass.charAt(i);

            if (otpcode.length() == 8) {
                break;
            }
        }

        return otpcode;
    }
}