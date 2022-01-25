class Solution 
{
    public boolean validMountainArray(int[] a) 
    {
        int n = a.length;
        if(n < 3)
            return false;
        int i = 0, j = i+1;
        while(j<n && a[j] > a[i])
        {
            i = j;
            j++;
        }
        if(j == n || j == 1)
            return false;
        while(j<n && a[j] < a[i])
        {
            i = j;
            j++;
        }
        return j == n;
    }
}