#include <bits/stdc++.h>
using namespace std;

//用一个堆来维护所有距离，维护的时候还需要知道所有节点的编号
typedef pair<int ,int> PII;

const int N=100010;

int n,m;  //n表示点数，m表示边数
int h[N],e[N],ne[N],w[N],idx;  // 稀疏图一般用邻接表来存图
int dist[N];  //表示从1号点走到每一个点的当前最短距离
bool st[N];  //表示每个点的最短路是否已经确定

//邻接表加边
void add(int a,int b,int c)
{
	e[idx]=b,w[idx]=c,ne[idx]=h[a],h[a]=idx++; 
} 

int spfa()
{
	memset(dist,0x3f,sizeof dist);
	dist[1]=0;
	
	queue<int> q;
	q.push(1);
	st[1]=true;  //判断当前的点是否在队列中防止队列中存储重复的点
	
	while(q.size())
	{
		int t=q.front();
		q.pop();
		
		st[t]=false;
		
		//更新t的所有邻接点
		for(int i=h[t];i!=-1;i=ne[i])
		{
			int j=e[i]; // 取出来边的终点
			if(dist[j]>dist[t]+w[i])
			{
				dist[j]=dist[t]+w[i];
				if(!st[j])
				{
					q.push(j);
					st[j]=true;
				}
			} 
		} 
	} 
	
	if(dist[n]==0x3f3f3f3f)  return -1;
	return dist[n];
	
}

int main()
{
	scanf("%d%d",&n,&m);  //读入点数，边数
	
	memset(h,-1,sizeof h); //初始化邻接表：将所有头结点都置为-1
	
	//读入有向边
	while(m--)
	{
		int a,b,c;
		scanf("%d%d%d",&a,&b,&c);
		add(a,b,c); 
	}
	
	int t = spfa();  //求出从第1个点到第n个点长度的最小值
	
	if(t==-1)  cout<<"impossible"<<endl;
	else cout<<t;
	
	return 0; 
}


/*
in:
3 3
1 2 5
2 3 -3
1 3 4

out:
2
*/
 




