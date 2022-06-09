class Solution 
{
    public int kthSmallest(int[][] matrix, int k) 
    {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int n = matrix.length;
        for(int i=0; i<n; i++)
            pq.add(new int[]{matrix[i][0], i, 0});
        while(k-->1)
        {
            int[] e = pq.poll();
            int i = e[1], j = e[2] + 1;
            if(j < n)
                pq.add(new int[]{matrix[i][j], i, j});
        }
        return pq.peek()[0];
    }
}