// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


class Solution
{
    static boolean boundary = false;
    
    static char[][] fill(int n, int m, char board[][])
    {
        boolean[][] vis = new boolean[n][m];
        List<List<Integer>> positions = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(!vis[i][j])
                {
                    List<List<Integer>> cur = new ArrayList<>();
                    boundary = false;
                    dfs(i, j, board, vis, cur);
                    if(!boundary)
                        positions.addAll(cur);
                }
            }
        }
        for(List<Integer> a: positions)
        {
            int i = a.get(0);
            int j = a.get(1);
            board[i][j] = 'X';
        }
        return board;
    }
    
    static void dfs(int i, int j, char[][] board, boolean[][] vis, 
                        List<List<Integer>> cur)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
        {
            boundary = true;
            return;
        }
        if(vis[i][j] || board[i][j]=='X')
            return;
        vis[i][j] = true;
        List<Integer> pos = new ArrayList<>();
        pos.add(i);
        pos.add(j);
        cur.add(pos);
        
        dfs(i+1, j, board, vis, cur);
        dfs(i-1, j, board, vis, cur);
        dfs(i, j+1, board, vis, cur);
        dfs(i, j-1, board, vis, cur);
    }
}