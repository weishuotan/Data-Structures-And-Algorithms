package com.atguigu.search;

public class SeqSearch {

	public static void main(String[] args) {
		int[] arr = {1,9,11,-1,34,89};
		int index = seqSearch(arr, 9);
		if(index == -1) {
			System.out.println("Sorry 没有找到");
		}else {
			System.out.printf("找到了，该数字在原数组中的下表为%d\n", index);
		}
	}
	//先定义一个顺序查找的方法
	public static int seqSearch(int[] arr,int value) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return -1;
		
	}
}
