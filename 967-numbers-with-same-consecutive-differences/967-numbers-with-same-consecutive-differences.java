class Solution 
{
    public int[] numsSameConsecDiff(int n, int k) 
    {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++)
            solve(i + "", n, k, list);
        return list.stream().mapToInt(i->i).toArray();
    }
    
    public void solve(String s, int n, int k, List<Integer> list)
    {
        if(s.length() == n)
        {
            int num = Integer.parseInt(new String(s));
            if(!list.contains(num))
                list.add(num);
            return;
        }
        char last = s.charAt(s.length() - 1);
        if(last + k <= '9')
            solve(s + (char) (last + k), n, k, list);
        if(last - k >= '0')
            solve(s + (char) (last - k), n, k, list);
    }
}