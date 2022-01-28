// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution 
{
    String reverseWords(String s)
    {
        Stack<String> st = new Stack<>();
        int i = 0, n = s.length();
        while(i < n)
        {
            int j = i+1;
            while(j < n && s.charAt(j) != '.')
                j++;
            st.push(s.substring(i, j));
            i = j+1;
        }
        StringBuilder sb = new StringBuilder();
        if(!st.isEmpty())
            sb.append(st.pop());
        while(!st.isEmpty())
        {
            sb.append('.');
            sb.append(st.pop());
        }
        return sb.toString();
    }
}