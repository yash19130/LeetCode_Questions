class Solution 
{
    static class pair
    {
        char ch;
        int i;
        pair(char ch, int i)
        {
            this.ch = ch;
            this.i = i;
        }
    }
    
    public String solve(String s, int start, int add, char c1, char c2)
    {
        int n = s.length();
        Stack<pair> st = new Stack<>();
        Set<Integer> hs = new HashSet<>();
        int i = start;
        while(i >= 0 && i < n)
        {
            char c = s.charAt(i);
            if(c == c1)
            {
                hs.add(i);
                st.push(new pair(c1, i));
            }
            if(c == c2)
            {
                hs.add(i);
                if(!st.isEmpty() && st.peek().ch == c1)
                {
                    hs.remove(i);
                    hs.remove(st.pop().i);
                }
            }
            i += add;
        }
        StringBuilder sb = new StringBuilder();
        for(i=0; i<n; i++)
            if(!hs.contains(i))
                sb.append(s.charAt(i));
        return sb.toString();
    }
    
    public String minRemoveToMakeValid(String s) 
    {
        String s1 = solve(s, 0, 1, '(', ')');
        String s2 = solve(s, s.length()-1, -1, ')', '(');
        if(s1.length() > s2.length())
            return s1;
        return s2;
    }
}