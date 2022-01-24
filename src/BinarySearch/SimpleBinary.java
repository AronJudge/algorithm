package BinarySearch;

public class SimpleBinary {

    public int breach(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            // int mid = (low + high) /2;
            // int mid = low + (high - low)/2;
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int bsearch(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

/*    private int sqrt(int num) {

        int num1 = num;
        int mid = num1 / 2;
        if (mid * mid <= num1) {
            return mid;
        } else {
            mid = mid / 2;
        }

    }*/

    public static void main(String[] args) {
        System.out.println(MySqrt(12, 20));
        System.out.println(mySqrt(12));
    }

    static double MySqrt(int value, double t) {
        if (value == 0 || t < 0) return 0;
        double left = 0;
        double right = value;
        double mid = (right + left) / 2;
        double offset = 2 * t;
        while (offset > t) {
            double temp = mid * mid;
            if (temp > value) {
                right = (left + right) / 2;
                offset = temp - value;
            }
            if (temp <= value) {
                left = (left + right) / 2;
                offset = value - temp;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }

    public static int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt < mid) {
                h = mid + 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

    public int binarySearch(int[] arr, int target) {
        int leftIndex = 0;
        int num[] = arr;
        int que = target;
        int rightIndex = num.length - 1;
        int ret = -1;
        while (leftIndex != rightIndex) {
            int mid = leftIndex + rightIndex / 2;
            if (num[mid] == que) {
                return mid;
            } else if (num[mid] > que) {
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
        }
        return ret;
    }
    // 查找第一个值等于给定值的元素
    public int binarySearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || a[mid - 1] != value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    // 查找最后一个值等于给定值的元素
    public int binarySearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    // 查找第一个大于等于给定值的元素
    public int binarySearch4(int[] a, int n, int value ) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1]< value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    // 查找最后一个小于等于给定值的元素
    public int binarySearch5(int a[], int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid -1;
            } else {
                if ((mid == n -1) || (a[mid + 1 ] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    // 33. 搜索旋转排序数组



}
