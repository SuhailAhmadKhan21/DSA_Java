class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid == null || m == 0)
            return 0;
        int ic = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1')
                {
                    ic++;
                    sink(grid,i,j);
                }
            }
        }
        return ic;
    }
    public void sink(char[][] grid, int row, int col)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col] == '0')
            return;

        grid[row][col] = '0';

        sink(grid,row-1,col); //up
        sink(grid,row+1,col); //down
        sink(grid,row,col-1); //left
        sink(grid,row,col+1); //right
    }
}