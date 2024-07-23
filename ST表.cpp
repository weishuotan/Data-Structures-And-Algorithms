#include<iostream>

using namespace std;

const int maxn=100005;

int n,m;
int a[maxn];
int stmax[maxn][20];
int lg[maxn];
int ans[maxn];

int main(){
    cin>>n>>m;
    for(int i=1;i<=n;i++){
        cin>>a[i];
    }
    
    lg[1]=0;
    for(int i=2;i<=n;i++){
        lg[i]=lg[i>>1]+1;
    }
    
    for(int i=1;i<=n;i++){
        stmax[i][0]=a[i];
    }
    
    for(int i=1;i<=20;i++){
        for(int j=1;j+(1<<i)-1<=n;j++){
            stmax[j][i]=max(stmax[j][i-1],stmax[j+(1<<(i-1))][i-1]);
        }
    }
    
    int l,r;
    
    while(m--){
        scanf("%d%d",&l,&r);
        int k=lg[r-l+1];
        printf("%d\n",max(stmax[l][lg[r-l+1]],stmax[r-(1<<(lg[r-l+1]))+1][lg[r-l+1]]));
    }
    
}
