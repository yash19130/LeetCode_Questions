class Solution 
{
    public boolean hasAllCodes(String s, int k) 
    {
        Set<String> hs = new HashSet<>();
        int total = (int) Math.pow(2, k);
        for(int i = 0; i <= s.length() - k; i++)
        {
            hs.add(s.substring(i, i + k));
            if(hs.size() == total)
                return true;
        }
        return false;
    }
}