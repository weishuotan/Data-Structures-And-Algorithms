package algorithm_class_four;

public class BasicSingleAndDoubleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 单链表
		Node one = new Node(1);
		Node two = new Node(3);
		Node three = new Node(2);
		Node four = new Node(4);
		SingleLinkedListDemo singlelinkedlist = new SingleLinkedListDemo();
		singlelinkedlist.addByOrder(one);
		singlelinkedlist.addByOrder(two);
		singlelinkedlist.addByOrder(three);
		singlelinkedlist.addByOrder(four);
		singlelinkedlist.list();
		System.out.println();
		singlelinkedlist.deleteNode(5);
		singlelinkedlist.list();
		System.out.println();
		singlelinkedlist.uodate(1,8);
		singlelinkedlist.list();
		//双链表
		System.out.println();
		Node2 a = new Node2(6);
		Node2 b = new Node2(7);
		Node2 c = new Node2(8);
		Node2 d = new Node2(9);
		DoubleLinkedList doublelinkedlist = new DoubleLinkedList();
		doublelinkedlist.addNode(a);
		doublelinkedlist.addNode(b);
		doublelinkedlist.addNode(c);
		doublelinkedlist.addNode(d);
		doublelinkedlist.list();
		System.out.println();
		doublelinkedlist.delNode(d);
		doublelinkedlist.list();
		System.out.println();
		doublelinkedlist.uodate(8,6);
		doublelinkedlist.list();
		//反转单链表
		System.out.println();
		singlelinkedlist.list();
		System.out.println();
		Node head2 = SingleLinkedListDemo.ReverseSingleLinkedList(one);
		System.out.println(head2);
		singlelinkedlist.list();

	}

}

//单链表
class SingleLinkedListDemo {
	Node head = new Node(0);

	// 增(直接在末尾增加)
	public void addNodes(int value) {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(value);
	}

	// 增(增加的同时进行排序，如果有这个元素则报错)
	public void addByOrder(Node node) {
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			} else if (temp.next.value > node.value) {
				break;
			} else if (temp.next.value == node.value) {
				return;
			} else {
				temp = temp.next;
			}
		}
		Node temp2 = temp.next;
		temp.next = node;
		node.next = temp2;

	}

	// 删
	public void deleteNode(int value) {
		Node temp = head;
		if (temp.next == null) {
			return;
		}

		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				flag = false;
				break;
			} else if (temp.next.value == value) { // if与else if的这个顺序是不能发生变化的
				flag = true;
				break;
			} else {
				temp = temp.next;
			}
		}
		if (flag == true) {
			temp.next = temp.next.next;
		} else {
			return;
		}

	}

	// 改
	public void uodate(int value,int newvalue) {
		Node temp = head.next;
		if (temp == null) {
			return;
		}
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				flag = false;
				break;
			} else if (temp.value == value) {
				flag = true;
				break;
			} else {
				temp = temp.next;
			}
		}
		if(flag = true) {
			temp.value = newvalue;
		}else {
			return;
		}
		
	}

	// 查
	public void list() {
		Node temp = head.next;
		while (temp != null) {
			System.out.print(temp);
			temp = temp.next;
		}
	}
	
	//反转单链表
	public static Node ReverseSingleLinkedList(Node head) {
		if(head == null ||head.next == null) {
			return null;
		}
		//声明两个Node型变量记录前后值
		Node next = null;
		Node pre = null;
		//
		while(head != null) {
			next = head.next;
		    head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
//双向链表
class DoubleLinkedList{
	//定义一个头节点
	Node2 head = new Node2(0);
	//增
	public void addNode(Node2 node) {
		Node2 temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				flag = true;
				break;
			}else {
				temp = temp.next;
			}
		}
		temp.next = node;
		node.last = temp;
	}
	//删
	public void delNode(Node2 node) {
		Node2 temp = head;
		if(temp.next == null) {
			return;
		}
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				flag = false;
				break;
			}else if(temp.next == node) {
				flag = true;
				break;
			}else {
				temp = temp.next;
			}
		}
		if(flag == true) {
			if(temp.next.next == null) {
				temp.next = null;
			}else {
				temp.next = node.next;
				node.next.last = temp;
			}
		}
	}
	//改
	public void uodate(int value,int newvalue) {
		Node2 temp = head.next;
		if (temp == null) {
			return;
		}
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				flag = false;
				break;
			} else if (temp.value == value) {
				flag = true;
				break;
			} else {
				temp = temp.next;
			}
		}
		if(flag = true) {
			temp.value = newvalue;
		}else {
			return;
		}
		
	}
	//查
	public void list() {
		Node2 temp = head.next;
		while (temp != null) {
			System.out.print(temp);
			temp = temp.next;
		}
	}
	
}



//单链表的节点结构
class Node {
	public int value;
	public Node next;

	public Node(int data) { // 其中int可以写成泛型
		value = data;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

}

//双向链表的节点结构
class Node2 {
	public int value;
	public Node2 last;
	public Node2 next;

	public Node2(int data) {
		value = data;
	}

	@Override
	public String toString() {
		return "Node2 [value=" + value + "]";
	}
	
	
}