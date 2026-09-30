class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        int result = dpHelper(grid, 0, 0, 0, dp, n);
        return Math.max(0, result);
    }
    
    private int dpHelper(int[][] grid, int r1, int c1, int r2, int[][][] dp, int n) {
        int c2 = r1 + c1 - r2;
        
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || 
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -999999;
        }
        
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        
        if (dp[r1][c1][r2] != -1) {
            return dp[r1][c1][r2];
        }
        
        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }
        
        int downDown = dpHelper(grid, r1 + 1, c1, r2 + 1, dp, n);
        int downRight = dpHelper(grid, r1 + 1, c1, r2, dp, n);
        int rightDown = dpHelper(grid, r1, c1 + 1, r2 + 1, dp, n);
        int rightRight = dpHelper(grid, r1, c1 + 1, r2, dp, n);
        
        cherries += Math.max(Math.max(downDown, downRight), Math.max(rightDown, rightRight));
        dp[r1][c1][r2] = cherries;
        return cherries;
    }
}