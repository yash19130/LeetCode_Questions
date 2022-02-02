class Solution 
{
    public int[] dailyTemperatures(int[] t) 
    {
        int n = t.length;
        int[] ans = new int[n];
        Stack<int[]> s = new Stack<>();
        ans[n-1] = 0;
        s.push(new int[]{t[n-1], n-1});
        for(int i=n-2; i>=0; i--)
        {
            while(!s.isEmpty() && s.peek()[0] <= t[i])
                s.pop();
            ans[i] = (s.isEmpty()) ? 0 : s.peek()[1] - i;
            s.push(new int[]{t[i], i});
        }
        return ans;
    }
}