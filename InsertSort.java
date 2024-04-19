package com.atguigu.sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int[] arr = { 101, 34, 119, 1 };
		insertSort(arr);

		// 随机数据测试程序的运行时间
		int[] arr1 = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr1[i] = (int) (Math.random() * 8000000);
		}

		// 当前时间
		String DateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序前的时间是=" + DateNow);

		insertSort(arr1);

		// 结束时间
		String DateAfter = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序后的时间是=" + DateAfter);

		/*
		 * // 第一轮排序 int insertValue = arr[1]; int insertIndex = 1 - 1; while
		 * (insertIndex >= 0 && insertValue < arr[insertIndex]) { arr[insertIndex + 1] =
		 * arr[insertIndex]; insertIndex--; } arr[insertIndex + 1] = insertValue;
		 * System.out.println("第一次排序后的结果："); System.out.println(Arrays.toString(arr));
		 * 
		 * // 第二轮排序 insertValue = arr[2]; insertIndex = 2 - 1; while (insertIndex >= 0
		 * && insertValue < arr[insertIndex]) { arr[insertIndex + 1] = arr[insertIndex];
		 * insertIndex--; } arr[insertIndex + 1] = insertValue;
		 * System.out.println("第二次排序后的结果："); System.out.println(Arrays.toString(arr));
		 * 
		 * // 第三轮排序 insertValue = arr[3]; insertIndex = 3 - 1; while (insertIndex >= 0
		 * && insertValue < arr[insertIndex]) { arr[insertIndex + 1] = arr[insertIndex];
		 * insertIndex--; } arr[insertIndex + 1] = insertValue;
		 * System.out.println("第三次排序后的结果："); System.out.println(Arrays.toString(arr));
		 * 
		 * // 第四轮排序 insertValue = arr[3]; insertIndex = 3 - 1; while (insertIndex >= 0
		 * && insertValue < arr[insertIndex]) { arr[insertIndex + 1] = arr[insertIndex];
		 * insertIndex--; } arr[insertIndex + 1] = insertValue;
		 * System.out.println("第三次排序后的结果："); System.out.println(Arrays.toString(arr));
		 */
	}

	// 归纳出来一个方法
	public static void insertSort(int[] arr) {
		for (int j = 1; j < arr.length; j++) {
			int insertValue = arr[j];
			int insertIndex = j - 1;
			while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			arr[insertIndex + 1] = insertValue;

		}
//		System.out.printf("排序后的结果");
//		System.out.println(Arrays.toString(arr));
	}
}
