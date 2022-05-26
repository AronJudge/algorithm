package Dynamic;

public class testweightbagproblem {

    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagsize = 4;
        // weightBag2(weight,value,bagsize);
        weightBagComplete();
    }



    public static void weightBag(int[] weight, int[] value, int bagsize) {
        int wlen = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen + 1][bagsize + 1];
        //初始化：背包容量为0时，能获得的价值都为0
/*
        for (int i = 0; i <= wlen; i++){
            dp[i][0] = value0;
        }
*/

        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen; i++){
            for (int j = 1; j <= bagsize; j++){
                if (j < weight[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= wlen; i++){
            for (int j = 0; j <= bagsize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void weightBag2(int[] weight, int[] value, int bagsize) {
        int wlen = weight.length;
        int[] dp = new int[bagsize + 1];
        for (int i = 0; i < wlen; i++) {
            for (int j = bagsize; j >= weight[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        for (int i = 0; i <=  bagsize; i++) {
            System.out.println(dp[i] + " ");
        }
    }

    public static void weightBagComplete() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 40};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            for (int j = weight[i]; j <= bagWeight ; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i] );
                System.out.println(dp[j]);
            }
        }
/*        for (int maxValue : dp) {
            System.out.println(maxValue);
        }*/
    }
}
