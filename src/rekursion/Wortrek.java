package rekursion;

public class Wortrek {
    public static void main(String[] args) {
        Wortrek wr = new Wortrek();
        System.out.println(wr.rekStart(3));
        System.out.println(wr.rekStart(6));
    }

    public String rekStart(int x) {
        return methA(x, "");
    }

    public String methA(int n, String s) {
        if (n <= 0) {
            return "";
        } else {
            return "a" + methB(n - 1, s);
        }
    }

    public String methB(int n, String s) {
        if (n <= 0) {
            return "";
        } else {
            return methA(n - 1, s) + "b";
        }
    }
}
