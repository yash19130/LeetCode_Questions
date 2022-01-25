// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    for(int i=0; i<n; i++)
                        {
                            int x = sc.nextInt();
                            arr.add(x);
                        }
                    int k = sc.nextInt();
                    
                    Solution obj = new Solution();
                    res = obj.TopK(arr,k);
                    
                    for(int i=0; i<res.size();i++)
                        {
                            System.out.print(res.get(i) + " ");
                        }
                    System.out.println();    
                    
                        
                }
        }
}// } Driver Code Ends


class Solution
{
    ArrayList<Integer> TopK(ArrayList<Integer> array, int k)
    {
        Map<Integer, Integer> hp = new HashMap<>();
        for(int i: array)
        {
            if(hp.containsKey(i))
                hp.put(i, hp.get(i)+1);
            else
                hp.put(i, 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq 
        = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>()
        {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2)
            {
                if(e1.getValue() == e2.getValue())
                    return e2.getKey() - e1.getKey();
                return e2.getValue() - e1.getValue();
            }
        });
        
        for(Map.Entry<Integer, Integer> e: hp.entrySet())
            pq.add(e);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<k; i++)
            ans.add(pq.remove().getKey());
        return ans;
    }
}
