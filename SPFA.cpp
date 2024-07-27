#include <bits/stdc++.h>
using namespace std;

//��һ������ά�����о��룬ά����ʱ����Ҫ֪�����нڵ�ı��
typedef pair<int ,int> PII;

const int N=100010;

int n,m;  //n��ʾ������m��ʾ����
int h[N],e[N],ne[N],w[N],idx;  // ϡ��ͼһ�����ڽӱ�����ͼ
int dist[N];  //��ʾ��1�ŵ��ߵ�ÿһ����ĵ�ǰ��̾���
bool st[N];  //��ʾÿ��������·�Ƿ��Ѿ�ȷ��

//�ڽӱ�ӱ�
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
	st[1]=true;  //�жϵ�ǰ�ĵ��Ƿ��ڶ����з�ֹ�����д洢�ظ��ĵ�
	
	while(q.size())
	{
		int t=q.front();
		q.pop();
		
		st[t]=false;
		
		//����t�������ڽӵ�
		for(int i=h[t];i!=-1;i=ne[i])
		{
			int j=e[i]; // ȡ�����ߵ��յ�
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
	scanf("%d%d",&n,&m);  //�������������
	
	memset(h,-1,sizeof h); //��ʼ���ڽӱ�������ͷ��㶼��Ϊ-1
	
	//���������
	while(m--)
	{
		int a,b,c;
		scanf("%d%d%d",&a,&b,&c);
		add(a,b,c); 
	}
	
	int t = spfa();  //����ӵ�1���㵽��n���㳤�ȵ���Сֵ
	
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
 




