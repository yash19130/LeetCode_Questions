class Solution 
{
    public int minimumLengthEncoding(String[] words) 
    {
        Set<String> hs = new HashSet<>();
        for(String s: words)
            hs.add(s);
        for(String s: words)
        {
            int n = s.length();
            for(int i=1; i<n; i++)
            {
                if(hs.contains(s.substring(i)))
                    hs.remove(s.substring(i));
            }
        }
        int ans = 0;
        for(String s: hs)
            ans += s.length();
        return ans + hs.size();
    }
}