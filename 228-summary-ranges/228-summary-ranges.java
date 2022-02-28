class Solution 
{
    public List<String> summaryRanges(int[] a) 
    {
        int i = 0, n = a.length;
        List<String> ranges = new ArrayList<>();
        while(i < n)
        {
            int j = i+1;
            while(j < n && a[j] - a[j-1] == 1)
                j++;
            if(j == i+1)
                ranges.add(a[i] + "");
            else
                ranges.add(a[i] + "->" + a[j-1]);
            i = j;
        }
        return ranges;
    }
}