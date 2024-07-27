#include <bits/stdc++.h>
using namespace std;

const int N=510;

int n,m;  //n表示点数，m表示边数
int g[N][N];  // 稠密图一般用邻接矩阵来存图
int dist[N];  //表示从1号点走到每一个点的当前最短距离
bool st[N];  //表示每个点的最短路是否已经确定

int dijkstra()
{
	//初始化 
	memset(dist,0x3f,sizeof dist);  //将所有的距离都初始化为正无穷 
	dist[1]=0;  //第一个点到第一个点的最短路径为0 
	
	//有n个点所以要迭代n次 
	for(int i=0;i<n;i++)
	{
		//找到当前没有确定最短路长度的点当中距离1号点最小的那个点
		int t=-1;  //表示还没有确定
		
		//遍历所有点 
		for(int j=1;j<=n;j++)
		{
			//当遍历到1点与j点之间最短路还没有确定 并且 （t点还未赋值 或者已赋值但是 t号与1号点距离最小值大于与j点与1号点之间的最小值） 
			if(!st[j] && (t==-1 || dist[t]>dist[j]))  t=j;  
		}
		
		if(t==n)  break;  //提前结束优化 
		
		st[t] = true;  //将t加到集合里面
		
		//拿t点更新其他点的距离  用1-t之间长度加t-j之间长度和1-j之间长度求最小值 
		for(int j=1;j<=n;j++)
		{
			dist[j] = min(dist[j], dist[t]+g[t][j]);
		}
	} 
	
	if(dist[n] == 0x3f3f3f3f)  return -1;  //说明1与n是不连通的
	else return dist[n];  //否则返回n的最短距离 
}

int main()
{
	scanf("%d%d",&n,&m);  //读入点数，边数
	
	memset(g,0x3f,sizeof g);  //初始化邻接矩阵：将所有点都置为正无穷(还有去除自环的功能)
	
	//读入有向边
	while(m--)
	{
		int a,b,c;
		scanf("%d%d%d",&a,&b,&c);
		g[a][b] = min(g[a][b],c);  //去除重边的可能性保留长度最短的边 
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
 
