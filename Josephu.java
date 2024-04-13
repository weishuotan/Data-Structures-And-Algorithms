package com.atguigu.linkedlist;

public class Josephu {

	public static void main(String[] args) {
		

	}

}

//创建一个单向环形链表
class CircleSingleLinkedList{
	//创建一个first节点，当前没有编号
	private Boy first = null;
	
	//添加孩子节点的方法
	public void addBoy(int nums) {
		
		
		
	}
	
	
}


//定义一个boy类表示一个孩子节点
class Boy{
	private int no;
	private Boy next;//默认为null
	
	//构造器
	public Boy(int no) {
		this.no = no;
	}
	
	//为no与next提供一个get和set方法
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}