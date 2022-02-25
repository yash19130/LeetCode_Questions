class Solution 
{
    public int compareVersion(String v1, String v2) 
    {
        String[] s1 = v1.split("\\.");
        String[] s2 = v2.split("\\.");
        int i = 0, n = Math.min(s1.length, s2.length);
        while(i < n)
        {
            long a = Long.parseLong(s1[i]);
            long b = Long.parseLong(s2[i]);
            if(a == b)
            {
                i++;
                continue;
            }
            if(a < b)
                return -1;
            return 1;
        }
        while(i < s1.length)
        {
            long a = Long.parseLong(s1[i]);
            long b = 0L;
            if(a == b)
            {
                i++;
                continue;
            }
            if(a < b)
                return -1;
            return 1;
        }
        while(i < s2.length)
        {
            long a = 0L;
            long b = Long.parseLong(s2[i]);
            if(a == b)
            {
                i++;
                continue;
            }
            if(a < b)
                return -1;
            return 1;
        }
        return 0;
    }
}