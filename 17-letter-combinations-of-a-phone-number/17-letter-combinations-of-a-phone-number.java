class Solution 
{
    List<String> ans = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) 
    {
        if(digits.isEmpty())
            return ans;
        char a[][] = new char[10][4];
        int cur = 97;
        for(int i=2; i<=6; i++)
        {
            a[i][3] = ' ';
            for(int j=0; j<3; j++)
                a[i][j] = (char)(cur++);
        }
        a[7][0] = (char)(cur++);
        a[7][1] = (char)(cur++);
        a[7][2] = (char)(cur++);
        a[7][3] = (char)(cur++);
        a[8][0] = (char)(cur++);
        a[8][1] = (char)(cur++);
        a[8][2] = (char)(cur++);
        a[8][3] = ' ';
        for(int j=0; j<4; j++)
            a[9][j] = (char)(cur++);
        backtrack(0, "", a, digits);
        return ans;
    }
    
    public void backtrack(int j, String cur, char[][] a, String digits)
    {
        if(cur.length() == digits.length())
        {
            ans.add(cur);
            return;
        }
        if(j >= digits.length())
            return;
        int num = digits.charAt(j) - '0';
        int range = 3;
        if(num == 7 || num == 9)
            range = 4;
        for(int i=0; i<range; i++)
            backtrack(j+1, cur + a[num][i], a, digits);
    }
}