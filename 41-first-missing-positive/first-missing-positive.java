class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n)
        {
            if(i == nums[i]-1 || nums[i]>n || nums[i]<1)
                i++;
            else
            {
                int idx = nums[i]-1;
                if(nums[i] == nums[idx])
                    i++;
                else
                {
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                }
            }
        }
        for(int j=0; j<n; j++)
        {
            if(nums[j]-1 != j)
                return j+1;
        }
        return n+1;
    }
}