class Solution 
{
    public boolean isSubsequence(String s, String t) 
    {
        int k = 0;
        for(int i=0; i<s.length(); i++)
        {
            boolean found = false;
            char c = s.charAt(i);
            for(int j=k; j<t.length(); j++)
            {
                if(t.charAt(j)==c)
                {
                    found = true;
                    k = j+1;
                    break;
                }
            }
            if(!found)
                return false;
        }
        return true;
    }
}