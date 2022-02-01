import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0)
	    {
	        int n = sc.nextInt();
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
	        Queue<Integer> q = new LinkedList<>();
	        Stack<Integer> s = new Stack<>();
	        while(n-->0)
	        {
	            int query = sc.nextInt();
	            int x = sc.nextInt();
	            if(query == 1)
	                pq.add(x);
	            else if(query == 2)
	                q.add(x);
	            else
	                s.push(x);
	        }
	        while(!pq.isEmpty())
	            System.out.print(pq.remove() + " ");
	        while(!q.isEmpty())
	            System.out.print(q.poll() + " ");
	        while(!s.isEmpty())
	            System.out.print(s.pop() + " ");
	        System.out.println();
	    }
	}
}