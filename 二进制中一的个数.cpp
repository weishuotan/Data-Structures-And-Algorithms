#include <iostream>
#include<bits/stdc++.h>
using namespace std; 


int f(int n){
	int count = 0;
	if(n == 0){
		return 0;
	}
	else{
		while(n>0){
			if(n&1==1){
				count++;
			}
			n >>= 1;
		}
	}
	return count;
}

int main() {
	int n;
	cin >> n;
	cout<<"1µÄ¸öÊý£º"<<f(n)<<endl;
	return 0;
}
