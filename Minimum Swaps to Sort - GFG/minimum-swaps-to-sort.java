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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends


class Solution
{
    public int minSwaps(int a[])
    {
        int n = a.length;
        int swaps = 0;
        ArrayList<pair> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(new pair(a[i], i));
        Collections.sort(arr);
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++)
        {
            if(vis[i] || arr.get(i).getIndex() == i)
                continue;
            int cycle = 0;
            int j = i;
            while(!vis[j])
            {
                vis[j] = true;
                j = arr.get(j).getIndex();
                cycle++;
            }
            if(cycle>0)
                swaps += cycle-1;
        }
        return swaps;
    }
}

class pair implements Comparable<pair>
{
    private int value, index;
    public pair(int v, int i)
    {
        this.value = v;
        this.index = i;
    }

    @Override
    public int compareTo(pair p)
    {
        return this.value - p.value;
    }

    public int getIndex() 
    {
        return index;
    }
}