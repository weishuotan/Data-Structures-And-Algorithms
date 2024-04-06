package com.atguigu.linkedlist;

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
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		
		//显示链表
		singleLinkedList.list();
		
	}

}

//定义SingleLinkedList用来管理我们的英雄
class SingleLinkedList{
	
	//先定义一个头节点
	private HeroNode head = new HeroNode(0,"","");
	
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

