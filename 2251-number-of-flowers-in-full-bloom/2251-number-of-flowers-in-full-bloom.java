class Solution 
{
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) 
    {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for(int f[]: flowers)
        {
            start.add(f[0]);
            end.add(f[1]);
        }
        Collections.sort(start);
        Collections.sort(end);
        int n = persons.length;
        int[][] mapping = new int[n][2];
        for(int i=0; i<n; i++)
            mapping[i] = new int[]{persons[i], i};
        Arrays.sort(mapping, (a, b) -> (a[0] - b[0]));
        int[] ans = new int[n];
        int curBloom = 0;
        int j = 0, k = 0;
        int flowerSize = flowers.length;
        for(int i=0; i<n; i++)
        {
            while(j < flowerSize && mapping[i][0] >= start.get(j))
            {
                curBloom++;
                j++;
            }
            while(k < flowerSize && mapping[i][0] > end.get(k))
            {
                curBloom--;
                k++;
            }
            ans[mapping[i][1]] = curBloom;
        }
        return ans;
    }
}