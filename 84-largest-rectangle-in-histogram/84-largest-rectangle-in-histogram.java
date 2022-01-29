class Solution 
{
    public int largestRectangleArea(int[] h) 
    {
        Stack<Integer> s = new Stack<>();
        int ans = 0, n = h.length;
        for (int i=0; i<=n; i++) 
        {
            while (!s.isEmpty() && (i == h.length || h[s.peek()] > h[i])) 
            {
                int prev = s.pop();
                if (s.isEmpty())
                    ans = Math.max(ans, h[prev] * i);
                else
                    ans = Math.max(ans, h[prev] * (i - s.peek() - 1));
            }
            s.push(i);
        }
        return ans;
    }
}