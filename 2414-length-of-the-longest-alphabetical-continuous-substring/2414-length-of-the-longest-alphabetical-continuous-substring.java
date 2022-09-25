class Solution 
{
    public int longestContinuousSubstring(String s) 
    {
        int i = 0, n = s.length();
        int ans = 1;
        while(i < n)
        {
            int j = i + 1;
            while(j < n && s.charAt(j) - 1 == s.charAt(j - 1))
                j++;
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }
}