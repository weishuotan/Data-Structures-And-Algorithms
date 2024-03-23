#include <iostream>
#include<bits/stdc++.h>
using namespace std;
const int maxn = 10;
int a[maxn][maxn];





int main() { 
	int n;
	cin>>n;
	//¥¶¿Ì 
	for(int i = 0;i < n;i++){
		for(int j = 0;j < n;j++){
			a[i][j] = 1;
		}
	}
	for(int i = 1;i < n;i++){
		for(int j = 1;j < i;j++){
			a[i][j] = a[i-1][j] + a[i-1][j-1];
		}
	} 
	for(int i = 0;i < n;i++){
		for(int k = 0;k < 26-5*(i/2);k++){
			printf(" ");
		}
		for(int j = 0;j <= i;j++){
			printf("%5d",a[i][j]);
		}
		printf("\n");
	} 
	return 0;
}
