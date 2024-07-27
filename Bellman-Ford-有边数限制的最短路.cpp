#include<bits/stdc++.h>
using namespace std;

const int N=510,M=10010;  //�����ͱ��������ֵ

int n,m,k;  //n���㣬m����,�������������Ϊk�� 
int dist[N],backup[N];  //backup����������һ�ε����Ľ����dist����ǵ�ÿ�������·�ľ��� 

struct Edge
{
	int a,b,w;  // a�����b���յ�w��Ȩֵ 
}edges[M]; 

int bellman_ford()
{
	//��ʼ��dist����ȫ����Ϊ�������һ���㵽����ľ���Ϊ0 
	memset(dist,0x3f,sizeof dist);
	dist[1]=0;
	
	for(int i=0;i<k;i++)
	{
		memcpy(backup,dist,sizeof dist);  //������dist��ֵsizeof(dist)��Ԫ�ص�����backup
		
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
