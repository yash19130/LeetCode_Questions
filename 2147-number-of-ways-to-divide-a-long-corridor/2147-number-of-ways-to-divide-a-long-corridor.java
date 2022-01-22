class Solution 
{
    public int numberOfWays(String str) 
    {
        int n = str.length();
        long ans = 1;
        int mod = (int)1e9+7;
        int ss = 0;
        for(int i=0; i<n; i++)
            if(str.charAt(i) == 'S')
                ss++;
        if(ss < 2 || ss % 2 != 0)
            return 0;
        ss = 0;
        int i = 0;
        while(i < n)
        {
            if(str.charAt(i) == 'S')
               ss++;
            if(ss == 2)
            {
                ss = 0;
                int j = i+1;
                while(j < n && str.charAt(j) == 'P')
                    j++;
                if(j == n)
                    break;
                ans *= (j-i);
                ans %= mod;
                i = j;
            }
            else
                i++;
        }
        return (int) ans;
    }
}