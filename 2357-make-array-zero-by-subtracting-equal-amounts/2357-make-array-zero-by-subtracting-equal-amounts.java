class Solution 
{
    public int minimumOperations(int[] nums) 
    {
        Set<Integer> hs = new HashSet<>();
        for(int n: nums)
            if(n != 0)
                hs.add(n);
        return hs.size();
    }
}