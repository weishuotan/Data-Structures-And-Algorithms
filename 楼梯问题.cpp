#include <iostream>
#include<bits/stdc++.h>
using namespace std; 
double x,y,c;

bool check(double mid){
	double rx = sqrt(x*x-mid*mid);
	double ry = sqrt(y*y-mid*mid);
	double h = rx*ry/(rx+ry);
	if(h>c){
		return true;
	}
	else{
		return false;
	}	
}


int main() {
	scanf("%lf%lf%lf",&x,&y,&c);
	double le,ri;
	le=0;
	ri=min(le,ri);
	while(ri-le>1e-5){
		double mid=le+(ri-le)/2;
		if(check(mid)){
			le=mid;
		}
		else{
			ri=mid;
		}
		
	}
	printf("%.3lf",le);
	
	return 0;
}
