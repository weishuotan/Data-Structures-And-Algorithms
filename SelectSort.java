package com.atguigu.sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		int[] arr = { 101, 34, 119, 1 };
		// 随机数据测试程序的运行时间
		int[] arr1 = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr1[i] = (int) (Math.random() * 8000000);
		}

		// 当前时间
		String DateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序前的时间是=" + DateNow);

		selectSort(arr1);

		// 结束时间
		String DateAfter = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序后的时间是=" + DateAfter);
		// 第一轮排序
		int min = arr[0];
		int minIndex = 0;
		for (int i = 0 + 1; i < arr.length; i++) {
			if (min > arr[i]) {
				minIndex = i; // 更新下标
				min = arr[i]; // 更新最小值
			}
		}

		if (minIndex != 0) {
			arr[minIndex] = arr[0];
			arr[0] = min;
		}

		System.out.println("第一轮排序后：");
		System.out.println(Arrays.toString(arr));

		// 第二轮排序
		min = arr[1];
		minIndex = 1;
		for (int i = 0 + 1 + 1; i < arr.length; i++) {
			if (min > arr[i]) {
				minIndex = i; // 更新下标
				min = arr[i]; // 更新最小值
			}
		}

		if (minIndex != 1) {
			arr[minIndex] = arr[1];
			arr[1] = min;
		}

		System.out.println("第二轮排序后：");
		System.out.println(Arrays.toString(arr));

		// 第三轮排序
		min = arr[2];
		minIndex = 2;
		for (int i = 0 + 1 + 1; i < arr.length; i++) {
			if (min > arr[i]) {
				minIndex = i; // 更新下标
				min = arr[i]; // 更新最小值
			}
		}

		if (minIndex != 2) {
			arr[minIndex] = arr[2];
			arr[2] = min;
		}

		System.out.println("第三轮排序后：");
		System.out.println(Arrays.toString(arr));
	}

	// 归纳一个快速排序的方法
	public static void selectSort(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			int min = arr[j];
			int minIndex = j;
			for (int i = j + 1; i < arr.length; i++) {
				if (min > arr[i]) {
					minIndex = i; // 更新下标
					min = arr[i]; // 更新最小值
				}
			}

			if (minIndex != j) {
				arr[minIndex] = arr[j];
				arr[j] = min;
			}

			//System.out.printf("第%d轮排序后：\n", j);
			//System.out.println(Arrays.toString(arr));

		}
	}

}
