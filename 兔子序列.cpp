/*假设第1个月有1对刚诞生的兔子，第2个月进入成熟期，第3个月开始生育兔子，
而1对成熟的兔子每月会生1对兔子，兔子永不死去。那么，由1对初生兔子开始，
12个月后会有多少对兔子呢？

以1对新出生小兔子为例，

第1个月，小兔子1没有繁殖能力，所以还是1对。

第2个月，小兔子1进入成熟期，还是1对。

第3个月，小兔子1生了1对小兔子2，本月共有2对兔子。

第4个月，小兔子1又生了1对小兔子3，本月共有3对兔子。

第5个月，小兔子1又生了1对小兔子4，而在第3个月出生的小兔子2也生了1对小兔子5，本月共有5对兔子。 

第6个月，小兔子1,2,3各生1对小兔子，本月共有8对兔子。

可以得出结论符合斐波那契数列 
*/ 


#include <iostream>
#include<bits/stdc++.h>
using namespace std;

/* 
int fib(int n){
	if(n<1)  return -1;
	else if(n==1||n==2)  return 1;
	else  return fib(n-1)+fib(n-2);
}
*/

int fib(int n){
	if(n<1)  return -1;
	else if(n==1||n==2)  return 1;
	else{
		int pre1=1;
		int pre2=1;
		int tmp;
		for(int i=3;i<=n;i++){						
			tmp=pre1+pre2;
			pre2=pre1;
			pre1=tmp;
		}
		return tmp;
	}
} 
 
int main() {
	//输入月份
	int n;
	cin>>n;
	cout<<"一共有兔子数量："<<fib(n)<<endl; 
	return 0;
}
