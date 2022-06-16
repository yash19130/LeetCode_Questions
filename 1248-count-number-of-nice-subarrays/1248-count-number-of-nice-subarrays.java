class Solution 
{
    public int numberOfSubarrays(int[] a, int k) 
    {
        return OddAtMostK(a, k) - OddAtMostK(a, k - 1);
    }
    
    public int OddAtMostK(int[] a, int k)
    {
        int n = a.length;
        int i = 0, j = 0, odd = 0, ans = 0;
        while(j < n)
        {
            if(a[j] % 2 != 0)
                odd++;
            while(odd > k)
            {
                if(a[i++] % 2 != 0)
                    odd--;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}