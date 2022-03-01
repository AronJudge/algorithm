package Dynamic;

public class Dynamic {
    private int maxw = Integer.MIN_VALUE;
    private int[] weight = {2, 2, 4, 6, 3};
    private int n = 5;
    private int w = 9;
    private boolean[][] mem = new boolean[5][10];  // 备忘录，默认值false

    private void f(int i, int cw) {
        if (cw == w || i == n) {// cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxw) maxw = cw;
            return;
        }
        if (mem[i][cw]) return;
        mem[i][cw] = true;
        f(i + 1, cw);
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]);// 选择装第i个物品
        }
    }

    // dynamic  尽管动态规划的执行效率比较高，但是就刚刚的代码实现来说，我们需要额外申请一个 n 乘以 w+1 的二维数组
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 0; i < n; i++) {// 动态规划状态转移
            for (int j = 0; j <= w; j++) { // 不把第i个物品放入背包
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) { //把第i个物品放入背包
                if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i] == true) return i;
        }
        return 0;
    }

    // 实际上，我们只需要一个大小为 w+1 的一维数组就可以解决这个问题。
    // 动态规划状态转移的过程，都可以基于这个一维数组来操作。
    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w+1]; // default value false.
        states[0] = true;   // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
            states[items[0]] = true;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = w - items[i]; j >= 0; --j) {
                 if (states[j] == true) states[j + items[i]] = true;
            }
        }
        for (int i = w; i >= 0 ; --i) {
            if (states[i] == true) return i;
        }
        return 0;
    }

    // 我们现在引入物品价值这一变量。对于一组不同重量、不同价值、不可分割的物品，
    // 我们选择将某些物品装入背包，在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
    private int maxV = Integer.MIN_VALUE; // // 结果放到maxV中
    private int[] item = {2, 2, 4, 6, 3}; // weight
    private int[] value = {3, 4, 8, 9, 6};// value
    public void f(int i, int cw, int cv) {
        if (cw == w || i == n) {          // cw==w表示装满了，i==n表示物品都考察完了
            if (cv > maxV) maxV = cv;
            return;
        }
        f(i + 1, cw, cv);
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i], cv + value[i]);
        }
    }


    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= w; ++j) {
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++i) {
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        int maxValue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxValue) maxValue = states[n-1][j];
        }
        return maxValue;
    }
}
