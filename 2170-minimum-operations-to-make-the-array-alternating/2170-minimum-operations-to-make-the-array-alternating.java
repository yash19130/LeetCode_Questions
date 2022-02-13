class Solution 
{
    public int minimumOperations(int[] nums) 
    {
        int n = nums.length;
        Map<Integer, Integer> odd = new HashMap<>();
        Map<Integer, Integer> even = new HashMap<>();
        if(n == 1)
            return 0;
        for(int i=0; i<n; i++)
        {
            if(i % 2 == 0)
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            else
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
        }
        int oddMax = 0, oddMaxVal = 0, OddMaxS = 0;
        for(int k: odd.keySet())
        {
            if(odd.get(k) > oddMaxVal)
            {
                OddMaxS = oddMaxVal;
                oddMax = k;
                oddMaxVal = odd.get(k);
            }
            else if(odd.get(k) > OddMaxS)
                OddMaxS = odd.get(k);
        }
        int evenMax = 0, evenMaxVal = 0, EvenMaxS = 0;
        for(int k: even.keySet())
        {
            if(even.get(k) > evenMaxVal)
            {
                EvenMaxS = evenMaxVal;
                evenMax = k;
                evenMaxVal = even.get(k);
            }
            else if(even.get(k) > EvenMaxS)
                EvenMaxS = even.get(k);
        }
        if(oddMax != evenMax)
            return n - oddMaxVal - evenMaxVal;
        return Math.min(n - oddMaxVal - EvenMaxS, n - evenMaxVal - OddMaxS);
    }
}