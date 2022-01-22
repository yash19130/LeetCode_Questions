class Solution 
{
    public int reverse(int x)
    {
        boolean neg = false;
        StringBuilder str = new StringBuilder(x+"");
        StringBuilder rev = new StringBuilder();
        int end = 0;
        if(str.charAt(0) == '-')
        {
            neg = true;
            end = 1;
            rev.append('-');
        }
        for(int i=str.length()-1; i>=end; i--)
            rev.append(str.charAt(i));
        if(neg)
        {
            StringBuilder min = new StringBuilder(Integer.MIN_VALUE + "");
            if(rev.length() > min.length())
                return 0;
            if(rev.length() == min.length())
            {
                for(int i=0; i<rev.length(); i++)
                {
                    if(rev.charAt(i) > min.charAt(i))
                        return 0;
                    if(rev.charAt(i) < min.charAt(i))
                        break;
                }
            }
            return Integer.parseInt(rev.toString());
        }
        StringBuilder max = new StringBuilder(Integer.MAX_VALUE + "");
        if(rev.length() > max.length())
            return 0;
        if(rev.length() == max.length())
        {
            for(int i=0; i<rev.length(); i++)
            {
                if(rev.charAt(i) > max.charAt(i))
                    return 0;
                if(rev.charAt(i) < max.charAt(i))
                    break;
            }
        }
        return Integer.parseInt(rev.toString());
    }
}