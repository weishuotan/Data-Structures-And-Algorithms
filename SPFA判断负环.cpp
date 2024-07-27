#include <bits/stdc++.h>
using namespace std;

//用一个堆来维护所有距离，维护的时候还需要知道所有节点的编号
typedef pair<int ,int> PII;

const int N=100010;

int n,m;  //n表示点数，m表示边数
int h[N],e[N],ne[N],w[N],idx;  // 稀疏图一般用邻接表来存图
int dist[N],cnt[N];  //dist表示从1号点走到每一个点的当前最短距离  cnt表示当前最短路的边数 
bool st[N];  //表示每个点的最短路是否已经确定

//邻接表加边
void add(int a,int b,int c)
{
	e[idx]=b,w[idx]=c,ne[idx]=h[a],h[a]=idx++; 
} 

bool spfa()
{	
	queue<int> q;
	
	//初始化的时候将所有点都加入队列 
	for(int i=1;i<=n;i++)
	{
		st[i]=true;
		q.push(i);
	}
	
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
				cnt[j] =cnt[t]+1;
				
				if(cnt[j]>=n)  return true;
				if(!st[j])
				{
					q.push(j);
					st[j]=true;
				}
			} 
		} 
	} 
	
	return false;
	
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
	
	if(t)  cout<<"Yes"<<endl;
	else cout<<"No";
	
	return 0; 
}


/*
in:
3 3
1 2 -1
2 3 4
3 1 -4

out:
Yes 
*/
