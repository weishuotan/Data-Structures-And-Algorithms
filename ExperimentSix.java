package com.atguigu.class_experiment;

import java.util.Scanner;

public class ExperimentSix {

	public static void main(String[] args) {
		int[] arr = { 5, 7, 4, 6, 8, 1, 10 };
		sortArr(arr);
		System.out.println("索引为：");
		System.out.println(dinarySearch(arr,0,arr.length-1,10));
	}

	// 折半查找
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
	// 排序方法
	public static void sortArr(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
