#include <iostream>
#include <bits/stdc++.h> 
using namespace std;

int a[26];

int main() {
	
	string s;
	cin>>s;
	
	for(int i=0;i<s.length();i++){
		a[s[i]-'a']+=1;
	}
	
	for(int i=0;i<26;i++){
		if(a[i]!=0){
			cout<<(char)(i+'a')<<":"<<a[i]<<endl;
		}
	}
	return 0;
}
