package LeeCode;

import java.util.HashSet;
import java.util.Set;

public class No3 {
    public int findRepeatNumber(int[] nums) {
        int repeat = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for (int num : nums) {
            if (dic.contains(num)) return num;
            dic.add(num);
        }
        return -1;
    }

    public int findRepeatNumber3(int[] nums) {
        int i = 0;
        while(i< nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tem = nums[i];
            nums[i] = nums[tem];
            nums[tem] = tem;
        }
        return -1;
    }
}
