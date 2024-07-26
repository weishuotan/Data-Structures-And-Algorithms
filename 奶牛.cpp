#include<bits/stdc++.h>
using namespace std;

const int maxn = 100010;

int n;
char o1,o2;
int num;
int now; 

int q[maxn];

int main(){
    cin>>n;
    
    int hh=50000,tt=49999;
    
    while(n--){
        
        cin>>o1>>o2;
        
        if(o1='A'){
            
            if(o2='L'){
                q[--hh]=++now;
            }
            else{
                q[++tt]=++now;
            }
        }
        else{
            
            cin>>num;
            
            if(o2='L'){
                hh+=num;
            }else{
                tt-=num;
            }
        }
        
    }
    
    for(int i=hh;i<=tt;i++){
        printf("%d\n",q[i]);
    }
    
    return 0;
}
