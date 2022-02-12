// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution 
{
public:
    int wordLadderLength(string begin, string end, vector<string>& wordList) 
    {
        unordered_set<string> hs(wordList.begin(), wordList.end());
        queue<pair<string, int>> q;
        q.push({begin, 1});
        while(!q.empty())
        {
            string s = q.front().first;
            int len = q.front().second;
            q.pop();
            if(s == end)
                return len;
            int n = s.length();
            for(int i=0; i<n; i++)
            {
                char org = s[i];
                for(int j=0; j<26; j++)
                {
                    s[i] = (char) ('a' + j);
                    if(hs.find(s) != hs.end())
                    {
                        hs.erase(s);
                        q.push({s, len+1});
                    }
                }
                s[i] = org;
            }
        }
        return 0;
    }
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<string>wordList(n);
		for(int i = 0; i < n; i++)cin >> wordList[i];
		string startWord, targetWord;
		cin >> startWord >> targetWord;
		Solution obj;
		int ans = obj.wordLadderLength(startWord, targetWord, wordList);
		cout << ans << "\n";
	}
	return 0;
}  // } Driver Code Ends