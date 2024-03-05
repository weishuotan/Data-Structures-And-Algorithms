/*卡特兰数（Catalan number）是组合数学中一个常出现在各种计数问题中的数列。
若从第0项开始，则卡特兰数列 h[n] 为：1, 1, 2, 5, 14, 42, 132, 429, 1430, 
4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790,
 …。其中，常用的卡特兰数列 h[n] 有如下4种等价的递推式：
 h[n]=h[0]*h[n-1]+h[1]*h[n-2]+...+h[n-1]*h[0], (n≥2, h[0]=h[1]=1)
h[n]=h[n-1]*(4*n-2)/(n+1), (n≥2)
h[n]=C(2n,n)-C(2n,n-1), (n=0,1,2,...)
h[n]=C(2n,n)/(n+1), (n=0,1,2,...)
*/ 

#include <iostream>
#include<bits/stdc++.h>
using namespace std;
const int maxn=10001;

int main() {
	long long c[maxn],ans,n;
	cin>>n;
	c[0]=1;
	c[1]=1;
	for(int i=2;i<=n;i++){
		for(int j=0;j<=i-1;j++){
			c[i]+=c[j]*c[i-j-1];
		}
	}
	int k;
	for(k=0;k<=n;k++){
		cout<<c[k]<<endl;
	}
	return 0;
}
