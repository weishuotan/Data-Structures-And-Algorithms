#include<bits/stdc++.h>
using namespace std;

const int N=510,M=10010;  //点数和边数的最大值

int n,m,k;  //n个点，m条边,边数的限制最多为k条 
int dist[N],backup[N];  //backup数组存的是上一次迭代的结果，dist存的是到每个点最短路的距离 

struct Edge
{
	int a,b,w;  // a存起点b存终点w存权值 
}edges[M]; 

int bellman_ford()
{
	//初始化dist数组全部置为正无穷，第一个点到自身的距离为0 
	memset(dist,0x3f,sizeof dist);
	dist[1]=0;
	
	for(int i=0;i<k;i++)
	{
		memcpy(backup,dist,sizeof dist);  //从数组dist赋值sizeof(dist)个元素到数组backup
		
		for(int j=0;j<m;j++)
		{
			int a=edges[j].a,b=edges[j].b,w=edges[j].w;
			dist[b]=min(dist[b],backup[a]+w);
		} 
	} 
	
	if(dist[n]>0x3f3f3f3f / 2)  return -1;
	else return dist[n];
}

int main()
{
	scanf("%d%d%d",&n,&m,&k);
	
	for(int i=0;i<m;i++)
	{
		int a,b,w;
		scanf("%d%d%d",&a,&b,&w);
		edges[i]={a,b,w};
	}
	
	int t=bellman_ford();
	
	if(t==-1)  puts("impossible");
	else printf("%d\n",t);
	
	return 0;
}

/*
in
3 3 1
1 2 1
2 3 1
1 3 3
*/
