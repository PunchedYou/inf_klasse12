import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ArrSort {
    private long t0;
    private long t1;

    public static void main(String[] args) {
        ArrSort sort = new ArrSort();
        sort.testExample(100000);
    }

    public void testExample(int arrLength) {
        int[] arr = new int[arrLength];

        for (int i = 0; i < arrLength; i++) {
            arr[i] = (int) (Math.random() * (arrLength - 1)) + 1;
        }

        // Es wird eine Kopie des Arrays genommen um den original Array nicht zu verändern.

        bubbleSort(Arrays.copyOf(arr, arr.length));
        insertionSort(Arrays.copyOf(arr, arr.length));
        shellSort(Arrays.copyOf(arr, arr.length));
    }

    /**
     * <strong> Bubble Sort Algorithmus in aufsteigender Reihenfolge: </strong>
     * Die äußere Schleife durchläuft das Array von links nach rechts, während die
     * innere Schleife die nicht sortierte Teilmenge des Arrays durchläuft und
     * benachbarte Elemente vergleicht. Wenn ein Element größer als sein Nachbar
     * ist, werden sie getauscht, um das kleinere Element nach links zu bewegen. Am
     * Ende der äußeren Schleife wird das größte Element an der rechten Position
     * gesetzt, so dass es in der nächsten Iteration ignoriert werden kann, da es
     * bereits sortiert ist. Dieser Vorgang wird so lange wiederholt, bis alle
     * Elemente des Arrays sortiert sind.
     * 
     * @param arr Der zu sotierende ganzzahlige Array.
     * @return Die sortierte Version des Arrays.
     */
    public int[] bubbleSort(int[] arr) {
        t0 = System.nanoTime();

        int n = arr.length;
        boolean swapped = true; // Early Exit Wahrheitswert

        for (int i = 0; i < n - 1 && swapped; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Tausche arr[j] und arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
        }

        t1 = System.nanoTime();

        zeitAusgeben("Bubble Sort");

        return arr;
    }

    /**
     * <strong> Insertion Sort-Algorithmus in aufsteigender Reihenfolge: </strong>
     * Die äußere Schleife durchläuft das Array von links nach rechts, während die
     * innere Schleife das aktuelle Element key mit jedem Element in der sortierten
     * Teilmenge des Arrays vergleicht, das kleiner als key ist. Solange ein Element
     * größer als key ist, wird es um eine Position nach rechts verschoben, um Platz
     * für key zu machen. Wenn kein Element mehr größer als key ist, wird key an der
     * richtigen Stelle in die sortierte Teilmenge eingefügt. Am Ende der äußeren
     * Schleife ist das gesamte Array sortiert.
     * 
     * @param arr Der zu sotierende ganzzahlige Array.
     * @return Die sortierte Version des Arrays.
     */
    public int[] insertionSort(int[] arr) {
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

        zeitAusgeben("Insertion Sort");

        return arr;
    }

    /**
     * <strong> Shell Sort Algorithmus in aufsteigender Reihenfolge: </strong>
     * Die Methode verwendet eine Serie von Abständen, um das Array zu sortieren,
     * wobei jeder Abstand eine Teilmenge des Arrays bildet, die mit dem
     * Insertion-Sort-Algorithmus sortiert wird. Die äußere Schleife durchläuft die
     * Abstände, beginnend mit der Hälfte der Länge des Arrays und halbiert diesen
     * Abstand in jeder Iteration, bis der Abstand 1 erreicht. In jeder Iteration
     * wird die sortierte Teilmenge des Arrays vergrößert, indem Elemente mit
     * demselben Abstand gap voneinander verglichen und verschoben werden, bis die
     * sortierte Teilmenge die gesamte Länge des Arrays umfasst. Am Ende der äußeren
     * Schleife ist das gesamte Array sortiert.
     * 
     * @param arr Der zu sotierende ganzzahlige Array.
     * @return Die sortierte Version des Arrays.
     */
    public int[] shellSort(int[] arr) {
        t0 = System.nanoTime();

        int n = arr.length;
        int gap = n / 2; // Initialisierung des Abstands

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }

            gap /= 2; // Reduktion des Abstands
        }

        t1 = System.nanoTime();

        zeitAusgeben("Shell Sort");

        return arr;

    }

    private void zeitAusgeben(String type) {
        long sekunden = TimeUnit.NANOSECONDS.toSeconds(t1 - t0);
        long millisekunden = TimeUnit.NANOSECONDS.toMillis(t1 - t0);

        System.out.println("[" + type + "] " + sekunden + "s" + " (" + millisekunden + "ms)");
    }

    private void arrayAusgeben(int[] arr, int amount) {
        System.out.print("[");
        for(int i = 0; i < amount - 1; i++) {
            System.out.print(arr[i] + "; ");
        }
        System.out.println(arr[amount] + "]");
    }
}