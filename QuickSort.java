package com.atguigu.sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {-9,78,0,23,-567,70,-1900,4561};
		// 随机数据测试程序的运行时间
		int[] arr1 = new int[8000000];
		for (int i = 0; i < 80000; i++) {
			arr1[i] = (int) (Math.random() * 8000000);
		}

		// 当前时间
		String DateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序前的时间是=" + DateNow);

		quickSort(arr,0,arr.length-1);

		// 结束时间
		String DateAfter = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序后的时间是=" + DateAfter);
		
//		System.out.println("排序后的数组是:");
//		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr,int left,int right) {
		int l = left;
		int r = right;
		int pivot = arr[(left + right) / 2];
		int temp = 0;
		while(l < r) {
			while(pivot > arr[l]) {
				l++;
			}
			while(pivot < arr[r]) {
				r--;
			}
			if(l >= r) {
				break;
			}
			temp = arr[r];
			arr[r] = arr[l];
			arr[l] = temp;
			if(arr[l] == pivot) {
				r--;
			}
			if(arr[r] == pivot) {
				l++;
			}
			
		}
		if (l == r) {
			l++;
			r--;
		}
		
		//递归
		if(left < r) {
			quickSort(arr,left,r);
		}
		if(right > l) {
			quickSort(arr,l,right);
		}
	}

}
