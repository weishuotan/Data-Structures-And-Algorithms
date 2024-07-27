#include <bits/stdc++.h>
using namespace std;

const int N=210,INF = 1e9;

int n,m,Q;  //n表示图的点数，m表示图的边数，q表示询问的次数
int d[N][N];   //邻接矩阵也是要处理的矩阵

void floyd()
{
	for(int k=1;k<=n;k++)
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				d[i][j]=min(d[i][j],d[i][k]+d[k][j]);
			}
		}
	}
}

int main()
{
	scanf("%d%d%d",&n,&m,&Q);
	
	//初始化 
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=n;j++)
		{
			if(i==j)  d[i][j]=0;  //由于没有负的环所以将所有的环都置为0 
			else d[i][j]=INF;  //将其余的边置为正无穷
		}
	}
	
	//输入 
	while(m--)
	{
		int a,b,w;
		scanf("%d%d%d",&a,&b,&w);
		
		d[a][b]=min(d[a][b],w);  //如果存在重边取最小的边 
	} 
	
	floyd(); 
	
	while(Q--)
	{
		int a,b;
		cin>>a>>b;
		
		if(d[a][b] > INF/2)  cout<<"impossible";  //里面可能存在一些负权边   a和b之间不存在通路时可能会存在一些边比正无穷小一点 
		else printf("%d\n",d[a][b]);
	}
	
	return 0;
} 
