package dstrukturen;

public class ErweiterteQueue extends Queue {

    public ErweiterteQueue() {

    }

    public void methode1(Queue pSchlange) {
        while (!pSchlange.isEmpty()) {
            this.enqueue(pSchlange.front());
            pSchlange.dequeue();
        }
    }
}
