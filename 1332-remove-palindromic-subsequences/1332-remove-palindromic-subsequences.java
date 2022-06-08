class Solution 
{
    public int removePalindromeSub(String s) 
    {
        int n = s.length();
        for(int i = 0; i < n/2; i++)
            if(s.charAt(i) != s.charAt(n - i - 1))
                return 2;
        return 1;
    }
}