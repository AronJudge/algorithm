package Sort;

public class Sort {

    public void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++n) {
            // early end flag.
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break; // no data swap, break early.
        }
    }

    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int k = i - 1;
            for (; k >= 0; k--) {
                if (a[k] > value) {
                    a[k + 1] = a[k]; // data remove
                } else {
                    break;
                }
            }
            a[k + 1] = value;
        }
    }


    private static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = 0; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    private static void shellSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return;

        int step = len / 2;
        while(step >= 1) {
            for (int i = step; i < len; i++) {
                int value = arr[i];
                int j = i -step;
                //for (; j >= 0; )
            }
        }
    }
}
