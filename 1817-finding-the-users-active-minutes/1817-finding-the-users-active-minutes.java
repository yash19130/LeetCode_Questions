class Solution 
{
    public int[] findingUsersActiveMinutes(int[][] logs, int k) 
    {
        int ans[] = new int[k];
        Map<Integer, Set<Integer>> hp = new HashMap<>();
        for(int[] log: logs)
        {
            int key = log[0], val = log[1];
            if(hp.containsKey(key))
                hp.get(key).add(val);
            else
            {
                Set<Integer> hs = new HashSet<>();
                hs.add(val);
                hp.put(key, hs);
            }
        }
        for(Set<Integer> hs: hp.values())
            ans[hs.size()-1]++;
        return ans;
    }
}