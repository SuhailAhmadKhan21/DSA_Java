class Solution {
    int[] Pmax;
    int[] Smin;
    void Prefix(int[] arr)
    {
        int n = arr.length;
        Pmax = new int[n];
        Pmax[0] = arr[0];
        for(int i=1; i<n; i++)
        {
            if(arr[i] >= Pmax[i-1])
                Pmax[i] = arr[i];
            else
                Pmax[i] = Pmax[i-1];
        }
    }
    void Suffix(int[] arr)
    {
        int n = arr.length;
        Smin = new int[n];
        Smin[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--)
        {
            if(arr[i] <= Smin[i+1])
                Smin[i] = arr[i];
            else
                Smin[i] = Smin[i+1];
        }
    }
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        Prefix(arr);
        Suffix(arr);
        int c = 0;
        for(int i=0; i<n-1; i++)
        {
            if(Pmax[i] <= Smin[i+1])
                c++;
        }
        return c+1;
    }
}