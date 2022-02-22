// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

 // } Driver Code Ends


class Solution
{
    public boolean isPrime(int n)
    {
        if(n == 2)
            return true;
        if(n % 2 == 0)
            return false;
        for(int i=3; i*i<=n; i+=2)
            if(n % i == 0)
                return false;
        return true;
    }
    
    int solve(int num1, int num2)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{num1, 0});
        Set<Integer> vis = new HashSet<>();
        while(!q.isEmpty())
        {
            int n = q.peek()[0], dist = q.peek()[1];
            q.poll();
            if(n == num2)
                return dist;
            int[] digits = {(n/1000), (n/100)%10, (n/10)%10 , n%10};
            for(int i=0; i<4; i++)
            {
                int org = digits[i];
                for(int j=0; j<=9; j++)
                {
                    if(i == 0 && j == 0)
                        continue;
                    digits[i] = j;
                    int num = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
                    if(isPrime(num) && !vis.contains(num))
                    {
                        vis.add(num);
                        q.add(new int[]{num, dist+1});
                    }
                }
                digits[i] = org;
            }
        }
        return 0;
    }
}

// { Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int Num1=Integer.parseInt(input_line[0]);
            int Num2=Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.solve(Num1,Num2));
        }
    }
}  // } Driver Code Ends