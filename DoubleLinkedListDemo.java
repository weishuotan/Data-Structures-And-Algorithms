package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 测试一下
		// 创建节点
		HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
		HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

		// 创建双向链表，之后添加节点
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);

		// 遍历输出链表
		doubleLinkedList.list();
	}

}

class DoubleLinkedList {
	// 提供一个双向链表的头节点
	private HeroNode2 head = new HeroNode2(0, "", "");

	// 为头节点提供get与set方法
	public HeroNode2 getHead() {
		return head;
	}

	public void setHead(HeroNode2 head) {
		this.head = head;
	}

	// 双向链表的遍历
	public void list() {
		// 链表为空的情况
		if (head.next == null) {
			return;
		}
		// 定义一个辅助变量遍历单链表
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// 双向链表的添加（默认将元素添加在双向链表的最后）
	public void add(HeroNode2 hero) {
		// 定义一个辅助变量寻找到单链表的最后一位
		HeroNode2 temp = head;
		// 寻找最后一位如果找到将flag置为true
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		// 将节点加入到链表的最后

		temp.next = hero;
		hero.pre = temp;

	}

}

class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 pre; // 指向前一个节点
	public HeroNode2 next; // 指向下一个节点

	// 构造器
	public HeroNode2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	// 为了显示的方便我们进行toString的显示
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	// 显示toString的方法：Source->generate tostring()

}