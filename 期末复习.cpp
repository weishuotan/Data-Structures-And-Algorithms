#include <iostream>
#include <bits/stdc++.h>
using namespace std;

/*��֪�������������
string a,b;
void dg(int x1,int y1,int x2,int y2){
	if(x1 > y1){
		return;
	}	
	int root = b.find(a[x1]);
	dg(x1+1,x1+root-x2,x2,root-1);
	dg(x1+root-x2+1,y1,root+1,y2);
	cout<<a[x1];
}
int main() {
	cin>>a>>b;	
	dg(0,a.length() - 1,0,b.length()-1);
	cout<<endl;
	return 0;
}*/

/*��չŷ����ʽ
int x,y;

int exgcd(int a,int b){
	if(!b){
		x = 1,y = 0;
		return a;
	}	
	int gcd = exgcd(b,a%b);
	int temp = x;
	x = y;
	y = temp - a / b * y;
	return gcd;
}


int main(){
	int a,b;
	cin>>a>>b;
	exgcd(a,b);
	printf("x = %d,y = %d",x,y); 
	return 0;
} */

/*��ʮ���ƶ�Ӧ�Ķ�������1�ĸ���
int main(){
	int num;
	int cnt;
	cin>>num;
	while(num!=0){
		if(num&1) cnt++;
		num>>=1;
	}
	printf("%d",cnt);
	return 0;
} */

/*��������
int main(){
	int T;
	cin>>T;
	while(T--){
		int n;
		cin>>n;
		if(n%2==0) cout<<1;
		else cout<<7;
		for(int j=0;j<n/2-1;j++){
			cout<<1;
		}
		cout<<endl;
	}	
	return 0;
}*/

