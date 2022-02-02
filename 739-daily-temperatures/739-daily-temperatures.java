class Solution 
{
    static class pair
    {
        int e, i;
        pair(int e, int i)
        {
            this.e = e;
            this.i = i;
        }
    }
    
    public int[] dailyTemperatures(int[] t) 
    {
        int n = t.length;
        int[] ans = new int[n];
        Stack<pair> s = new Stack<>();
        ans[n-1] = 0;
        s.push(new pair(t[n-1], n-1));
        for(int i=n-2; i>=0; i--)
        {
            while(!s.isEmpty() && s.peek().e <= t[i])
                s.pop();
            ans[i] = (s.isEmpty()) ? 0 : s.peek().i - i;
            s.push(new pair(t[i], i));
        }
        return ans;
    }
}