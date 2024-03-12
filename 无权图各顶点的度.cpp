#include <iostream>
#include <bits/stdc++.h>
using namespace std;
const int maxn = 100;
 
int main() {
	int m[maxn][maxn];
	int v,e;
	int sx,ex;
	cin>>v>>e;
	for(int i=1;i<=e;i++){
		cin>>sx>>ex;
		m[sx][ex]=1;
		m[ex][sx]=1;
	}
	for(int i=1;i<=v;i++){
		int t=0;
		for(int j=1;j<=v;j++){
			t+=m[i][j];
		}
		cout<<t<<endl;
	}
	return 0;
}
