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

		// 修改链表中节点的值
		System.out.println("修改单链表某节点后的单链表：");
		HeroNode2 newHeroNode = new HeroNode2(4, "豹子头", "林冲");
		doubleLinkedList.update(newHeroNode);
		doubleLinkedList.list();

		// 删除单链表中的某个节点
		System.out.println("删除单链表中第四个节点后：");
		doubleLinkedList.del(4);
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

	// 双向链表的节点的修改
	public void update(HeroNode2 newHeroNode) {
		// 链表为空的情况
		if (head.next == null) {
			return;
		}
		// 先通过遍历得到要修改节点的位置
		// 定义一个辅助变量
		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 修改节点的值
		if (flag == true) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("编号为%d的节点没有找到,不能修改\n", newHeroNode.no);
		}
	}

	// 删除双向链表中的某个节点
	public void del(int no) {
		// 单链表为空的情况
		if (head.next == null) {
			return;
		}
		//
		boolean flag = false;
		HeroNode2 temp = head.next;

		// 直接遍历到该节点
		while (true) {
			if(temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}

		// 删除该节点
		if (flag == true) {
			temp.pre.next = temp.next;
			temp.next.pre = temp.pre;
			//如果是最后一个节点就不需要执行这一句话
			//if(temp.next != null) {
			//	temp.next.pre = temp.pre;
			//}
		}else {
			System.out.printf("编号为%d的节点没有\n",no);
		}

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