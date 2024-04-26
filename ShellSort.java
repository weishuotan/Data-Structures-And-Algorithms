package com.atguigu.sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		shellSort(arr);

		// 随机数据测试程序的运行时间
		int[] arr1 = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr1[i] = (int) (Math.random() * 8000000);
		}

		// 当前时间
		String DateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序前的时间是=" + DateNow);

		shellSort(arr1);

		// 结束时间
		String DateAfter = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序后的时间是=" + DateAfter);
	}

	// 交换法希尔排序
	public static void shellSort(int[] arr) {
		// 归纳一个方法
		for (int n = arr.length / 2; n > 0; n = n / 2) {
			for (int i = n; i < arr.length; i++) {
				for (int j = i - n; j >= 0; j -= n) {
					if (arr[j] > arr[j + n]) {
						int temp = arr[j];
						arr[j] = arr[j + n];
						arr[j + n] = temp;
					}
				}
			}
		}
//		System.out.println("排序后的结果：");
//		System.out.println(Arrays.toString(arr));
		/*
		 * // 第一趟排序 for (int i = 5; i < arr.length; i++) { for (int j = i - 5; j >= 0; j
		 * -= 5) { if (arr[j] > arr[j + 5]) { int temp = arr[j]; arr[j] = arr[j + 5];
		 * arr[j + 5] = temp; } } } System.out.println("第一次排序后的结果：");
		 * System.out.println(Arrays.toString(arr));
		 * 
		 * // 第二趟排序 for (int i = 5 / 2; i < arr.length; i++) { for (int j = i - (5 / 2);
		 * j >= 0; j -= (5 / 2)) { if (arr[j] > arr[j + 2]) { int temp = arr[j]; arr[j]
		 * = arr[j + 2]; arr[j + 2] = temp; } } } System.out.println("第二次排序后的结果：");
		 * System.out.println(Arrays.toString(arr));
		 * 
		 * // 第三趟排序 for (int i = 2 / 2; i < arr.length; i++) { for (int j = i - (2 / 2);
		 * j >= 0; j -= (2 / 2)) { if (arr[j] > arr[j + 1]) { int temp = arr[j]; arr[j]
		 * = arr[j + 1]; arr[j + 1] = temp; } } } System.out.println("第三次排序后的结果：");
		 * System.out.println(Arrays.toString(arr));
		 */

	}

}
