package com.atguigu.sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
		
		// 随机数据测试程序的运行时间
		int[] arr1 = new int[8000000];
		for (int i = 0; i < 80000; i++) {
			arr1[i] = (int) (Math.random() * 8000000);
		}

		// 当前时间
		String DateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序前的时间是=" + DateNow);

		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);

		// 结束时间
		String DateAfter = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序后的时间是=" + DateAfter);

//		System.out.println("排序后的结果：");
//		System.out.println(Arrays.toString(arr));

	}

	// 分+合
	public static void mergeSort(int[] arr, int left, int right, int temp[]) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
			merge(arr, left, mid, right, temp);
		}
	}

	// 合并方法
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		// 定义两个指针分别指向left与mid+1
		int i = left;
		int j = mid + 1;
		int t = 0;// 表示的是temp数组的索引
		while (i <= mid && j <= right) {
			// 1
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t++;
				i++;
			} else {
				temp[t] = arr[j];
				t++;
				j++;
			}
		}
			// 2
			while (i <= mid) {
				temp[t] = arr[i];
				i++;
				t++;
			}
			while (j <= right) {
				temp[t] = arr[j];
				j++;
				t++;
			}
			// 3
			t = 0;
			int tempLeft = left;
			while (tempLeft <= right) {
				arr[tempLeft] = temp[t];
				t++;
				tempLeft++;
			}

		
	}

}
