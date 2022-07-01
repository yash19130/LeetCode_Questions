class Solution 
{
    public void sortColors(int[] a) 
    {
        int n = a.length;
        int z = 0, t = n - 1;
        for(int i=0; i<=t; i++)
        {
            if(a[i] == 0)
            {
                if(z < i)
                {
                    a[i--] = a[z];
                    a[z++] = 0;
                }
            }
            else if(a[i] == 2)
            {
                if(i < t)
                {
                    a[i--] = a[t];
                    a[t--] = 2;
                }
            }
        }
    }
}