/*һֻ����ժ�˺ܶ����ӣ�ÿ����������ӵ�һ���һ��������n��ʱֻ��һ�����ӣ���ԭ�����Ӷ��ٸ���*/ 



#include <iostream>
#include<bits/stdc++.h>
using namespace std;

int peach(int n){
	int cnt=1;
	for(int i=n-1;i>=1;i--){
		cnt=2*(cnt+1);
	}
	return cnt;
} 

int main() {
	//���� ��n��
	int n;
	cin>>n;
	//���� 
	peach(n);
	//���
	cout<<"ԭ��������Ϊ:"<<peach(n)<<endl; 
	return 0;
}
