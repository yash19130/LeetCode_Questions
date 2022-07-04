class Solution 
{
    public int findLHS(int[] a) 
    {
        Map<Integer, Integer> hp = new HashMap<>();
        for(int i: a)
            hp.put(i, hp.getOrDefault(i, 0) + 1);
        int max = 0;
        for(int k: hp.keySet())
        {
            if(hp.containsKey(k - 1))
                max = Math.max(max, hp.get(k) + hp.get(k - 1));
        }
        return max;
    }
}