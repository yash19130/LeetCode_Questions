class Solution 
{
    public String replaceWords(List<String> dict, String sentence) 
    {
        Collections.sort(dict, (a, b) -> (a.length() - b.length()));
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String w: words)
        {
            boolean replaced = false;
            for(String s: dict)
            {
                if(w.indexOf(s) == 0)
                {
                    sb.append(s);
                    replaced = true;
                    break;
                }
            }
            if(!replaced)
                sb.append(w);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}