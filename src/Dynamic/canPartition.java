package Dynamic;

import com.sun.jmx.snmp.SnmpNull;

// 分割等和子集
public class canPartition {
    public boolean canPartitions(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return  false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 == 1) return  false;
        int target = sum / 2;
        int[] dp = new int[target+1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[i - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
