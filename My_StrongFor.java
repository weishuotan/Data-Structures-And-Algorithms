package com.atguigu.my_collection;

import java.util.LinkedList;

public class My_StrongFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		for(String str: list) {
			System.out.println(str);
		}
		
		int[] arr = {1,2,3,4,5};
		for(int i : arr) {
			System.out.println(i);
		}
//		1.增强for遍历集合时,底层实现原理为迭代器
//		2.增强for遍历数组时,底层实现原理为普通for
	}
}
