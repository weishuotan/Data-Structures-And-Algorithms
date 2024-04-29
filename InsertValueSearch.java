package com.atguigu.search;

public class InsertValueSearch {

	public static void main(String[] args) {
		int[] arr = {1,8,10,89,1000,1000,1234};
		
		int index1 = insertValueSearch(arr, 0 , arr.length - 1, 1234);
		System.out.println("需要查找的值得索引为：");
		System.out.println(index1);
		System.out.print("********************************************");
		int index2 = binarySearch(arr,0,arr.length - 1, 1234);
		System.out.println("需要查找的值得索引为：");
		System.out.println(index2);
	}
	
	//二分查找的方法
	public static int binarySearch(int[] arr, int left, int right, int value) {
		//没有找到得条件
		if(left > right) {
			return -1;
		}
		System.out.println("二分查找");
		int mid = (left + right) / 2;
		//二分法查找值得索引
		if(arr[mid] < value) {
			return binarySearch(arr, mid + 1, right, value);
		}else if(arr[mid] > value) {
			return binarySearch(arr, 0,mid - 1 , value);
		}else {
			return mid;
		}
	}
	
	//插值查找的方法
	public static int insertValueSearch(int[] arr,int left, int right, int value) {
		//判断一下条件
		if(left > right || value > arr[arr.length - 1] || value < arr[left]) {
			return -1;
		}
		//求自适应mid的值
		int mid = left + (value - arr[left]) * (right - left) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		System.out.println("插值查找");
		//开始调用递归方法进行插值查找
		if(value > midVal) {
			return insertValueSearch(arr, mid + 1, right, value);
		}else if( value < midVal) {
			return insertValueSearch(arr, left, mid - 1, value);
		}else {
			return mid;
		}
	}
	
}
