class FindSumPairs 
{
    int[] a, b;
    Map<Integer, Integer> hp;
    public FindSumPairs(int[] nums1, int[] nums2) 
    {
        this.a = nums1;
        this.b = nums2;
        this.hp = new HashMap<>();
        for(int i: nums2)
            hp.put(i, hp.getOrDefault(i, 0) + 1);
    }
    
    public void add(int index, int val) 
    {
        hp.put(b[index], hp.get(b[index]) - 1);
        if(hp.get(b[index]) == 0)
            hp.remove(b[index]);
        this.b[index] += val;
        hp.put(b[index], hp.getOrDefault(b[index], 0) + 1);
    }
    
    public int count(int tot) 
    {
        int c = 0;
        for(int i: a)
        {
            if(hp.containsKey(tot - i))
                c += hp.get(tot - i);
        }
        return c;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */