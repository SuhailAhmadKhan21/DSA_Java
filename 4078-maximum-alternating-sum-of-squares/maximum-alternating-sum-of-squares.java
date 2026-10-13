import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        // 1. Sort the input array based on absolute values
        // We box the int[] to Integer[] to use standard Collections/Arrays sort with a custom comparator
        Integer[] boxed = new Integer[n];
        for (int i = 0; i < n; i++) {
            boxed[i] = nums[i];
        }
        
        // Sort by Math.abs(a) - Math.abs(b)
        Arrays.sort(boxed, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));
        
        // 2. Rearrange the sorted elements into the dest array (Last, First, Second-Last, Second...)
        int[] dest = new int[n];
        int left = 0;
        int right = n - 1;
        int destIdx = 0;
        
        while (left <= right) {
            if (destIdx < n) {
                dest[destIdx++] = boxed[right--];
            }
            if (left <= right && destIdx < n) {
                dest[destIdx++] = boxed[left++];
            }
        }

        // 3. Calculate the alternating sum of squares
        long ans = 0;
        int sign = 1;
        for (int i = 0; i < n; i++) {
            long square = (long) dest[i] * dest[i];
            ans += square * sign;
            sign *= -1;
        }
        
        return ans;
    }
}
