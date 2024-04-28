package com.atguigu.search;

import java.util.ArrayList;

public class ImproveBinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,8,10,89,1000,1000,1234};
//		int index = dinarySearch(arr,0,arr.length - 1,1234);
//		if(index == -1) {
//			System.out.println("sorry，没找到");
//		}else {
//			System.out.printf("找到了，下标为：%d\n",index);
//		}
		
		System.out.println(dinarySearch(arr,0,arr.length - 1,1000));
	}

	// 编写一个二分查找的方法
	public static ArrayList<Integer> dinarySearch(int[] arr, int left, int right, int value) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		if (value < arr[mid]) {
			return dinarySearch(arr, left, mid - 1, value);
		} else if (value > arr[mid]) {
			return dinarySearch(arr, mid + 1, right, value);
		} else {
			ArrayList<Integer> resIntegerList = new ArrayList<Integer>(); //创建一个数组列表容器用来装数据
			
			int temp = mid - 1;
			while(true) {
				if(temp < 0) {
					break;
				}else if(arr[temp] == arr[mid]) {
					resIntegerList.add(temp);
					temp -= 1;
				}else {
					temp -= 1;
				}
			}
			
			temp = mid + 1;
			while(true) {
				if(temp >= arr.length) {
					break;
				}else if(arr[temp] == arr[mid]) {
					resIntegerList.add(temp);
					temp += 1;
				}else {
					temp += 1;
				}
			}
			
			resIntegerList.add(mid);
			
			return resIntegerList;
		}
	}

}
