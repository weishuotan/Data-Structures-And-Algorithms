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

int dijkstra()
{
	//��ʼ�� 
	memset(dist,0x3f,sizeof dist);  //�����еľ��붼��ʼ��Ϊ������ 
	dist[1]=0;  //��һ���㵽��һ��������·��Ϊ0 
	
	//ԽС�������ȼ�Խ��  �����ȶ�����ά�����е�ľ��� 
	priority_queue<PII,vector<PII>,greater<PII> > heap; 	
	heap.push({0,1});  //������0�������1  �Ȱ����ŵ����ȶ����� 
	
	while(heap.size()) 
	{
		auto t = heap.top();  //ÿһ��ȡ����ǰ������С�ĵ� 
		heap.pop();
		
		int ver = t.second,distance = t.first;
		if(st[ver])  continue;  //��������֮ǰ�����¹�˵�������౸�� 
		
		//����������������������е� 
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
	
	if(dist[n] == 0x3f3f3f3f)  return -1;  //˵��1��n�ǲ���ͨ��
	else return dist[n];  //���򷵻�n����̾��� 
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
	
	int t = dijkstra();  //����ӵ�1���㵽��n���㳤�ȵ���Сֵ
	
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
 

