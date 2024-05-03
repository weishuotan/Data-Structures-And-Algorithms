package com.atguigu.tree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		//测试
		int[] arr = {1,2,3,4,5,6,7};
		ArrBinaryTree arrbinarytree = new ArrBinaryTree(arr);
		System.out.println("前序遍历");
		arrbinarytree.preOrder(0);
		System.out.println("中序遍历");
		arrbinarytree.infixOrder(0);
		System.out.println("后序遍历");
		arrbinarytree.postOrder(0);
	}
}

class ArrBinaryTree{
	private int[] arr;
	//定义一个构造器
	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	//编写方法实现顺序存储二叉树的前序遍历
	public void preOrder(int index) {
		//数组为空或者arr.length等于0
		if(arr.length == 0 || arr == null) {
			System.out.println("该数组为空");
		}
		//输出当前元素
		System.out.println(arr[index]);
		//向左递归
		if(index * 2 + 1 < arr.length) {
			preOrder(index * 2 + 1);
		}
		//向右递归
		if(index * 2 + 2 < arr.length) {
			preOrder(index * 2 + 2);
		}
	}
	//编写方法实现顺序存储二叉树的中序遍历
	public void infixOrder(int index) {
		//数组为空或者arr.length等于0
		if(arr.length == 0 || arr == null) {
			System.out.println("该数组为空");
		}
		//向左递归
		if(index * 2 + 1 < arr.length) {
			infixOrder(index * 2 + 1);
		}
		// 输出当前元素
		System.out.println(arr[index]);
		//向右递归
		if(index * 2 + 2 < arr.length) {
			infixOrder(index * 2 + 2);
		}
	}
	//编写方法实现顺序存储二叉树的后序遍历
	public void postOrder(int index) {
		//数组为空或者arr.length等于0
		if(arr.length == 0 || arr == null) {
			System.out.println("该数组为空");
		}
		//向左递归
		if(index * 2 + 1 < arr.length) {
			postOrder(index * 2 + 1);
		}
		//向右递归
		if(index * 2 + 2 < arr.length) {
			postOrder(index * 2 + 2);
		}
		// 输出当前元素
		System.out.println(arr[index]);
	}
}