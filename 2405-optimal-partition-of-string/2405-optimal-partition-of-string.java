class Solution 
{
    public int partitionString(String s) 
    {
        boolean[] vis = new boolean[26];
        int ans = 1;
        for(char c: s.toCharArray())
        {
            if(vis[c - 'a'])
            {
                ans++;
                vis = new boolean[26];
            }
            vis[c - 'a'] = true;
        }
        return ans;
    }
}