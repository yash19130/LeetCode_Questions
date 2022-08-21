class Solution 
{
    public List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }
    
    public void backtrack(int i, int[] a, List<Integer> l)
    {
        ans.add(new ArrayList<>(l));
        for(int j=i; j<a.length; j++)
        {
            if(j > i && a[j] == a[j - 1])
                continue;
            l.add(a[j]);
            backtrack(j+1, a, l);
            l.remove(l.size()-1);
        }
    }
}