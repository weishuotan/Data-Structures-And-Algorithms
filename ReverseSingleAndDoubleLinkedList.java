package reverselist;

import java.util.ArrayList;

public class ReverseSingleAndDoubleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testList();
	}
	
	//单链表
	public static Node reverseSingleLinkedList(Node head) {
		if(head == null || head.next == null) {  //当链表为空或者只有一个元素时直接返回head本身
			return head;  //如果函数的返回类型不是void的话返回为空时必须写null
		}
		//定义两个引用指针
		Node pre = null;
		Node next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	//对数器容器同等构建后返回结构比对  容器的方法实现逆序链表
	public static Node testReverseSingleLinkedList(Node head) {
		if(head == null) {
			return null;
		}
		ArrayList<Node> list = new ArrayList<>();
		//进容器
		while(head != null) {
			list.add(head);
			head = head.next;
		}
		int N = list.size();
		// 缺少一个队尾指针指向空的动作
		list.get(0).next = null;
		//改变指针方向  
		for(int j = 1; j < N; j++) {
			list.get(j).next = list.get(j-1);
		}

		//返回头指针
		return list.get(N-1);
	}
	//生成一个长度随机值也随机链表
	public static Node generateSingleLinkedList(int len,int value) {
		//随机生成长度
		int size = (int)(Math.random()*(len+1));
		if(size == 0) {
			return null;
		}
		Node head = new Node((int)(Math.random()*(value+1)));
		Node pre = head;
		size--;//已经生成了一个头节点所以要在原来的基础上减一
		while(size != 0) {
			Node cur = new Node((int)(Math.random()*(value+1)));
			pre.next = cur;
			pre = cur;
			size--;
		}
		return head;
	}
	//生成一个与随机链表相同的容器
	public static ArrayList<Integer> getLinkedListOriginOrder(Node head){
		ArrayList<Integer> ans = new ArrayList<>();
		while(head != null) {
			ans.add(head.value);
			head = head.next;
		}
		return ans;
	}
	//将随机链表与容器结合进行比较的方法
	public static boolean checkLinkedListReverse(ArrayList<Integer> origin, Node head) {
		while (head != null) {
			for (int j = origin.size() - 1; j >= 0; j--) {
				if (!origin.get(j).equals(head.value)) {
					return false;
				}
				head = head.next;
			}
		}
		return true;
	}
	//总的测试方法
	public static void testList(){
		int len = 50;
		int value = 100;
		int testTime = 100;
		System.out.println("测试开始");
		for(int j = 0; j < testTime; j++) {
			Node node1 = generateSingleLinkedList(len,value);
			ArrayList<Integer> test1 = getLinkedListOriginOrder(node1);
			node1 = reverseSingleLinkedList(node1);
			if(!checkLinkedListReverse(test1,node1)) {
				System.out.println("False01");
			}
			
			Node node2 = generateSingleLinkedList(len,value);
			ArrayList<Integer> test2 = getLinkedListOriginOrder(node2);
			node2 = testReverseSingleLinkedList(node2);
			if(!checkLinkedListReverse(test2,node2)) {
				System.out.println("False02");
			}
		}
		System.out.println("测试结束");
		
	}
	
}


class Node{
	int value;
	Node next;
	public Node(int value) {
		this.value = value;
	}
}