/*���ַ����
double f(double x){
	return x*x-3*x+1;
}
int main(){
	double le,ri,mid;
	do{
		scanf("%lf %lf",&le,&ri);
	}while(f(le)*f(ri)>0);
	do{
		mid=(le+ri)/2;
		if(f(mid)*f(le)>0) le=mid;
		else ri=mid;
	}while(fabs(f(mid))>=1e-5);
	printf("%.2lf",mid);
	return 0;
}*/
/*���ӳ���
int f(int n){
	int cnt = 1;
	for(int j = n-1;j>0;j--){
		cnt=(cnt+1)*2;
	}
	return cnt;
}
int main(){
	int n;
	scanf("%d",&n);
	printf("%d",f(n));
	return 0;
} */
/*��������
const int maxn=1000;
int d[maxn];

int main(){
	d[1]=1;
	d[2]=2;
	int n;
	cin>>n;
	for(int i=3;i<=n;i++){
		if(i%2==0){
		d[i]=d[i-1]+d[i/2]; 
	}else{
		d[i]=d[i-1];
	}
	}
	printf("%d",d[n]);
	return 0;
}*/
/*����֪����
int main(){
	int i=0;
	int f[5]={1,1,1,1,1};
	
	do{
		f[4]=f[4]+5;
		for(i=3;i>=0;i--){
			if(f[i+1]%4!=0)  break;
			else  f[i]=f[i+1]*5/4 + 1;
		}
	}while(i>=0);
	
	for(int j=0;j<5;j++){
		printf("%d ",f[j]);
	}
	return 0;
}*/
/*��ŵ��
int step = 0;
void hanno(int tot,char x,char y,char z){
	if(tot==0){
		return;
	}
	hanno(tot-1,x,z,y);
	step++;
	printf("step %d: %c -> %c \n",step,x,z);
	hanno(tot-1,y,x,z);
}
int main(){
	int n;
	cin>>n;
	hanno(n,'x','y','z');
	return 0;
}*/
/*����Ӷκ�
int maxSubSum(int a[],int left,int right){
	int sum = 0;
	//�߽����� 
	if(left == right){
		sum = a[left]>0 ? sum : 0;
	}else{

	int leftsum=maxSubSum(a,left,(left+right)/2);
	int rightsum=maxSubSum(a,(left+right)/2+1,right);
	//���漰������漰�Ҷ�ʱ
	int s1=0;
	int lefts=0;
	for(int i=(left+right)/2;i>=left;i--){
		lefts+=a[i];
		if(lefts>s1) s1=lefts;
	}
	
	int s2=0;
	int rights=0;
	for(int j=(left+right)/2+1;j<=right;j++){
		rights+=a[j];
		if(rights>s2) s2=rights;
	}
	
	sum=s1+s2;
	if(sum<leftsum) sum=leftsum;
	if(sum<rightsum) sum=rightsum;
	}
	return sum;
} 

int main(){
	int a[] = {-2,11,-4,13,-5,-2};
	int sum = maxSubSum(a,0,5);
	cout<<sum<<endl;
	return 0;
}*/
/*������
long long f(long a,long b){
	long long ans = 1;
	while(b){
		if(b&1) ans*=a;//����������� 
		b>>=1;//�������ż�� 
		a*=a;
	}
	return ans;
}
int main(){
	long long a,b;
	cin>>a>>b;
	cout<<f(a,b)<<endl;
	return 0;
}*/
/*���ȶ��������
priority_queue<int> G;
priority_queue <int,vector<int>,greater<int> > L;
int main(){

	
	int n;
	int x;
	cin>>n;
	while(n!=0){
		cin>>x;
	    G.push(x);
		L.push(x);
		n--;
	}  
	while(!G.empty()){
		cout<<G.top()<<" ";
	    G.pop();
	}
	cout<<endl;
	while(!L.empty()){
		cout<<L.top()<<" ";
		L.pop(); 
	}
	cout<<endl;
	return 0;
}*/ 
/*��K��Ԫ��
priority_queue<int> G;//�����
priority_queue<int,vector<int>,greater<int> > L;//С���� 
int main(){
	int k;
	cin>>k;
	
	int x;
	vector<int> v;
	while(cin>>x){
		v.push_back(x);
	}
	
	for(int i=0;i<v.size();i++){
		if(L.size()<k){
			L.push(v[i]);
		}else if(v[i]>L.top()){
			L.pop();
			L.push(v[i]);
		}
	}
	
	cout<<L.top()<<endl;
	return 0;
} */
/*topk 
priority_queue<int> G;//�����
priority_queue<int,vector<int>,greater<int> > L;//С���� 
int main(){
	int k;
	cin>>k;
	
	int x;
	vector<int> v;
	while(cin>>x){
		v.push_back(x);
	}
	
	for(int i=0;i<v.size();i++){
		if(L.size()<k){
			L.push(v[i]);
		}else if(v[i]>L.top()){
			L.pop();
			L.push(v[i]);
		}
	}
	
	while(!L.empty()){
		cout<<L.top()<<" ";
		L.pop();
	}
	return 0;
} */
/*��ʽ�˷�
int f(int n,int m){
	if(n==1)  return m;
	if(n&1==0) return f(n>>1,m<<1);
	else return f((n-1)>>1,m<<1)+m;
} 
int main(){
	int n,m;
	cin>>n>>m;
	cout<<f(n,m)<<endl;
	return 0;
}*/
/*����Ӳ������
const int maxn=3;
int ans[maxn];
int coin[]={1,2,5};

int main(){
	int money;
	cin>>money;
	for(int i=maxn-1;i>=0;i--){
		ans[i]=money/coin[i];
		money=money-ans[i]*coin[i];
	}
	for(int j=maxn-1;j>=0;j--){
		cout<<coin[j]<<" ";
		cout<<ans[j]<<endl;
	}
	return 0;
} */
/*�ŶӴ�ˮ����
const int maxn=1e5+5;
long long a[maxn];
long long ans;
int main(){
	long long n;
	cin>>n;
	for(int j=1;j<=n;j++){
		cin>>a[j];
	}	
	sort(a+1,a+n+1);
	for(int i=1;i<n;i++){
		ans=ans+a[i]*(n-i);
	}
	cout<<ans<<endl; 
	return 0;
} */
/*������������WPL
int total=0;
priority_queue<int,vector<int>,greater<int> > Q; 
int main(){
	int n;
	cin>>n;
	while(n--){
		int num;
		cin>>num;
		Q.push(num);
	}
	
	while(Q.size()!=1){
		int sum=0;
		sum+=Q.top();
		Q.pop();
		sum+=Q.top();
		Q.pop();
		Q.push(sum);
		total+=sum;
	}
	cout<<total<<endl;
	return 0;
} */
/*0-1��������
const int maxn=1005;
int val[maxn]={};
int vol[maxn]={};
int c[maxn][maxn]={};
int f[maxn]={};

int main(){
	int n,m;//n����Ʒ��m�������ݻ�
	cin>>n>>m; 
	for(int i=1;i<=n;i++){
		cin>>vol[i]>>val[i];
	}
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			if(j<vol[i])  c[i][j]=c[i-1][j];
			else c[i][j]=max(c[i-1][j],c[i-1][j-vol[i]]+val[i]);
		}
	}
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			cout<<c[i][j]<<"  ";
		}
		cout<<endl;
	}
	
	for(int i=n,j=m;i>=1;i--){
		if(c[i][j]>c[i-1][j]){
			f[i]=1;
			j-=vol[i];
		}else  f[i]=0;
	}
	
	for(int i=1;i<=n;i++){
		if(f[i]==1){
			cout<<i<<" ";
		} 	
	}
	
	return 0;
}*/
/*��ʽǰ����*/
const int N=1e5+5; 
const int M=N<<1;//���ǵ����������ͼ�ߵ�����������ߵ����� 
int n,m;
int head[N],to[M],next[M],idx;
bool stu[N];

