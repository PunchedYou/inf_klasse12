import java.util.concurrent.TimeUnit;

public class ArrSort {
    private long t0;
    private long t1;

    public ArrSort(int länge) {
        int[] arr = new int[länge];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000) + 1;
        }

        System.out.println();

        bubbleSort(arr);
        insertionSort(arr);
        shellSort(arr);
    }

    public void shellSort(int[] arr) {

    }

    public void insertionSort(int[] arr) {
        t0 = System.nanoTime();

        for (int i = 1; i < arr.length; i++) {
            int wert = arr[i];
            int j = i;

            while (j > 0 && wert < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = wert;
        }

        t1 = System.nanoTime();

        // arrayAusgeben(arr);
        zeitAusgeben(t0, t1, "Insertion Sort");
    }

    public void bubbleSort(int[] arr) {
        int u = 0;

        t0 = System.nanoTime();

        for (int i = 0; i < arr.length; i++) {
            int c = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    c++;
                    u++;
                }
            }

            if (c <= 1) {
                break;
            }
        }

        t1 = System.nanoTime();

        // arrayAusgeben(arr);
        zeitAusgeben(t0, t1, "Bubble Sort");
    }

    private void arrayAusgeben(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "]");
        }

        System.out.println();
    }

    private void zeitAusgeben(long t0, long t1, String sotierart) {
        long sekunden = TimeUnit.NANOSECONDS.toSeconds(t1 - t0);
        long millisekunden = TimeUnit.NANOSECONDS.toMillis(t1 - t0);

        System.out.println("[" + sotierart + "] " + sekunden + "sek" + " (" + millisekunden + "ms)!");
    }
}