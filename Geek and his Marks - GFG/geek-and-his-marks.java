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
            int x = sc.nextInt();
            int greater = 0;
            for(int i=0; i<n; i++)
                if(sc.nextInt() > x)
                    greater++;
            System.out.println(greater);
        }
	}
}