class Solution 
{
    public int minimumOperations(int[] nums) 
    {
        Map<Integer, Integer> odd = new HashMap<>();
        Map<Integer, Integer> even = new HashMap<>();
        int e = 0, o = 0;
        int n = nums.length;
        if(n == 1)
            return 0;
        for(int i=0; i<n; i++)
        {
            if(i % 2 == 0)
            {
                e++;
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            }
            else
            {
                o++;
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            }
        }
        int maxOdd[] = {0, 0};
        Queue<Map.Entry<Integer, Integer>> pqO = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer, Integer> i: odd.entrySet())
            pqO.add(i);
        Queue<Map.Entry<Integer, Integer>> pqE = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer, Integer> i: even.entrySet())
            pqE.add(i);
        Map.Entry<Integer, Integer> e1 = null, e2 = null;
        if(!pqO.isEmpty() && !pqE.isEmpty() && pqO.peek().getKey() == pqE.peek().getKey())
             e1 = pqO.remove();
        if(pqO.isEmpty())
        {
            e2 = pqE.remove();
            if(pqE.isEmpty())
                return o;
            return e - pqE.peek().getValue();
        }
        int val1 = (e - pqE.peek().getValue()) + (o - pqO.peek().getValue());
        if(e1 != null)
            pqO.add(e1);
        if(e2 != null)
            pqE.offer(e2);
        if(!pqO.isEmpty() && !pqE.isEmpty() && pqO.peek().getKey() == pqE.peek().getKey())
            pqE.remove();
        if(pqE.isEmpty())
        {
            pqO.remove();
            if(pqO.isEmpty())
                return e;
            return o - pqO.peek().getValue();
        }
        int val2 = (e - pqE.peek().getValue()) + (o - pqO.peek().getValue());
        return Math.min(val1, val2);
    }
}