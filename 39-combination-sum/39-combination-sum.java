class Solution 
{
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] a, int target) 
    {
        Arrays.sort(a);
        solve(0, a, target, 0, new ArrayList<>());
        return ans;
    }
    
    public void solve(int i, int a[], int target, int sum, List<Integer> l)
    {
        if(sum > target)
            return;
        if(sum == target)
            ans.add(new ArrayList<>(l));
        for(int j=i; j<a.length; j++)
        {
            l.add(a[j]);
            solve(j, a, target, sum + a[j], l);
            l.remove(l.size()-1);
        }
    }
}