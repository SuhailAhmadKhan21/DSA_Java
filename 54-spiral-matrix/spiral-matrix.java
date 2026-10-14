class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> l = new ArrayList<>();
        int i=0;
        int j=0;
        int rstep = n-1;
        int cstep = m-1;
        while(rstep>=1 && cstep>=1)
        {
            for(int k=0; k<cstep; k++)
            {
                l.add(matrix[i][j]);
                j++;
            }
            for(int k=0; k<rstep; k++)
            {
                l.add(matrix[i][j]);
                i++;
            }
            for(int k=0; k<cstep; k++)
            {
                l.add(matrix[i][j]);
                j--;
            }
            for(int k=0; k<rstep; k++)
            {
                l.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            rstep -= 2;
            cstep -= 2;
        }
        if(rstep == 0)
        {
            for(int k=0; k<cstep+1; k++)
            {
                l.add(matrix[i][j]);
                j++;
            }

        }
        else if(cstep == 0)
        {
            for(int k=0; k<rstep+1; k++)
            {
                l.add(matrix[i][j]);
                i++;
            }
        }
        return l;
    }
}