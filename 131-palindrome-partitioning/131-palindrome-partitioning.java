class Solution 
{
    public List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> partition(String s) 
    {
        solve(0, s, new ArrayList<>());
        return ans;
    }
    
    public void solve(int i, String s, List<String> list)
    {
        if(i == s.length())
            ans.add(new ArrayList<>(list));
        for(int j=i; j<s.length(); j++)
        {
            if(isPalindrome(s, i, j))
            {
                list.add(s.substring(i, j + 1));
                solve(j + 1, s, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int i, int j)
    {
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}