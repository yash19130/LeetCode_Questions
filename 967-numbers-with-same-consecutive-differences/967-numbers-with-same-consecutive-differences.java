class Solution 
{
    public int[] numsSameConsecDiff(int n, int k) 
    {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++)
            solve(i, n, k, i, list);
        return list.stream().mapToInt(i->i).toArray();
    }
    
    public void solve(int num, int n, int k, int lastDigit, List<Integer> list)
    {
        if(n == 1)
        {
            list.add(num);
            return;
        }
        if(lastDigit + k <= 9)
            solve((num * 10) + (lastDigit + k), n - 1, k, lastDigit + k, list);
        if(lastDigit - k >= 0 && k != 0)
            solve((num * 10) + (lastDigit - k), n - 1, k, lastDigit - k, list);
    }
}