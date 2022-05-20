package dstrukturen;

public class Schlange {
    Queue<Integer> zahlen = new Queue<Integer>();

    public Schlange() {

    }

    public void zahlenSchlange(String s) {
        for (int i = 0; i < s.length(); i++) {
            zahlen.enqueue(Integer.parseInt("" + s.charAt(i)));
        }
    }

    public void zahlenSchlangezuInt(Queue<Integer> z) {
        String s = "";

        while (!z.isEmpty()) {
            s += z.front();
            z.dequeue();
        }

        int a = Integer.parseInt(s);

        System.out.println(a);
    }
}