class Pair
{
    int i;
    int j;
    int t;
    public Pair(int a, int b, int c)
    {
        this.i=a;
        this.j=b;
        this.t=c;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int ans = 0;
        while(q.size() > 0)
        {
            Pair rem = q.remove();
            int crow = rem.i;
            int ccol = rem.j;
            int ctime = rem.t;
            ans = ctime;

            if(crow-1>=0 && grid[crow-1][ccol]==1)
            {
                q.add(new Pair(crow-1,ccol,ctime+1));
                grid[crow-1][ccol] = 2;
            }

            if(ccol+1<m && grid[crow][ccol+1]==1)
            {
                q.add(new Pair(crow,ccol+1,ctime+1));
                grid[crow][ccol+1] = 2;
            }

            if(crow+1<n && grid[crow+1][ccol]==1)
            {
                q.add(new Pair(crow+1,ccol,ctime+1));
                grid[crow+1][ccol] = 2;
            }

            if(ccol-1>=0 && grid[crow][ccol-1]==1)
            {
                q.add(new Pair(crow,ccol-1,ctime+1));
                grid[crow][ccol-1] = 2;
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 1)
                {
                    return -1;
                }
            }
        }
        return ans;
    }
}