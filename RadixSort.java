package com.atguigu.sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = { 53, 3, 542, 748, 14, 214 };

		//测试一下方法
		radixSort(arr);
		
		// 随机数据测试程序的运行时间
		int[] arr1 = new int[8000000];
		for (int i = 0; i < 80000; i++) {
			arr1[i] = (int) (Math.random() * 8000000);
		}

		// 当前时间
		String DateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序前的时间是=" + DateNow);

		radixSort(arr1);

		// 结束时间
		String DateAfter = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序后的时间是=" + DateAfter);
		
//		// 定义一个桶
//		int[][] bucket = new int[10][arr.length];
//		// 定义一个记录每个桶中含有数据的个数的数组
//		int[] bucketElementCounts = new int[10];
//
//		// 第一轮排序
//		// 将元素放到对应的桶
//		for (int j = 0; j < arr.length; j++) {
//			int digitOfElement = arr[j] / 1 % 10;
//			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//			bucketElementCounts[digitOfElement]++;
//		}
//		// 将元素取出
//		// 用一个辅助变量来表示要放入的数组下标的索引
//		int index = 0;
//		for (int k = 0; k < bucketElementCounts.length; k++) {
//			if (bucketElementCounts[k] != 0) {
//				for (int i = 0; i < bucketElementCounts[k]; i++) {
//					arr[index] = bucket[k][i];
//					index++;
//				}
//			}
//			bucketElementCounts[k] = 0;
//		}
//		// 第一轮排序后结果
//		System.out.println("第一轮排序后结果:");
//		System.out.println(Arrays.toString(arr));
//
//		// 第二轮排序
//		// 将元素放到对应的桶
//		for (int j = 0; j < arr.length; j++) {
//			int digitOfElement = arr[j] / 10 % 10;
//			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//			bucketElementCounts[digitOfElement]++;
//		}
//		// 将元素取出
//		// 用一个辅助变量来表示要放入的数组下标的索引
//		index = 0;
//		for (int k = 0; k < bucketElementCounts.length; k++) {
//			if (bucketElementCounts[k] != 0) {
//				for (int i = 0; i < bucketElementCounts[k]; i++) {
//					arr[index] = bucket[k][i];
//					index++;
//				}
//			}
//			bucketElementCounts[k] = 0;
//		}
//		// 第二轮排序后结果
//		System.out.println("第二轮排序后结果:");
//		System.out.println(Arrays.toString(arr));
//
//		// 第三轮排序
//		// 将元素放到对应的桶
//		for (int j = 0; j < arr.length; j++) {
//			int digitOfElement = arr[j] / 100 % 10;
//			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//			bucketElementCounts[digitOfElement]++;
//		}
//		// 将元素取出
//		// 用一个辅助变量来表示要放入的数组下标的索引
//		index = 0;
//		for (int k = 0; k < bucketElementCounts.length; k++) {
//			if (bucketElementCounts[k] != 0) {
//				for (int i = 0; i < bucketElementCounts[k]; i++) {
//					arr[index] = bucket[k][i];
//					index++;
//				}
//			}
//			bucketElementCounts[k] = 0;
//		}
//		// 第三轮排序后结果
//		System.out.println("第三轮排序后结果:");
//		System.out.println(Arrays.toString(arr));
	}
	
	//归纳出来一个方法
	public static void radixSort(int[] arr) {
		//获取数组元素中最长位数元素的位数
		int max = 0;
		for(int k = 0; k < arr.length; k++) {
			if(max < arr[k]) {
				max = arr[k];
			}
		}
		int maxLength = (max + "").length();//注意这是字符串的一个方法
		// 定义一个桶
		int[][] bucket = new int[10][arr.length];
		// 定义一个记录每个桶中含有数据的个数的数组
		int[] bucketElementCounts = new int[10];
		//进行排序
		for(int n = 0 , gap = 10; n < maxLength; n++ , gap *= 10) {
			// 将元素放到对应的桶
			for (int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j] / gap % 10;
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			// 将元素取出
			// 用一个辅助变量来表示要放入的数组下标的索引
			int index = 0;
			for (int k = 0; k < bucketElementCounts.length; k++) {
				if (bucketElementCounts[k] != 0) {
					for (int i = 0; i < bucketElementCounts[k]; i++) {
						arr[index] = bucket[k][i];
						index++;
					}
				}
				bucketElementCounts[k] = 0;
			}
			
		}
//		// 排序后结果
//		System.out.println("排序后结果:");
//		System.out.println(Arrays.toString(arr));
	}
}
