

class Solution {
public:
    vector<int> printMatrix(vector<vector<int> > matrix) {
        int tot=0;
        
        int a,b;
        a=matrix.size();
        b=matrix[1].size();
        
        int s[410];
        
        int x=0,y=0;
        s[0]=matrix[0][0];
        
        while(tot<a*b)
        {
            while(y+1<b && matrix[x][y+1]!=0){s[++tot]=matrix[x][y+1];matrix[x][++y]=0;}
            while(x+1<a && matrix[x+1][y]!=0){s[++tot]=matrix[x+1][y];matrix[++x][y]=0;}
            while(y-1>=0 && matrix[x][y-1]!=0){s[++tot]=matrix[x][y-1];matrix[x][--y]=0;}
            while(x-1>=0 && matrix[x-1][y]!=0){s[++tot]=matrix[x-1][y];matrix[--x][y]=0;}
        }
        
        cout<<"[";
        for(int i=0;i<a*b-1;i++)
        {
            cout<<s[i]<<",";
        }
        cout<<s[a*b-1]<<"]";
    }
};
