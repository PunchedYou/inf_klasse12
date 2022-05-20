package rekursion;

public class Fakultaet {
    public int iterFakul(int n) {
        int x = 1;

        for (int i = 1; i <= n; i++) {
            x = x * i;
        }

        return x;
    }

    public long rekurFakul(long n) {
        if (n > 1) {
            return n * rekurFakul(n - 1);
        } else {
            return 1;
        }
    }
}