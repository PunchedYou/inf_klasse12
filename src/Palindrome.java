// Seite 64; Aufgabe 4c; 07.05.22

import dstrukturen.Stack;

public class Palindrome {

    public Palindrome(String palindrom) {
        System.out.println(textUeberpruefen(palindrom));
        System.out.println(stackUeberpruefen(palindrom));
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome("bei liese sei lieb");
    }

    public boolean textUeberpruefen(String s) {
        String text = s;
        String umgekehrt = "";
        text = text.replaceAll("\\s+", "");
        text = text.toLowerCase();

        // text rückwärts
        for (int i = text.length() - 1; i >= 0; --i) {
            umgekehrt += text.charAt(i);
        }

        // palindrom test
        return text.equals(umgekehrt);
    }

    public boolean stackUeberpruefen(String s) {
        s = s.toLowerCase();
        Stack<Character> text = new Stack<>();
        Stack<Character> umgekehrt = new Stack<>();

        // stack text belegen
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                text.push(s.charAt(i));
            }
        }

        // stack umgekehrt belegen
        for (int i = (s.length() - 1); i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                umgekehrt.push(s.charAt(i));
            }
        }

        // palindrom test
        while (!text.isEmpty()) {
            if (text.top() != umgekehrt.top()) {
                return false;
            }
            text.pop();
            umgekehrt.pop();
        }

        return true;

    }
}
