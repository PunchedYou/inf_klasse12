// Seite 64; Aufgabe 4c; 07.05.22

public class Palindrome {

    public Palindrome() {
        textUeberpruefen("bei liese sei lieb");
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
    }

    public void textUeberpruefen(String s) {
        String text = s;
        String umgekehrt = "";
        text = text.replaceAll("\\s+", "");
        text = text.toLowerCase();

        for (int i = (text.length() - 1); i >= 0; --i) {
            umgekehrt += text.charAt(i);
        }

        if (text.equals(umgekehrt)) {
            System.out.println("\"" + s + "\" ist ein Palindrom.");
        } else {
            System.out.println("\"" + s + "\" ist kein Palindrom.");
        }
    }
}
