#include <iostream>
#include<bits/stdc++.h> 
using namespace std;

string a,b;

void dg(int x1,int y1,int x2,int y2){
	if(x1>y1){
		return;
	}
	int root = b.find(a[x1]);
	dg(x1+1,x1+root-x2,x2,root-1);
	dg(x1+root-x2+1,y1,root+1,y2);
	cout<<a[x1];	
}

int main() {
	cin>>a>>b;
	dg(0,a.length()-1,0,b.length()-1);
	cout<<endl;	
	return 0;
}
