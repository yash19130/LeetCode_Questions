class Solution 
{
    public List<List<Integer>> groupThePeople(int[] a) 
    {
        int n = a.length;
        Map<Integer, List<Integer>> hp = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            if(hp.containsKey(a[i]))
                hp.get(a[i]).add(i);
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hp.put(a[i], list);
            }
        }
        List<List<Integer>> groups = new ArrayList<>();
        for(int k: hp.keySet())
        {
            List<Integer> list = new ArrayList<>();
            for(int p: hp.get(k))
            {
                list.add(p);
                if(list.size() == k)
                {
                    groups.add(new ArrayList<>(list));
                    list.clear();
                }
            }
        }
        return groups;
    }
}