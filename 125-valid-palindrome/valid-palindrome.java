class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int h = s.length()-1;
        while(l<h)
        {
            char ch1 = s.charAt(l);
            char ch2 = s.charAt(h);
            if (!Character.isLetterOrDigit(ch1)) {
                l++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                h--;
            } else {
                if (ch1 != ch2) {
                    return false;
                }
                l++;
                h--;
            }
        }
        return true;
    }
}