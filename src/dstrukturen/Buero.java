package dstrukturen;

public class Buero {
    Queue<Person> q = new Queue<Person>();

    public Buero() {

    }

    public void hintenAnstellen(Person p) {
        q.enqueue(p);
    }

    public void einlassen() {
        System.out.print("Eine wartende Person wurde eingelassen");
        q.dequeue();
    }

    public void sprechstundeBeenden() {
        while (!q.isEmpty()) {
            q.dequeue();
        }

        System.out.println("Alle Personen aus der Schlange wurden nach Hause geschickt.");
    }
}
