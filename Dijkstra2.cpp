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

int dijkstra()
{
	//初始化 
	memset(dist,0x3f,sizeof dist);  //将所有的距离都初始化为正无穷 
	dist[1]=0;  //第一个点到第一个点的最短路径为0 
	
	//越小的数优先级越大  用优先队列来维护所有点的距离 
	priority_queue<PII,vector<PII>,greater<PII> > heap; 	
	heap.push({0,1});  //距离是0，编号是1  先把起点放到优先队列中 
	
	while(heap.size()) 
	{
		auto t = heap.top();  //每一次取出当前距离最小的点 
		heap.pop();
		
		int ver = t.second,distance = t.first;
		if(st[ver])  continue;  //如果这个点之前被更新过说明是冗余备份 
		
		//否则就用这个点更新其他所有点 
		for(int i=h[ver];i!=-1;i=ne[i])
		{
			int j=e[i];
			if(dist[j]>distance+w[i])
			{
				dist[j]=distance + w[i];
				heap.push({dist[j],j});
			}
		}
	}
	
	if(dist[n] == 0x3f3f3f3f)  return -1;  //说明1与n是不连通的
	else return dist[n];  //否则返回n的最短距离 
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
	
	int t = dijkstra();  //求出从第1个点到第n个点长度的最小值
	
	cout<<t;
	
	return 0; 
}


/*
in:
3 3
1 2 2
2 3 1
1 3 4

out:
3
*/
 

