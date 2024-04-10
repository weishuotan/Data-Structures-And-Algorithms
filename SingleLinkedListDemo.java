package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		//进行测试
		//创建属性节点
		HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
		HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
		HeroNode hero3 = new HeroNode(3,"吴用","智多星");
		HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
		
		//创建管理对象
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		//添加节点方式1
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		singleLinkedList.add(hero4);
		
		//显示链表
		singleLinkedList.list();
		
		//添加节点方式2
//		singleLinkedList.addByOrder(hero4);
//		singleLinkedList.addByOrder(hero2);
//		singleLinkedList.addByOrder(hero1);
//		singleLinkedList.addByOrder(hero3);
		
		//显示链表
//		singleLinkedList.list();
		
		//修改链表信息
//		HeroNode newHeroNode = new HeroNode(2,"小卢","玉麒麟~~");
//	    singleLinkedList.update(newHeroNode);
		
		//显示链表
//	    singleLinkedList.list();
		
		//删除节点功能
//		singleLinkedList.del(1);
//		singleLinkedList.del(4);
		
		//显示链表
//		singleLinkedList.list();
		
		//求单链表中有效节点个数
//		System.out.println("单链表中有效节点的个数：");
//		System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
		
		//查找单链表的倒数第k个节点
//		HeroNode findlastindexnode = new HeroNode(0,"","");
//		System.out.printf("单链表的倒数第k个节点是:\n");
//		findlastindexnode = singleLinkedList.findLastIndexNode(singleLinkedList.getHead(),4);
//		System.out.println(findlastindexnode);
		
		//将单链表进行反转
		singleLinkedList.reversetList(singleLinkedList.getHead());
		singleLinkedList.list();
		
		//逆序输出单链表
		singleLinkedList.reverseprint(singleLinkedList.getHead());
	}

}

//定义SingleLinkedList用来管理我们的英雄
class SingleLinkedList{
	
	//先定义一个头节点
	private HeroNode head = new HeroNode(0,"","");
	
	//为私有头节点提供get与set方法
	public HeroNode getHead() {
		return head;
	}

	public void setHead(HeroNode head) {
		this.head = head;
	}
	
	//添加节点到单链表
	public void add(HeroNode heroNode) {
		//由于头节点不能移动因此我们需要定义一个辅助节点帮助我们寻找添加位置
		HeroNode temp = head;
		
		//遍历链表找到最后的位置
		while(true) {
			if(temp.next == null) {
				break;
			}
			//找不到将temp后移
			temp = temp.next;
		}
		
		//将节点添加到最后一个节点的下一个位置
		temp.next = heroNode;
	}

	//添加节点到单链表的第二种方式
	public void addByOrder(HeroNode heroNode) {
		//定义一个辅助节点来进行插入位置的寻找
		HeroNode temp = head;
		
		//由于是单链表因此只需要找到该节点的前一个节点进行添加
		while(true) {
			//如果该单链表没有任何节点
			if(temp.next == null) {
				heroNode.next = temp.next;
				temp.next = heroNode;
				break;
			}
			
			//如果单链表中有其他节点
			if(heroNode.no < temp.next.no) {
				heroNode.next = temp.next;
				temp.next = heroNode;
				break;
			}else if(heroNode.no == temp.no){
				System.out.println("要插入的节点重复！");
				break;
			}
			
			//将节点后移
			temp = temp.next;
		}
	}
	
	//显示链表
	public void list() {
		//如果链表为空输出相应的语句
		if(head.next == null) {
			System.out.println("链表为空！");
		}
		
		//如果链表不为空，定义一个辅助变量帮助我们遍历链表
		HeroNode temp = head.next;
		
		//遍历链表
		while(true) {
			//遍历到最后结束循环
			if(temp == null) {
				break;
			}
			
			//输出节点信息
			System.out.println(temp);
			
			//temp后移
			temp = temp.next;
		}	
	}
	
	//修改节点信息
	public void update(HeroNode newHeroNode) {
		//先通过遍历直接找到该节点
		//定义一个辅助变量
		HeroNode temp = head;
		
		//定义一个flag表示是否找到该节点
		boolean flag = false;
		
		//进行遍历
		while(true) {
			//链表为空的情况
			if(temp.next == null) {
				System.out.println("链表为空！");
				break;
			}
			
			//链表不为空的情况
			if(temp.next.no == newHeroNode.no) {
				flag = true;
				break;
			}
			
			//将节点下移
			temp = temp.next;
		}
		
		//修改信息
		if(flag == false) {
			System.out.println("单链表中没有该节点!");
		}else {
			temp.next.no = newHeroNode.no;
			temp.next.name = newHeroNode.name;
			temp.next.nickname = newHeroNode.nickname;
		}
	}
	
	//删除节点信息
	public void del(int no) {
		//定义一个辅助循环变量
		HeroNode temp = head;
		
		//flag用来判断是否找到该节点
		boolean flag = false;
		
		//寻找要删除节点的前一个节点
		while(true) {
			if(temp.next == null) {
				break;
			}else if(temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		//删除找到的节点
		if(flag == false) {
			System.out.printf("链表中没有编号为：%d的节点",no);
		}else {
			temp.next = temp.next.next;
		}
	}
	
	//查询单链表中有效节点的个数
	public static int getLength(HeroNode head) {
		if(head.next == null) {
			return 0;
		}
		
		int length = 0; //定义一个计数变量
		
		//定义一个辅助变量来遍历链表
		HeroNode cur = head.next;
		
		while(cur != null) {
			length++;
			cur = cur.next;
		}
		
		return length;
	}
	
	//查找单链表的第k个节点
	//index表是找的是倒数第index个节点
	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		//如果单链表为空表示没有找到
		if(head.next == null) {
			return null;
		}
		//求出有效节点的个数
		int size = getLength(head);
		//对index进行校验
		if(index <= 0 || index > size) {
			return null;
		}
		//遍历前size-index个得到的即是倒数第index个节点
		HeroNode cur = head.next;//辅助变量，用于遍历
		for(int i = 0;i < size - index;i++) {
			cur = cur.next;
		}
		return cur;
	}
	
	//单链表的反转
	public static void reversetList(HeroNode head) {
		//如果链表为空或者链表中只有一个节点则不用反转
		if(head.next == null || head.next.next == null) {
			return;
		}
		
		HeroNode reverseHead = new HeroNode(0,"","");  //先定义一个新节点
		HeroNode cur = head.next;  //定义一个辅助变量指向当前变量用来遍历
		HeroNode next = null;//定义一个辅助变量指向当前节点cur的下一个值
		
		//开始遍历原来的链表并完成相应工作
		while(cur != null) {
			next = cur.next;  //暂时保存当前节点的下一个节点因为后面有用
			cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
			reverseHead.next = cur;  //将cur连接到新的链表上
			cur = next;  //让cur指向下一个节点
		}
		
		//将head.next指向reverseHead.next，实现单链表的反转
		head.next = reverseHead.next;
	}
	
	//将单链表逆序输出
	public static void reverseprint(HeroNode head) {
		if(head.next == null) {
			return;
		}
		//创建一个栈把所有节点压入栈
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		//将链表中的元素压入栈
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;	
		}
		//再将栈中的元素pop打印即可实现逆序操作
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
	}
	
}


//定义HeroNode中的属性相当于之前语言中的结构体
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//指向下一个节点，只有这样单链表才会连接起来
	
	//构造器
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	
	//为了显示的方便我们进行toString的显示
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname +  "]";
	}
	//显示toString的方法：Source->generate tostring()
}