int ans;

void add(int a,int b){
	next[idx]=head[a];//�Ƚ�a�ڵ�ͷ�ϵı߸�ֵ����ǰ�ߵ���һ���� 
	to[idx]=b;//����ǰ�ߵ�ָ��ĵ����ó�b 
	head[a]=idx++;//���ڶ����߲��뵽a��ͷ�ϵı� 
}
 
void bfs(int u){
	queue<int> q;
	stu[u]=true;//���ʳ�ʼ�ڵ�v�����v�ѱ����� �ڵ�v����� 
	q.push(u);
    while(!q.empty()){
    	int cnt=0;
    	int front = q.front();
    	q.pop();
//    	cout<<front<<" ";
    	for(int j=head[front];~j;j=next[j]){
    		cnt++;
    		int num = to[j];	
    		if(!stu[num]){
    			q.push(num);
    			stu[num]=true;
			}
		}
		cout<<cnt<<endl;
		break;
	}		
}
int main(){
	cin>>n>>m;
	memset(head,-1,sizeof(head));
	for(int i=1;i<=m;i++){
		int a,b;
		cin>>a>>b;
		add(a,b),add(b,a);
	}
	for(int i=1;i<=n;i++){
		memset(stu,false,sizeof(stu));
		bfs(i);
	}
	return 0;
}
/*¥������
double x,y,c;
bool f(double s){
	double rx = sqrt(x*x-s*s);
	double ry = sqrt(y*y-s*s);
	double h = (rx*ry)/(rx+ry);
	if(h>c){
		return true;
	}else{
		return false;
	}
}

int main(){
	scanf("%lf%lf%lf",&x,&y,&c);
	double ri=min(x,y);
	double le=0;
	
	while(ri-le>1e-5){
		double mid=le+(ri-le)/2;
		if(f(mid)){
			le=mid;
	    }else{
	    	ri=mid;
		}
	}
	printf("%.3lf",le);
	
	return 0;
}*/
/*0-1����
const int maxn = 1005;
int vol[maxn]={};
int val[maxn]={};
int c[maxn][maxn];
int f[maxn];

int main(){
	int n,m;//n����Ʒ��������������m; 
	cin>>n>>m;
	for(int i=1;i<=n;i++){
		cin>>vol[i]>>val[i];
	}
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			if(vol[i]>j)  c[i][j]=c[i-1][j];
			else  c[i][j]=max(c[i-1][j],c[i-1][j-vol[i]]+val[i]);
		}
	}
	cout<<c[n][m]<<endl;
	
	return 0;
}*/

