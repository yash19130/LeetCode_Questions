class Solution 
{
    public int[] closestRoom(int[][] rooms, int[][] queries) 
    {
        int n = queries.length;
        int[][] queriesss = new int[n][3];
        for(int i=0; i<n; i++)
            queriesss[i] = new int[]{queries[i][0], queries[i][1], i};
        Arrays.sort(rooms, (a, b) -> (a[1] - b[1]));
        int j = rooms.length - 1;
        Arrays.sort(queriesss, (a, b) -> (b[1] - a[1]));
        TreeSet<Integer> set = new TreeSet<>();
        int[] ans = new int[n];
        for(int[] q: queriesss)
        {
            while(j >= 0 && rooms[j][1] >= q[1])
                set.add(rooms[j--][0]);
            int i = q[2];
            Integer f = set.floor(q[0]);
            Integer s = set.ceiling(q[0]);
            if(f != null && s != null)
            {
                if(Math.abs(f - q[0]) <= Math.abs(s - q[0]))
                    ans[i] = f;
                else
                    ans[i] = s;
            }
            else if(f != null)
                ans[i] = f;
            else if(s != null)
                ans[i] = s;
            else
                ans[i] = -1;
        }
        return ans;
    }
}