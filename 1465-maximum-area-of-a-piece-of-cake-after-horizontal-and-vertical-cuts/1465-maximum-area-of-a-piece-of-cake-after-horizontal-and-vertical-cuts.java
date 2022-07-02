class Solution 
{
    public int maxArea(int h, int w, int[] horizontal, int[] vertical) 
    {
        Arrays.sort(horizontal);
        Arrays.sort(vertical);
        int vs = vertical.length, hs = horizontal.length;
        long height = Math.max(vertical[0], w - vertical[vs - 1]);
        for(int i=1; i<vs; i++)
        {
            height = Math.max(height, vertical[i] - vertical[i - 1]);
        }
        long width = Math.max(horizontal[0], h - horizontal[hs - 1]);
        for(int i=1; i<hs; i++)
        {
            width = Math.max(width, horizontal[i] - horizontal[i - 1]);
        }
        long mod = (long) (1e9 + 7);
        return (int) (((height % mod) * (width % mod)) % mod);
    }
}