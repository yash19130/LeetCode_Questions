class Solution 
{
    public int countOrders(int n) 
    {
        long ans = 1;
        int mod = (int) (1e9 + 7);
        for(int i=2; i<=n; i++)
        {
            ans *= (2 * i - 1) * i;
            ans %= mod;
        }
        return (int) ans;
    }
}