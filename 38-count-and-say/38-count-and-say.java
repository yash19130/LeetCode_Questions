class Solution 
{
    public String countAndSay(int n) 
    {
        String cur = "1";
        for(int k=2; k<=n; k++)
        {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while(i < cur.length())
            {
                int j = i + 1;
                while(j < cur.length() && cur.charAt(i) == cur.charAt(j))
                    j++;
                sb.append(j - i);
                sb.append(cur.charAt(i));
                i = j;
            }
            cur = sb.toString();
        }
        return cur;
    }
}