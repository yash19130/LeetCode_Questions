class Solution 
{
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) 
    {
        int sumEven = 0;
        for(int n: nums)
            if(n % 2 == 0)
                sumEven += n;
        int[] ans = new int[queries.length];
        int j = 0;
        for(int[] q: queries)
        {
            int val = q[0], i = q[1];
            if(nums[i] % 2 == 0)
                sumEven -= nums[i];
            nums[i] += val;
            if(nums[i] % 2 == 0)
                sumEven += nums[i];
            ans[j++] = sumEven;
        }
        return ans;
    }
}