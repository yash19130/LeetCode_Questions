// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} // } Driver Code Ends




class Solution 
{
    static int longestSubsequence(int n, int a[])
    {
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for(int i=1; i<n; i++)
        {
            if(a[i] > list.get(list.size() - 1))
            {    
                list.add(a[i]);
                continue;
            }
            int beg = 0, end = list.size() - 1;
            int index = 0;
            while(beg <= end)
            {
                int mid = beg + (end - beg) / 2;
                if(list.get(mid) > a[i])
                {
                    index = mid;
                    end = mid - 1;
                }
                else
                    beg = mid + 1;
            }
            list.set(index, a[i]);
        }
        return list.size();
    }
} 