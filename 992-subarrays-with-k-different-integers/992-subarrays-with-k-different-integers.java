class Solution 
{
    public int subarraysWithKDistinct(int[] a, int k) 
    {
        return solve(a, k) - solve(a, k - 1);
    }
    
    public int solve(int[] a, int k)
    {
        int n = a.length;
        int i = 0, j = 0;
        Map<Integer, Integer> hp = new HashMap<>();
        int ans = 0;
        while(j < n)
        {
            hp.put(a[j], hp.getOrDefault(a[j], 0) + 1);
            while(hp.size() > k)
            {
                int c = a[i++];
                hp.put(c, hp.get(c) - 1);
                if(hp.get(c) == 0)
                {
                    hp.remove(c);
                    break;
                }
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}