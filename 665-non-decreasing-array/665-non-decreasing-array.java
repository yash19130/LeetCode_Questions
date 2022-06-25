class Solution 
{
    public boolean isSorted(int[] a)
    {
        int n = a.length;
        for(int i=0; i<n-1; i++)
            if(a[i] > a[i + 1])
                return false;
        return true;
    }
    
    public boolean checkPossibility(int[] a) 
    {
        int n = a.length;
        int[] b = new int[n];
        int[] c = new int[n];
        for(int i=0; i<n; i++)
            b[i] = c[i] = a[i];
        boolean changed = false;
        for(int i=0; i<n-1; i++)
        {
            if(a[i] > a[i + 1] && !changed)
            {
                b[i] = a[i + 1];
                c[i + 1] = a[i];
                changed = true;
            }
        }
        return isSorted(b) || isSorted(c);
    }
}