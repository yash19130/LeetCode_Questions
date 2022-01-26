// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int a[], int n)
    {
        HashMap<Integer, Integer> hp = new HashMap<>();
        int ans = 0, sum = 0;
        for(int i=0; i<n; i++)
        {
            sum += a[i];
            if(sum == 0)
                ans = i+1;
            if(hp.containsKey(sum))
                ans = Math.max(ans, i - hp.get(sum));
            else
                hp.put(sum, i);
        }
        return ans;
    }
}