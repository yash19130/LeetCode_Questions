// { Driver Code Starts
//saksham raj seth
import java.util.*;
class Anagrams{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			String s1=sc.next();
			GfG g=new GfG();
			System.out.println(g.remAnagrams(s,s1));
		}
	}
}// } Driver Code Ends


class GfG
{
	public int remAnagrams(String s1, String s2)
    {
        int[] cnt = new int[26];
        for(char c: s1.toCharArray())
            cnt[c - 'a']++;
        for(char c: s2.toCharArray())
            cnt[c - 'a']--;
        int ans = 0;
        for(int i=0; i<26; i++)
            ans += Math.abs(cnt[i]);
        return ans;
    }
}