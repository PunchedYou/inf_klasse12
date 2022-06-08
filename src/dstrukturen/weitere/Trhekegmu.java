package dstrukturen.weitere;

import dstrukturen.Queue;
import dstrukturen.Stack;

public class Trhekegmu {
    Stack<Integer> s = new Stack<>();

    public Trhekegmu() {
        Queue<Integer> q = new Queue<>();

        for (int i = 0; i < 20; i++) {
            int random = ((int) (Math.random() * 9));
            System.out.print(random + " ");
            q.enqueue(random);
        }

        System.out.println();

        zahlenUmkehren(q);
    }

    public void zahlenUmkehren(Queue<Integer> q) {
        while (!q.isEmpty()) {
            s.push(q.front());
            q.dequeue();
        }

        while (!s.isEmpty()) {
            System.out.print(s.top() + " ");
            s.pop();
        }

        System.out.println("\n");
    }
}
