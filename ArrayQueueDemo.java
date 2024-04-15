package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// 测试
		// 声明队列
		ArrayQueue queue = new ArrayQueue(3);
		// 创建输入对象
		Scanner scanner = new Scanner(System.in);
		// 创建接收值
		char key;
		// 设置无限循环变量
		boolean loop = true;
		// 循环菜单
		while (loop) {
			System.out.println("s(show)显示队列");
			System.out.println("e(exit)退出程序");
			System.out.println("a(add)添加数据到队列");
			System.out.println("g(get)提取队列中的数据");
			System.out.println("h(head)查看队列的头元素");
			// 输入需求
			key = scanner.next().charAt(0);// 接收一个字符
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个元素：");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("输出的数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());// 获取异常信息
				}
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("输出的数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());// 获取异常信息
				}
				break;
			case 'e':
				scanner.close();// 不关闭的话会出现警告
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序退出！");
	}
}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {
	// 基本元素
	private int maxSize; // 数组的最大长度
	private int front; // front为头指针
	private int rear; // rear为尾指针
	private int[] arr; // 为队列建立的一个数组

	// 队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		front = -1; // 指向队列头部，指的是第一个元素的前一个位置
		rear = -1; // 指向队列尾部，即是队列的最后一个元素的位置
		arr = new int[maxSize];
	}

	// 判断队列是否满的方法
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 向队列中添加元素
	public void addQueue(int n) {
		// 判断队列是否满
		if (isFull()) {
			System.out.println("队列满了，不能加入数据了呦");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	// 从队列中获取元素
	public int getQueue() {
		// 判断队列是否为空
		if (isEmpty()) {
			throw new RuntimeException("队列空不能取元素！");
			// 抛出异常之后的语句都不在被执行，所以不用再写return;
		}
		front++;
		return arr[front];
	}

	// 显示队列中的所有元素
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("数组中没有元素！");
			return;
		}
		// 遍历显示队列中的元素
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
	}

	// 显示队列的头数据
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空！");
		}
		// 打印队列的头数据
		return arr[front];
	}
}
