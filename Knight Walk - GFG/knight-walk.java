// { Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[N][N];
        q.add(new int[]{KnightPos[0]-1, KnightPos[1]-1, 0});
        vis[KnightPos[0]-1][KnightPos[1]-1] = true;
        while(!q.isEmpty())
        {
            int x = q.peek()[0], y = q.peek()[1], steps = q.peek()[2];
            q.poll();
            if(x == TargetPos[0]-1 && y == TargetPos[1]-1)
                return steps;
            int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
            int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
            for(int k=0; k<8; k++)
            {
                int i = x + dx[k];
                int j = y + dy[k];
                if(i>=0 && i<N && j>=0 && j<N && !vis[i][j])
                {
                    vis[i][j] = true;
                    q.add(new int[]{i, j, steps+1});
                }
            }
        }
        return -1;
    }
}