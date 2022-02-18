// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}// } Driver Code Ends


class Solution
{
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        Set<Integer> hs = new HashSet<>();
        for(int i: A)
            hs.add(i);
        ArrayList<Integer> a = new ArrayList<>();
        for(int i: hs)
            a.add(i);
        Collections.sort(a);
        backtrack(0, a, B, new ArrayList<>());
        return ans;
    }
    
    public void backtrack(int i, ArrayList<Integer> a, int k, ArrayList<Integer> l)
    {
        if(k < 0)
            return;
        if(k == 0)
        {
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int j=i; j<a.size(); j++)
        {
            l.add(a.get(j));
            backtrack(j, a, k-a.get(j), l);
            l.remove(l.size()-1);
        }
    }
}