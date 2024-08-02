#include <bits/stdc++.h>
using namespace std;

/* ¿ìËÙÃİ */
typedef long long LL;

int qmi(int a,int k,int p)
{
	int res = 1;
	
	while(k)
	{
		if(k&1) res = (LL)res * a % p;
		
		k>>=1;
		
		a=(LL)a * a % p;
	}
	
	return res;
}

int main() 
{
	int n; 
	cin>>n;
	
	while(n--)
	{
		int a,k,p;
		cin>>a>>k>>p;
		
		printf("%d\n",qmi(a,k,p));
	}
	
	return 0;
}

/*
in
2
3 2 5
4 3 9
out
4
1
*/
