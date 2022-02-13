class Solution 
{
    public List<List<Integer>> subsets(int[] a) 
    {
        List<List<Integer>> subs = new ArrayList<>();
        backtrack(subs, new ArrayList<>(), a, 0);
        return subs;
    }
    
    public void backtrack(List<List<Integer>> subs, List<Integer> temp, int[] a, int beg)
    {
        subs.add(new ArrayList<>(temp));
        for(int i=beg; i<a.length; i++)
        {
            temp.add(a[i]);
            backtrack(subs, temp, a, i+1);
            temp.remove(temp.size()-1);
        }
    }
}