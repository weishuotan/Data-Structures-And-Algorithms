#include <iostream>
#include<bits/stdc++.h> 
using namespace std;

int main() {
	int n;
	cin>>n;
	if(n%2==0){
		for(int i=1;i<n/2;i++){
			cout<<1;
		}
	}
	else{
		cout<<7;
		for(int i=1;i<n/2;i++){
			cout<<1;
		}
	}
	
	
	
	
	
	return 0;
}
