class Solution 
{
    public int mostFrequentEven(int[] nums) 
    {
        Map<Integer, Integer> hp = new HashMap<>();
        int count = 0;
        for(int n: nums)
        {
            if((n & 1) == 0)
            {
                hp.put(n, hp.getOrDefault(n, 0) + 1);
                count = Math.max(count, hp.get(n));
            }
        }
        if(hp.isEmpty())
            return -1;
        int ans = Integer.MAX_VALUE;
        for(int n: hp.keySet())
        {
            if(hp.get(n) == count && n < ans)
                ans = n;
        }
        return ans;
    }
}