#include <iostream>
#include<bits/stdc++.h> 
using namespace std;

double f(double x){
	return x*x-3*x+1;
}

int main() {
	double mid,le,ri;
	do{
		scanf("%lf%lf",&le,&ri);
	}while(f(le)*f(ri)>0);
	
	do{
		mid = (le +ri)/2 ;
		if(f(mid)>0){
			le = mid;
		}
		else{
			ri = mid;
		}
	}while(fabs(f(mid))>=1e-5);
	
	printf("%.2lf",mid);
	return 0;
}
