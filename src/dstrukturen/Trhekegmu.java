package dstrukturen;

public class Trhekegmu {
    Stack s = new Stack<Integer>();

    public Trhekegmu() {
        Queue q = new Queue<Integer>();

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
