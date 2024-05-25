package maximum_line_segment_overlap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class MaximumLineLegmentLverlap {
	//静态全局变量的申请
	public static int MAXN = 1001;
	//申请静态全局数组  line[i][0]表示第i个线段的起点，line[0][1]表示第i个线段的终点
	public static int[][] line = new int[MAXN][2];
	//表示线段的个数
	public static int n;
	
	//标准化acm风格输入流输出流
	public static void main(String[] args) throws IOException{
		//将系统给的输入数据放到缓冲区中  InputStreamReader表示读取数据的字节流转换为字符流防止出现乱码
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//对读取到的缓冲区中的数据进行解析，主要是为了分开空格 和换行
		StreamTokenizer in = new StreamTokenizer(br); 
		//装一下StreamTokenizer st =new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
		//输出流主要是创建一个文件向里面写入数据 OutputStreamWriter表示将字符流转换成字节流按一定的编码进行存储
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		//将数据按照一定的形式读取
		//获取下一组标记   默认是按照空格分割的   回车，tab是结束符
		//in.navl默认解析出的格式是double
		while(in.nextToken()!=StreamTokenizer.TT_EOF) {
			n=(int)in.nval;
			for(int i = 0; i < n; i++) {
				in.nextToken();
				line[i][0]=(int)in.nval;
				in.nextToken();
				line[i][1]=(int)in.nval;
			}
			out.println(compute());
		}
		out.flush();//防止因为缓冲区没有满不自动输出
		out.close();
		br.close();
	}

	
	
	//问题解决方法
	public static int compute() {
		
	}
	
	//手写堆结构
	//定义小根堆
	public static int[] heap = new int[MAXN];
	public static int size;//堆的大小
	
	//加元素操作
	public static void add(int num) {
		heap[size]=num;
		
	}
 	
	
	
	//交换函数的单独代码
	public static void swap(int i,int j) {
		int temp=heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
	}
	
	
	
	

}
