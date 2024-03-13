#include <iostream>
#include<bits/stdc++.h>
using namespace std;
/*
const int maxn = 105;
int mp[maxn][maxn];
int v,e;// ������ ����  
int sx,ex;//����� �յ��� 
*/
 /*������Ȩͼ 
int main() {
	cin>>v>>e;
	for(int i=1;i<=e;i++){
		cin>>sx>>ex;
		mp[sx][ex]=1;
		mp[ex][sx]=1;
	} 
	
	for(int j=1;j<=v;j++){
		for(int i=1;i<=v;i++){
			cout<<mp[j][i]<<" ";
		}
		cout<<endl;
	}
	
	return 0;
}*/ 

/*������Ȩͼ

int main(){
	cin>>v>>e;
	for(int i=1;i<=e;i++){
		cin>>sx>>ex;
		mp[sx][ex]=1;
	} 
	
	for(int j=1;j<=v;j++){
		for(int i=1;i<=v;i++){
			cout<<mp[j][i]<<" ";
		}
		cout<<endl;
	}
	return 0;
} 
*/

/*������Ȩͼ
int main(){
	int cost;
	cin>>v>>e;
	for(int i=1;i<=e;i++){
		cin>>sx>>ex>>cost;
		mp[sx][ex]=cost;
		mp[ex][sx]=cost;
	} 
	
	for(int j=1;j<=v;j++){
		for(int i=1;i<=v;i++){
			if(mp[j][i])  cout<<mp[j][i]<<" ";
			else cout<<"�� "; 
		}
		cout<<endl;
	}
	return 0;
} 
*/

/*������Ȩͼ
int main(){
	int cost;
	cin>>v>>e;
	for(int i=1;i<=e;i++){
		cin>>sx>>ex>>cost;
		mp[sx][ex]=cost;
		
	} 
	
	for(int j=1;j<=v;j++){
		for(int i=1;i<=v;i++){
			if(mp[j][i])  cout<<mp[j][i]<<" ";
			else cout<<"�� "; 
		}
		cout<<endl;
	}
	return 0;
}  
*/
/*�����ڽӾ����ʾͼ��������ȱ�������
int q[101],flag[101],e[101][101];
int a,b;//��㣬�յ� 
int n,m;//���������� 

void bfs(int cur){
	int head,tail;
	head=1;
	tail=1;
	q[tail++]=1;
	flag[1]=1;
	while(head<tail && tail<=n){
		cur=q[head];
		for(int i=1;i<=n;i++){
			if(e[cur][i]==1 && flag[i]==0){
				flag[i]=1;
				q[tail++]=i;
			}
			if(tail>n)  break;
		}
		head++;
	}
	for(int i=1;i<tail;i++){
		cout<<q[i]<<" "<<endl; 
	}
	return;
}


int main(){

	cin>>n>>m;
	
	for(int i=1;i<=n;i++) {
		for(int j=1;j<=n;j++){
			if(i==j)  e[i][j]=0;
			else  e[i][j]=0x3f3f3f3f;
		}
	}
	
	for(int i=1;i<=m;i++){
		cin>>a>>b;
		e[a][b]=1;
		e[b][a]=1;
	}
	
	bfs(1);
	
	return 0;
} 
*/

/*�����ڽӾ����ʾͼ��������ȱ�������*/
const int maxn = 105;
int flag[maxn];
int e[maxn][maxn];
int a,b;//��㣬�յ� 
int n,m;//���������� 
int tot;

void dfs(int cur){
	
	cout<<cur<<" ";
	tot++;
	if(tot==n)  return;//�������������˳����� 
	for(int i=1;i<=n;i++){
		if(e[cur][i]==1 && flag[i]==0){  //
			flag[i]=1;
			dfs[i];
		}
	}
	return;
}

int main(){

	cin>>n>>m;
	
	for(int i=1;i<=n;i++) {
		for(int j=1;j<=n;j++){
			if(i==j)  e[i][j]=0;
			else  e[i][j]=0x3f3f3f3f;
		}
	}
	
	for(int i=1;i<=m;i++){
		cin>>a>>b;
		e[a][b]=1;
		e[b][a]=1;
	}
	
	flag[1]=1;
	dfs(1);
	
	return 0;
} 






















