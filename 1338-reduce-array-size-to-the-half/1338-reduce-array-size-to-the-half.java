class Solution 
{
    public int minSetSize(int[] arr) 
    {
        int n = arr.length, half = arr.length/2;
        Map<Integer, Integer> hp = new HashMap<>();
        for(int i: arr)
            hp.put(i, hp.getOrDefault(i, 0) + 1);
        List<Integer> list = new ArrayList<>(hp.values());
        Collections.sort(list, Collections.reverseOrder());
        int ans = 0;
        for(int i: list)
        {
            n -= i;
            ans++;
            if(n <= half)
                break;
        }
        return ans;
    }
}