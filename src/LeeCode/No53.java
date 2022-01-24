package LeeCode;

public class No53 {
    public int search(int[] nums, int target) {
        // search right side
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m+1;
            else j = m -1;
        }
        int right = i;
        if (j >= 0 && nums[j] != target) return 0;
        // search left side
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) /2;
            if (nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }

    int search1(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m -1;
        }
        return i;
    }

}
