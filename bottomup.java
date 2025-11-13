public class bottomup {
    static int matrixChainOrder(int[] dims) {
        int n = dims.length;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n - 1];
    }
    public static void main(String[] args) {
        int[] dims = {40, 20, 30, 10, 30};
        System.out.println("Minimum number of multiplications is: " + matrixChainOrder(dims));
    }
}
