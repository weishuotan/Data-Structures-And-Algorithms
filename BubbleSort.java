package com.atguigu.sort;

import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BubbleSort {

	public static void main(String[] args) {
//		int arr[] = {3,9,-1,10,20};
//		System.out.println("排序前的数组：");
//		System.out.println(Arrays.toString(arr));
//		bubbleSort(arr);
//		System.out.println("排序后的数组：");
//		System.out.println(Arrays.toString(arr));
		
		//随机数据测试程序的运行时间
		int[] arr1 = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr1[i] = (int)(Math.random() * 8000000);
		}
		
		//当前时间
		String DateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序前的时间是=" + DateNow);
		
		bubbleSort(arr1);

		//结束时间
		String DateAfter = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); // 当前日期和时间
		System.out.println("排序后的时间是=" + DateAfter);
		
		/*
		
		//第一趟排序
		for(int j = 0;j < arr.length - 1; j++) {  //length-1表示该指针不能到最后一个，否则arr[j+1]会不存在
			if(arr[j] > arr[j+1]) {
				int temp = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = temp;
			}
		}
		//输出一下
		System.out.println("第一趟排序后的数组：");
		System.out.println(Arrays.toString(arr));
		
		//第二趟排序
		for(int j = 0;j < arr.length - 1 - 1; j++) {  //length-1表示该指针不能到最后一个，否则arr[j+1]会不存在
			if(arr[j] > arr[j+1]) {
				int temp = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = temp;
			}
		}
		//输出一下
		System.out.println("第二趟排序后的数组：");
		System.out.println(Arrays.toString(arr));
		
		//第三趟排序
		for(int j = 0;j < arr.length - 1 - 1; j++) {  //length-1表示该指针不能到最后一个，否则arr[j+1]会不存在
			if(arr[j] > arr[j+1]) {
				int temp = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = temp;
			}
		}
		//输出一下
		System.out.println("第三趟排序后的数组：");
		System.out.println(Arrays.toString(arr));
		
		//第四趟排序
		for(int j = 0;j < arr.length - 1 - 1 - 1 - 1; j++) {  //length-1表示该指针不能到最后一个，否则arr[j+1]会不存在
			if(arr[j] > arr[j+1]) {
				int temp = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = temp;
			}
		}
		//输出一下
		System.out.println("第四趟排序后的数组：");
		System.out.println(Arrays.toString(arr));
		
		*/
		
		
	
	}
	//将推导封装成一个方法
		public static void bubbleSort(int[] arr) {
			boolean flag = false;
			for(int i = 0;i < arr.length - 1; i++) {
				
				for(int j = 0;j < arr.length - 1 - i; j++) {
					if(arr[j] > arr[j+1]) {
						flag = true;
						int temp = arr[j+1];
						arr[j+1] = arr[j];
						arr[j] = temp;
					}	
				}
				if(flag == false) {
					break;
				}else {
					flag = true;
				}
			}
//			System.out.println("排序后的数组：");
//			System.out.println(Arrays.toString(arr));
		}
	
}
