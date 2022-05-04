class Solution 
{
    public int maxOperations(int[] nums, int k) 
    {
        Map<Integer, Integer> hp = new HashMap<>();
        for(int n: nums)
            hp.put(n, hp.getOrDefault(n, 0) + 1);
        int same = 0;
        if(k % 2 == 0 && hp.containsKey(k / 2))
        {
            same += hp.get(k / 2) / 2;
            hp.remove(k / 2);
        }
        int ans = 0;
        for(int i: hp.keySet())
        {
            if(hp.containsKey(k - i))
                ans += Math.min(hp.get(i), hp.get(k - i));
        }
        return same + ans / 2;
    }
}