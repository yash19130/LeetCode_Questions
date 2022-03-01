// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            int numbers[]= new int[N];
            for(int i = 0; i < N; i++)
                numbers[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countPairs(N, X, numbers); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


class Solution 
{ 
    long countPairs(int N, int X, int numbers[]) 
    {
        int pairs = 0;
        
        Map<Integer, Integer> hp = new HashMap<>();
        for(int num: numbers)
            hp.put(num, hp.getOrDefault(num, 0) + 1);
        for(int k: hp.keySet())
        {
            int num = X, cur = k;
            if(num <= cur)
                continue;
            while(cur != 0)
            {
                if(cur % 10 != num % 10)
                    break;
                cur /= 10;
                num /= 10;
            }
            if(hp.containsKey(num) && (num + "" + k).equals(X + ""))
            {
                if(num == k)
                    pairs += hp.get(k) * (hp.get(num) - 1);
                else
                    pairs += hp.get(k) * hp.get(num);
            }
        }
        return pairs;
    }
} 
