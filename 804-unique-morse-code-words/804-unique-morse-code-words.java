class Solution 
{
    public int uniqueMorseRepresentations(String[] words) 
    {
        Set<String> hs = new HashSet<>();
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
                          ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
                          ".--","-..-","-.--","--.."};
        for(String w: words)
        {
            StringBuilder sb = new StringBuilder();
            for(char c: w.toCharArray())
                sb.append(morse[c - 'a']);
            hs.add(sb.toString());
        }
        return hs.size();
    }
}