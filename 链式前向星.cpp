#include <iostream>
#include<bits/stdc++.h> 
using namespace std;

const int N=1e5+5;
const int M=N<<1;
int n,m;//n����m���� 
int h[N],e[M],ne[M],idx;
bool st[N];

int ans;

void add(int a,int b){
	e[idx]=b;//�յ�Ϊb 
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
	memset(h,-1,sizeof(h));//char�ͳ�ʼ������, void *memset(void *s , int ch , size_t  n ),��s�е�ǰn���ֽ���ch�滻���ҷ���s
	
	for(int i=1;i<=m;i++){
		int a,b;
		cin>>a>>b;//�ߵ������յ� 
		add(a,b),add(b,a);
	}
	
	for(int i=1;i<=n;i++){
		memset(st,false,sizeof(st));
		bfs(i);		
	} 
	
	return 0;
}
