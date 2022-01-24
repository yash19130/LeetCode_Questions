class Solution 
{
    public boolean detectCapitalUse(String word) 
    {
        int n = word.length();
        int upper = 0, lower = 0;
        for(char c: word.toCharArray())
        {
            if(Character.isUpperCase(c))
                upper++;
            if(Character.isLowerCase(c))
                lower++;
        }
        return (upper == n) || (lower == n) 
            || (Character.isUpperCase(word.charAt(0)) && lower == n-1);
    }
}