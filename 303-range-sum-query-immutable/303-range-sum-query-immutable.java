class NumArray 
{
    public List<Integer> prefix;
    
    public NumArray(int[] nums) 
    {
        this.prefix = new ArrayList<>();
        prefix.add(nums[0]);
        for(int i = 1; i < nums.length; i++)
            prefix.add(prefix.get(i - 1) + nums[i]);
    }
    
    public int sumRange(int left, int right) 
    {
        int l = left > 0 ? prefix.get(left - 1) : 0;
        int r = prefix.get(right);
        return r - l;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */