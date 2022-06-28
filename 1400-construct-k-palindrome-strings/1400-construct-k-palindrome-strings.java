class Solution 
{
    public boolean canConstruct(String s, int k) 
    {
        if(s.length() < k)
            return false;
        int[] cnt = new int[26];
        for(char c: s.toCharArray())
            cnt[c - 'a']++;
        int odd = 0;
        for(int i=0; i<26; i++)
        {
            if(cnt[i] % 2 != 0)
                odd++;
        }
        return odd <= k;
    }
}