class Solution 
{
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) 
    {
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }
    
    public void backtrack(int i, int[] a, List<Integer> l)
    {
        ans.add(new ArrayList<>(l));
        for(int j=i; j<a.length; j++)
        {
            l.add(a[j]);
            backtrack(j+1, a, l);
            l.remove(l.size()-1);
        }
    }
}