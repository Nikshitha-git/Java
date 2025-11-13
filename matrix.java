import java.util.Arrays;

public class matrix{

    static int[][] memo;

    static int matrixChainOrder(int[] dims, int i, int j) {
        if (i == j) return 0; // Only one matrix, no multiplication needed

        if (memo[i][j] != -1) return memo[i][j]; // Return already computed value

        int minCost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = matrixChainOrder(dims, i, k) +
                       matrixChainOrder(dims, k + 1, j) +
                       dims[i - 1] * dims[k] * dims[j];

            minCost = Math.min(minCost, cost);
        }

        memo[i][j] = minCost; // Store result in memo
        return minCost;
    }

    public static void main(String[] args) {
        int[] dims = {10,20,30,40,30}; // Matrix dimensions
        int n = dims.length;

        // Initialize memo table with -1
        memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);

        // Call the function for the full chain
        int result = matrixChainOrder(dims, 1, n - 1);

        System.out.println("Minimum number of multiplications is: " + result);
    }
}
