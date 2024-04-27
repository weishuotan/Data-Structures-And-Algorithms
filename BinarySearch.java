package com.atguigu.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,8,10,89,1000,1000,1234};
		int index = dinarySearch(arr,0,arr.length - 1,1234);
		if(index == -1) {
			System.out.println("sorry，没找到");
		}else {
			System.out.printf("找到了，下标为：%d\n",index);
		}
	}
	//编写一个二分查找的方法
	public static int dinarySearch(int[] arr,int left, int right, int value) {
		if(left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if(value < arr[mid]) {
			return dinarySearch(arr,left,mid - 1,value);
		}else if(value > arr[mid]) {
			return dinarySearch(arr,mid + 1,right,value);
		}else {
			return mid;
		}
	}
}
