class Solution 
{
    public int majorityElement(int[] a) 
    {
        int n = a.length;
        int maj = a[0];
        int count = 1;
        for(int i=1; i<n; i++)
        {
            if(a[i] == maj)
                count++;
            else
                count--;
            if(count == 0)
            {
                maj = a[i];
                count = 1;
            }
        }
        return maj;
    }
}