class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        int n = nums.length;
        Map<Integer, Integer> hp = new HashMap<>();
        int sum = 0, count = 0;
        hp.put(0, 1);
        for(int i=0; i<n; i++)
        {
            sum += nums[i];
            if(hp.containsKey(sum-k))
                count += hp.get(sum-k);
            if(hp.containsKey(sum))
                hp.put(sum, hp.get(sum)+1);
            else
                hp.put(sum, 1);
        }
        return count;
    }
}