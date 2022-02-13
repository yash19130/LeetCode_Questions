class Solution 
{
    Map<Integer, List<Integer>> hp;
    
    public Solution(int[] nums) 
    {
        this.hp = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            if(hp.containsKey(nums[i]))
                hp.get(nums[i]).add(i);
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hp.put(nums[i], list);
            }
        }
    }
    
    public int pick(int target) 
    {
        List<Integer> list = hp.get(target);
        int idx = new Random().nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */