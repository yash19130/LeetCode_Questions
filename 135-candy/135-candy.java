class Solution 
{
    public int candy(int[] ratings) 
    {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=1; i<n; i++)
        {
            if(ratings[i] > ratings[i - 1])
                left[i] += 1 + left[i - 1];
        }
        for(int i=n-2; i>=0; i--)
        {
            if(ratings[i] > ratings[i + 1])
                right[i] += 1 + right[i + 1];
        }
        int ans = 0;
        for(int i=0; i<n; i++)
            ans += Math.max(left[i], right[i]);
        return n + ans;
    }
}