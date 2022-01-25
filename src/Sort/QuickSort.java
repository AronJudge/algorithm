package Sort;

public class QuickSort {

    // QuickSort, A is array, n is the size of array.
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(a, p ,r); // get partition
        quickSortInternally(a, p ,q-1);
        quickSortInternally(a, q+1 ,r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = 0; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int temp = a[i];
                    a[i++] = a[j];
                    a[j] = temp;
                }
            }
        }
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;

        System.out.println("i=" + i);
        return i;
    }
}
