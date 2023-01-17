package encryption;

import dstrukturen.Queue;

public class Balance {
    public String pushDuplicates1(String k) {
        for (int i = 0; i < k.length() - 1; i += 2) {
            if (k.charAt(i) == k.charAt(i + 1)) {
                k = k.substring(0, i + 1) + 'X' + k.substring(i + 1);
            }
        }

        return k;
    }

    public String pushDuplicates2(String k) {
        String a = "";

        for (int i = 0; i < k.length(); i++) {
            if (i % 2 != 0 && k.charAt(i) == a.charAt(a.length() - 1)) {
                a += "X";
                i--;
            } else {
                a += k.charAt(i);
            }
        }

        return a;
    }

    public String pushDuplicates3(String k) {
        // Vorbereitung
        String kn = "";
        k = k.toUpperCase();
        Queue<Character> q = new Queue<Character>();
        for (int i = 0; i < k.length(); i++) {
            q.enqueue(k.charAt(i));
        }
        // Algorithmus
        char a = q.front();
        q.dequeue();
        while (!q.isEmpty()) {
            if (a == q.front()) {
                kn += "" + a + 'X';
            } else {
                kn += "" + a + q.front();
                q.dequeue();
            }
            if (!q.isEmpty()) {
                a = q.front();
                q.dequeue();
                if (q.isEmpty()) {
                    kn += "" + a + 'X';
                }
            }
        }
        return kn;
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        System.out.println(insert.pushDuplicates2("SCHIFFFAHRT"));
    }
}
