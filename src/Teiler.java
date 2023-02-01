public class Teiler {
    public int groessterTeiler(int a, int b) {
        int x = 1;
        if (b < a) {
            x = b;
        } else {
            x = a;
        }

        for (int i = x; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 0;
    }
}