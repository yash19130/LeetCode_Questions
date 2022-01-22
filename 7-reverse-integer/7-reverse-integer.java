class Solution 
{
    public int reverse(int x)
    {
        boolean neg = false;
        StringBuilder str = new StringBuilder(x+"");
        StringBuilder rev = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--)
            rev.append(str.charAt(i));
        if(str.charAt(0) == '-')
        {
            neg = true;
            rev.deleteCharAt(rev.length()-1);
        }
        if(neg)
        {
            if(-Long.parseLong(rev.toString()) < Integer.MIN_VALUE)
                return 0;
            return -Integer.parseInt(rev.toString());
        }
        if(Long.parseLong(rev.toString()) > Integer.MAX_VALUE)
            return 0;
        return Integer.parseInt(rev.toString());
    }
}