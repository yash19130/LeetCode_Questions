class Solution 
{
    public String removeDuplicates(String s, int k) 
    {
        int i = 0;
        while(i < s.length())
        {
            int j = i+1;
            while(j < s.length() && s.charAt(i) == s.charAt(j))
                j++;
            if(j - i >= k)
            {
                s = s.substring(0, i) + s.substring(i+k);
                if(i != 0)
                {
                    i--;
                    j = i - 1;
                    while(j >= 0 && s.charAt(i) == s.charAt(j))
                        j--;
                    i = j + 1;
                }
                continue;
            }
            i = j;
        }
        return s;
    }
}