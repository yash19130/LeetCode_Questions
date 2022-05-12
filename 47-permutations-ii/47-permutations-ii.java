class Solution 
{
    public Set<List<Integer>> hs = new HashSet<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        boolean used[] = new boolean[nums.length];
        permute(new ArrayList<Integer>(), nums, used);
        return new ArrayList(hs);
    }
    
    public void permute(List<Integer> permutation, int []nums,  boolean used[]){
                
        if(permutation.size() == nums.length)
        {
            hs.add(new ArrayList<Integer>(permutation));
            return;
        }

        for(int i=0; i<nums.length; i++)
        {
            if(used[i])
                continue;
            permutation.add(nums[i]);
            used[i] = true;
            permute(permutation, nums, used);
            permutation.remove(permutation.size()-1);
            used[i] =false;
        } 
    }
}