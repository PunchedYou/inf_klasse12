package dstrukturen.muenzen;

import dstrukturen.Stack;

public class Stapeln {
    Stack<Muenze> s = new Stack<>();
    Stack<Muenze> zehn = new Stack<>();
    Stack<Muenze> zwanzig = new Stack<>();
    Stack<Muenze> funfzig = new Stack<>();
    Stack<Muenze> hundert = new Stack<>();
    Stack<Muenze> zweihundert = new Stack<>();

    public Stapeln() {

    }

    public void muenzenStapeln(int a) {
        while (!s.isEmpty()) {
            s.pop();
        }

        for (int i = 0; i < a; i++) {
            Muenze m = new Muenze(1);
            m.randomWert();
            System.out.print(m.getWert() + " ");
            s.push(m);
        }
        System.out.println();
    }

    public void muenzenSotieren() {
        int xzehn = 0;
        int xzwanzig = 0;
        int xfunfzig = 0;
        int xhundert = 0;
        int xzweihundert = 0;

        while (!s.isEmpty()) {
            switch (s.top().getWert()) {
                case 10: {
                    zehn.push(s.top());
                    xzehn += 1;
                    break;
                }
                case 20: {
                    zwanzig.push(s.top());
                    xzwanzig += 1;
                    break;
                }
                case 50: {
                    funfzig.push(s.top());
                    xfunfzig += 1;
                    break;
                }
                case 100: {
                    hundert.push(s.top());
                    xhundert += 1;
                    break;
                }
                case 200: {
                    zweihundert.push(s.top());
                    xzweihundert += 1;
                    break;
                }
                default: {
                    s.pop();
                }
            }
            s.pop();
        }

        System.out.println("10ct: " + xzehn + "; " + (xzehn * 10) + "ct");
        System.out.println("20ct: " + xzwanzig + "; " + (xzwanzig * 20) + "ct");
        System.out.println("50ct: " + xfunfzig + "; " + (xfunfzig * 50) + "ct");
        System.out.println("1€:   " + xhundert + "; " + (xhundert * 100) + "ct");
        System.out.println("2€:   " + xzweihundert + "; " + (xzweihundert * 200) + "ct");

        double x = (double) ((xzehn * 10) + (xzwanzig * 20) + (xfunfzig * 50) + (xhundert * 100) + (xzweihundert * 200))
                / 100;

        System.out.println("Gesamt: " + x + "€");
    }
}
