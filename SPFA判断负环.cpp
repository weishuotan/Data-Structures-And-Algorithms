#include <bits/stdc++.h>
using namespace std;

//��һ������ά�����о��룬ά����ʱ����Ҫ֪�����нڵ�ı��
typedef pair<int ,int> PII;

const int N=100010;

int n,m;  //n��ʾ������m��ʾ����
int h[N],e[N],ne[N],w[N],idx;  // ϡ��ͼһ�����ڽӱ�����ͼ
int dist[N],cnt[N];  //dist��ʾ��1�ŵ��ߵ�ÿһ����ĵ�ǰ��̾���  cnt��ʾ��ǰ���·�ı��� 
bool st[N];  //��ʾÿ��������·�Ƿ��Ѿ�ȷ��

//�ڽӱ�ӱ�
void add(int a,int b,int c)
{
	e[idx]=b,w[idx]=c,ne[idx]=h[a],h[a]=idx++; 
} 

bool spfa()
{	
	queue<int> q;
	
	//��ʼ����ʱ�����е㶼������� 
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
		
		//����t�������ڽӵ�
		for(int i=h[t];i!=-1;i=ne[i])
		{
			int j=e[i]; // ȡ�����ߵ��յ�
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
