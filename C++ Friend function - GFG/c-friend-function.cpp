// { Driver Code Starts
//Initial Template for C++

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class student
{
    private:
    string first_name;
    string last_name;
    
    public:
    void set_name(string f, string l)
    {
        first_name = f;
        last_name = l;
    }
       
    friend void check_name(student k);
};

    
 // } Driver Code Ends
//User function Template for C++

void check_name(student k)
{
    string s1 = k.first_name, s2 = k.last_name;
    sort(s1.begin(), s1.end());
    sort(s2.begin(), s2.end());
    if(s1 != s2)
        cout<<"NOT ANAGRAM"<<"\n";
    else
        cout<<"ANAGRAM"<<"\n";
}

// { Driver Code Starts.
  
  
  
int main() {
	int t;
	cin>>t;
	while(t--)
	{
	   
	    string f,l;
	    cin>>f>>l;
	   
	    student s1;
	    s1.set_name(f,l);
	    check_name(s1);
	    
	    
	    
	}
	return 0;
}  // } Driver Code Ends