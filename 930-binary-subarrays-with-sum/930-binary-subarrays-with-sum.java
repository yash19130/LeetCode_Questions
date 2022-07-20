class Solution 
{
    public int numSubarraysWithSum(int[] nums, int goal) 
    {
        Map<Integer, Integer> hp = new HashMap<>();
        hp.put(0, 1);
        int sum = 0, ans = 0;
        for(int n: nums)
        {
            sum += n;
            if(hp.containsKey(sum - goal))
                ans += hp.get(sum - goal);
            hp.put(sum, hp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}