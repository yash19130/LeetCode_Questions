class Solution 
{
    public int removeDuplicates(int[] a) 
    {
        int n = a.length;
        int i = 0, k = 0;
        while(i < n)
        {
            int j = i+1;
            while(j < n && a[i] == a[j])
                j++;
            if(j - i > 1)
                a[k++] = a[i];
            a[k++] = a[i];
            i = j;
        }
        return k;
    }
}