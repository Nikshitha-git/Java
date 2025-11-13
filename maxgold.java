public class maxgold {
    public static int getMaxGold(int[][] grid) {
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) { // Start from every non-zero cell
                    maxGold = Math.max(maxGold, collectGold(grid, i, j));
                }
            }
        }
        return maxGold;
    }
    private static int collectGold(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        int gold = grid[x][y];
        grid[x][y] = 0;
        int up = collectGold(grid, x - 1, y);
        int down = collectGold(grid, x + 1, y);
        int left = collectGold(grid, x, y - 1);
        int right = collectGold(grid, x, y + 1);
        grid[x][y] = gold;
        return gold + Math.max(Math.max(up, down), Math.max(left, right));
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0,6,0},
            {5,8,7},
            {0,9,0}
        };
        System.out.println("Maximum gold collected: " + getMaxGold(grid));
    }
}
