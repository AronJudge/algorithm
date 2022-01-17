package Sort;

public class Sort {

    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length < 2) {
            return;
        }
        // array min value
        int minValue = arr[0];
        // array max value
        int maxValue = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        int bucketCount = (maxValue - minValue) / bucketSize +1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];

        // 将数组中值分配到各个桶里
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - minValue) / bucketSize;
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
        }

        // 对每个桶进行排序，这里使用了快速排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            quickSortC(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }


    }

    /**
     * 快速排序递归函数
     *
     * @param arr
     * @param p
     * @param r
     */
    private static void quickSortC(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(arr, p, r);
        quickSortC(arr, p, q - 1);
        quickSortC(arr, q + 1, r);
    }


    /**
     * 分区函数
     *
     * @param arr
     * @param p
     * @param r
     * @return 分区点位置
     */
    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);
        return i;
    }

    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 数组扩容
     *
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

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


    public void merge_sort(int[] a, int n) {
        merge_sort_c(a,0,n-1);
    }

    public void merge_sort_c(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p+r)/2;

        merge_sort_c(a,p,q);
        merge_sort_c(a,q+1,r);


    }

/*    private int[] merge(int[] a) {

    }*/


}
