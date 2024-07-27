#include <bits/stdc++.h>
using namespace std;

const int N=210,INF = 1e9;

int n,m,Q;  //n��ʾͼ�ĵ�����m��ʾͼ�ı�����q��ʾѯ�ʵĴ���
int d[N][N];   //�ڽӾ���Ҳ��Ҫ����ľ���

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
	
	//��ʼ�� 
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=n;j++)
		{
			if(i==j)  d[i][j]=0;  //����û�и��Ļ����Խ����еĻ�����Ϊ0 
			else d[i][j]=INF;  //������ı���Ϊ������
		}
	}
	
	//���� 
	while(m--)
	{
		int a,b,w;
		scanf("%d%d%d",&a,&b,&w);
		
		d[a][b]=min(d[a][b],w);  //��������ر�ȡ��С�ı� 
	} 
	
	floyd(); 
	
	while(Q--)
	{
		int a,b;
		cin>>a>>b;
		
		if(d[a][b] > INF/2)  cout<<"impossible";  //������ܴ���һЩ��Ȩ��   a��b֮�䲻����ͨ·ʱ���ܻ����һЩ�߱�������Сһ�� 
		else printf("%d\n",d[a][b]);
	}
	
	return 0;
} 
