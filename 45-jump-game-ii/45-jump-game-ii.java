class Solution
{
    public int jump(int[] nums)
    {
        int jumps = 0;
        int n = nums.length;
        int farthestTillNow = 0, end = 0;
        for(int i=0; i<=n-2; i++)
        {
            farthestTillNow = Math.max(farthestTillNow, i + nums[i]);
            if(i == end)
            {
                jumps++;
                end = farthestTillNow;
            }
        }
        return jumps;
    }
}