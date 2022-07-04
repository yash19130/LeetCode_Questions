class Solution 
{
    public int compress(char[] chars) 
    {
        int i = 0, k = 0, n = chars.length;
        int ans = 0;
        while(i < n)
        {
            int j = i + 1;
            while(j < n && chars[i] == chars[j])
                j++;
            chars[k++] = chars[i];
            if(j - i == 1)
                ans++;
            else
            {
                String s = (j - i) + "";
                ans += s.length() + 1;
                for(char c: s.toCharArray())
                    chars[k++] = c;
            }
            i = j;
        }
        return ans;
    }
}