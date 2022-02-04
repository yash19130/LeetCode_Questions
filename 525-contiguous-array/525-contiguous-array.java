class Solution 
{
    public int findMaxLength(int[] nums) 
    {
        int n = nums.length;
        Map<Integer, Integer> hp = new HashMap<>();
        int sum = 0, maxLen = 0;
        for(int i=0; i<n; i++)
        {
            if(nums[i] == 0)
                sum--;
            else
                sum++;
            if(sum == 0)
                maxLen = i+1;
            if(hp.containsKey(sum))
                maxLen = Math.max(maxLen, i - hp.get(sum));
            else
                hp.put(sum, i);
        }
        return maxLen;
    }
}