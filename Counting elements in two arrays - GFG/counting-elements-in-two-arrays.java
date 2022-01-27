// { Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}// } Driver Code Ends



// Complete the function given below
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr2);
        for(int i: arr1)
            list.add(search(arr2, n, i));
        return list;
    }
    
    public static int search(int[] a, int n, int k)
    {
        int beg = 0, end = n-1;
        int ans = 0;
        while(beg <= end)
        {
            int mid = beg + (end-beg)/2;
            if(a[mid] <= k)
            {
                ans = mid+1;
                beg = mid+1;
            }
            else
                end = mid-1;
        }
        return ans;
    }
}
