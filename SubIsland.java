public class SubIsland {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1[0].length;
        int n = grid1.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // out of bound
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
            return true;
        }
        if (grid2[i][j] == 0) {
            return true;
        }
        if (grid1[i][j] == 0) {
            return false;
        }
        grid2[i][j] = 0;
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean right = dfs(grid1, grid2, i, j + 1);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        return up && right && down && left;
    }

    public static void main(String[] args) {
        SubIsland solution = new SubIsland();
        int[][] grid1 = {
            {1, 1, 1, 0, 0},
            {0, 1, 0, 0, 1},
            {0, 0, 0, 1, 1},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        int[][] grid2 = {
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        int count = solution.countSubIslands(grid1, grid2);
        System.out.println("Number of sub-islands: " + count);
    }
}