//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution{
public:
    void dfs(int i,int j, vector<vector<char>> &mat, vector<vector<bool>> &vis, int n, int m )
    {
        if(i<0 || i>=n || j<0 || j>=m || mat[i][j]!='O' || vis[i][j])
        return;
        vis[i][j]=true;
        dfs(i+1,j,mat,vis,n,m);
        dfs(i-1,j,mat,vis,n,m);
        dfs(i,j+1,mat,vis,n,m);
        dfs(i,j-1,mat,vis,n,m);
        
    }
    vector<vector<char>> fill(int n, int m, vector<vector<char>> mat)
    {
        // code here
        // int n=mat.size();
        // int m=mat[0].size();
        vector<vector<bool>> vis(n, vector<bool>(m,false));
        //bool vis[n][m]={false};
        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(i==0||j==0||i==n-1||j==m-1)
                {
                    if(mat[i][j]=='O' && vis[i][j]==false)
                    {
                        // cout<<"here1"<<endl;
                        dfs(i,j,mat,vis, n,m);
                        // cout<<"here2"<<endl;
                    }
                }
            }
        }
        // cout<<"here3"<<endl;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                // if(vis[i][j]==true && mat[i][j]=='O')
                // mat[i][j]='O';
                // else
                // mat[i][j]='X';
                if(vis[i][j]==false)
                mat[i][j]='X';
                
            }
        }
        return mat;
        
    }
};
// } Driver Code Ends

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n, m;
        cin>>n>>m;
        vector<vector<char>> mat(n, vector<char>(m, '.'));
        for(int i = 0;i < n;i++)
            for(int j=0; j<m; j++)
                cin>>mat[i][j];
        
        Solution ob;
        vector<vector<char>> ans = ob.fill(n, m, mat);
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                cout<<ans[i][j]<<" ";
            }
            cout<<"\n";
        }
    }
    return 0;
}
// } Driver Code Ends