#include <iostream>
#include<bits/stdc++.h>
using namespace std;

const int inf = 0x3f3f3f3f;
const int maxn = 1005;
int a[maxn][maxn];
int f[maxn][maxn];
int ans = -inf;
 
int main() {
	
	int n;
	cin>>n;
	
	for(int i = 1;i <= n;i++){
		for(int j = 1;j <= i;j++){
			int value;
			cin>>value;
			a[i][j] = value;
		}	
	}
	
	for(int i=1; i<=n; i++) {
		for(int j=0; j<=i+1; j++) { 
			f[i][j]=-inf; 
		}
	}

	f[1][1] = a[1][1]; 
	for(int i = 2;i <= n;i++){
		for(int j = 1;j <= i;j++){
			f[i][j] = max(f[i-1][j-1],f[i-1][j]) + a[i][j];
		} 
	}
	
	for(int i = 1;i <= n;i++){
		ans = max(ans,f[n][i]);
	}
	
	cout<<ans<<endl;
	
	return 0;
}
