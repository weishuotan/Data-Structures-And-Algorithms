/*一只猴子摘了很多桃子，每天吃现有桃子的一半多一个，到第n天时只有一个桃子，问原有桃子多少个？*/ 



#include <iostream>
#include<bits/stdc++.h>
using namespace std;

int peach(int n){
	int cnt=1;
	for(int i=n-1;i>=1;i--){
		cnt=2*(cnt+1);
	}
	return cnt;
} 

int main() {
	//输入 第n天
	int n;
	cin>>n;
	//处理 
	peach(n);
	//输出
	cout<<"原有桃子数为:"<<peach(n)<<endl; 
	return 0;
}
