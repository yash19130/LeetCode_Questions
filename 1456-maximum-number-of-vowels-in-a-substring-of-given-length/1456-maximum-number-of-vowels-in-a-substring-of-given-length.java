class Solution 
{
    public int maxVowels(String s, int k) 
    {
        int n = s.length();
        int curVowels = 0;
        for(int i=0; i<k; i++)
        {
            if(isVowel(s.charAt(i)))
                curVowels++;
        }
        int maxVowels = curVowels;
        for(int i=k; i<n; i++)
        {
            if(isVowel(s.charAt(i-k)))
                curVowels--;
            if(isVowel(s.charAt(i)))
                curVowels++;
            maxVowels = Math.max(maxVowels, curVowels);
        }
        return maxVowels;
    }
    
    public boolean isVowel(char c)
    {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}