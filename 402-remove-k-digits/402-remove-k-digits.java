class Solution 
{
    public String removeKdigits(String num, int k)
    {
        Stack<Character> s = new Stack<>();
        for(char c: num.toCharArray())
        {
            while(!s.isEmpty() && k > 0 && s.peek() > c)
            {
                k--;
                s.pop();
            }
            s.push(c);
        }
        System.out.println(s);
        while(k > 0)
        {
            if(!s.isEmpty())
                s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty())
            sb.append(s.pop());
        sb.reverse();
        int i = 0, n = sb.length();
        while(i < n && sb.charAt(i) == '0')
            i++;
        if(sb.toString().substring(i).isEmpty())
            return "0";
        return sb.toString().substring(i);
    }
}