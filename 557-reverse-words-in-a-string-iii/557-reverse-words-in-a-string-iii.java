class Solution 
{
    public void reverse(int i, int j, char[] ch)
    {
        while(i < j)
        {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
    
    public String reverseWords(String s) 
    {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int beg = 0, end = 0;
        for(int i=0; i<n; i++)
        {
            if(ch[i] == ' ')
            {
                reverse(beg, end - 1, ch);
                beg = i + 1;
            }
            end++;
        }
        reverse(beg, end - 1, ch);
        return String.valueOf(ch);
    }
}