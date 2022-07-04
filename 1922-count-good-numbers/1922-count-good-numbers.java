class Solution 
{
    public long mod = (long) (1e9 + 7);
    
    public long pow(long n, long p)
    {
        if(p == 0L)
            return 1;
        if(p == 1L)
            return n % mod;
        long cur = (pow(n, p / 2) % mod);
        if((p & 1) == 0)
            return (cur * cur) % mod;
        return ((n % mod) * ((cur % mod) * (cur % mod)) % mod) % mod;
    }
    
    public int countGoodNumbers(long n) 
    {
        if((n & 1) == 0)
            return (int) (((pow(5L, n / 2) % mod) * (pow(4L, n / 2) % mod)) % mod);
        return (int) (((pow(5L, (n / 2) + 1) % mod) * (pow(4L, n / 2) % mod)) % mod);
    }
}