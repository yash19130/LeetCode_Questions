class Solution 
{
    public int fourSumCount(int[] a1, int[] a2, int[] a3, int[] a4)
    {
        int n = a1.length;
        int count = 0;
        Map<Integer, Integer> hp = new HashMap<>();
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                hp.put(a1[i] + a2[j], hp.getOrDefault(a1[i] + a2[j], 0) + 1);
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                int sum = a3[i] + a4[j];
                if(hp.containsKey(-sum))
                    count += hp.get(-sum);
            }
        }
        return count;
    }
}