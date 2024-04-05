package com.atguigu.sparsearray;

public class SparseArray {

	public static void main(String[] args) {
		//创建一个原始的二维数组，表示棋盘上的数据
		//用1表示黑棋，2表示蓝棋
		int chessArray[][] = new int[11][11];
		chessArray[1][2] = 1;
		chessArray[2][3] = 2;
		
		//输出一下原始的二维数组
		System.out.println("原始的二维数组------");
		for(int[] row : chessArray) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//将二维数组转化为稀疏数组
		//求稀疏数组中有效值的个数
		int sum = 0;
		for(int[] row : chessArray) {
			for(int data : row) {
				if(data!=0) {
					sum++;
				}
			}	
		}
		System.out.println("棋子的数量------");
		System.out.println(sum);
		
        //声明稀疏数组
		int sparseArray[][] = new int[sum+1][3];
		
		//构建稀疏数组的第一行
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
		
		//构建稀疏数组的其他行
		int count = 0;
		for(int i = 0;i < 11;i++) {
			for(int j = 0;j < 11;j++) {
				if(chessArray[i][j] != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = chessArray[i][j];
				}
				
			}
		}
		
		//打印输出稀疏数组
		System.out.println("稀疏数组------");
		for(int[] row : sparseArray) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//将稀疏数组转换为二维数组
		//取稀疏数组第一行元素构建二维数组
		int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
		
		//读取稀疏数组第二行元素开始对原始数组进行赋值
		for(int i = 1;i < sparseArray.length;i++) {
			chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2]; 
		}
		
		//输出恢复后的二维数组
		System.out.println("恢复后的二维数组------");
		for(int[] row : chessArray2) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
	}

}
