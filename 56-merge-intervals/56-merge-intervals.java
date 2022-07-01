class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int i = 0, n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        while(i < n)
        {
            int j = i + 1;
            int cur = intervals[i][1];
            while(j < n && intervals[j][0] <= cur)
            {
                cur = Math.max(cur, intervals[j][1]);
                j++;
            }
            ans.add(new int[]{intervals[i][0], cur});
            i = j;
        }
        int[][] ansArray = new int[ans.size()][2];
        for(i=0; i<ans.size(); i++)
            ansArray[i] = ans.get(i);
        return ansArray;
    }
}