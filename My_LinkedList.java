package com.atguigu.my_set;

import java.util.LinkedList;

public class My_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		  - public void addFirst(E e):将指定元素插入此列表的开头。
		LinkedList<String> linkedlist = new LinkedList<>();
		linkedlist.add("a");
		linkedlist.add("b");
		linkedlist.add("c");
		linkedlist.add("d");
		System.out.println(linkedlist);
		linkedlist.addFirst("0");
		System.out.println(linkedlist);
//		  - public void addLast(E e):将指定元素添加到此列表的结尾。
		linkedlist.addLast("e");
		System.out.println(linkedlist);
//		  - public E getFirst():返回此列表的第一个元素。
		System.out.println(linkedlist.getFirst());
//		  - public E getLast():返回此列表的最后一个元素。
		System.out.println(linkedlist.getLast());
//		  - public E removeFirst():移除并返回此列表的第一个元素。
		linkedlist.removeFirst();
		System.out.println(linkedlist);
//		  - public E removeLast():移除并返回此列表的最后一个元素。
		linkedlist.removeLast();
		System.out.println(linkedlist);
//		  - public E pop():从此列表所表示的堆栈处弹出第一个元素。
		linkedlist.pop();
		System.out.println(linkedlist);
//		  - public void push(E e):将元素推入此列表所表示的堆栈。
		linkedlist.push("a");//加在第一个
		System.out.println(linkedlist);
//		  - public boolean isEmpty()：如果列表没有元素，则返回true。
		System.out.println(linkedlist.isEmpty());
	}

}
