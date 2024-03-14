#include <iostream>
#include<bits/stdc++.h> 
using namespace std;

const int N=1e5+5;
const int M=N<<1;
int n,m;//n个点m条边 
int h[N],e[M],ne[M],idx;
bool st[N];

int ans;

void add(int a,int b){
	e[idx]=b;//终点为b 
	ne[idx]=h[a];// 
	h[a]=idx++;
} 

void bfs(int u){
	queue<int>q;
	st[u]=true;
	q.push(u);
	while(!q.empty()){
		int cnt=0;
		int t=q.front();
		q.pop;
		for(int i=h[t];~i;i=ne[i]){
			cnt++;
			int j=e[i];
			if(!st[j]){
				q.push(j);
				st[j]=true;
			}
		}
		cout<<cnt<<endl;
		break;
	}
}

int main() {
	cin>>n>>m;
	memset(h,-1,sizeof(h));//char型初始化函数, void *memset(void *s , int ch , size_t  n ),将s中的前n个字节用ch替换并且返回s
	
	for(int i=1;i<=m;i++){
		int a,b;
		cin>>a>>b;//边的起点和终点 
		add(a,b),add(b,a);
	}
	
	for(int i=1;i<=n;i++){
		memset(st,false,sizeof(st));
		bfs(i);		
	} 
	
	return 0;
}
