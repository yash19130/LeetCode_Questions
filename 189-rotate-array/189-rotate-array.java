class Solution 
{
    public void rotate(int[] a, int k) 
    {
        int n = a.length;
        k %= n;
        for(int i=0; i<(n-k)/2; i++)
        {
            int temp = a[i];
            a[i] = a[n-k-i-1];
            a[n-k-i-1] = temp;
        }
        for(int i=0; i<n/2; i++)
        {
            int temp = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = temp;
        }
        for(int i=0; i<k/2; i++)
        {
            int temp = a[i];
            a[i] = a[k-i-1];
            a[k-i-1] = temp;
        }
    }
}