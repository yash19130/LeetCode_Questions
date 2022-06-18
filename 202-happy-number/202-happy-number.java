class Solution 
{
    public boolean isHappy(int n) 
    {
        Set<Integer> vals = new HashSet<>();
        while(n != 1)
        {
            int num = 0;
            while(n != 0)
            {
                int digit = n % 10;
                num += (digit * digit);
                n /= 10;
            }
            if(vals.contains(num))
                return false;
            vals.add(num);
            n = num;
        }
        return true;
    }
}