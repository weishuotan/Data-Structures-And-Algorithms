
#include<bits/stdc++.h> 
using namespace std;

void exgcd(int a,int b,int &x,int &y){
	if(b==0){
		x=1;
		y=0;
	}
	else{
		exgcd(b,a%b,x,y);
		int t=y;
		y=x-a/b*y;
		x=t;
	}
	return;
}

int main() {
	int n;
	cin>>n;
	while(n--){
		int a,b,x,y;
		cin>>a>>b;
		x=a;
		y=b;
		exgcd(a,b,x,y);
		cout<<x<<" "<<y<<endl;
	}
	return 0;
}
