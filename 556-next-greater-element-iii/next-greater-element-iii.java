class Solution {
    public int nextGreaterElement(int n) {
        char[] ch = (n+"").toCharArray();
        int idx = -1;

        for(int i=ch.length-2; i>=0; i--)
        {
            if(ch[i] < ch[i+1])
            {
                idx = i;
                break;
            }
        }

        if(idx == -1)
            return idx;

        char val = ch[idx];
        int smallestidx = idx+1;

        for(int i=idx+1; i<ch.length; i++)
        {
            if(ch[i] > val && ch[i] <= ch[smallestidx])
                smallestidx = i;
        }

        char temp = ch[idx];
        ch[idx] = ch[smallestidx];
        ch[smallestidx] = temp;

        Arrays.sort(ch, idx+1, ch.length);

        long ans = Long.parseLong(new String(ch));

        if(ans > Integer.MAX_VALUE)
            return -1;
        else
            return (int)ans;
    }
}