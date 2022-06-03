class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        boolean[] vis = new boolean[256];
        int i = 0, j = 0;
        int longest = 0;
        while(j < s.length())
        {
            if(vis[s.charAt(j)])
                vis[s.charAt(i++)] = false;
            else
                vis[s.charAt(j++)] = true;
            longest = Math.max(longest, j - i);
        }
        return longest;
    }
}