package skiplist;

import java.util.Arrays;

public class SkipListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}

}


class MySkipList{
	//设置最大层数与跳层所要达到的概率
	public static final int MaxLevel = 32;
	public static final double SKIPLIST_P = 0.25;
	// 设置变量表示当前层和每一层的头节点head,并将当前层的数值设置为0表示在第一层
	// 由于head是表示每一层的的头节点所以将head的值设置为-1
	public int curLevel;
	public Node head;

	public MySkipList() {
		this.curLevel = 0;
		this.head = new Node(-1, MaxLevel);// 对每一层生成一个头节点
	}
	//概率设计
	public int randomLevel(){
		int level = 1;
		while(Math.random() < SKIPLIST_P && level < MaxLevel) {
			level++;
		}
		return level;
	}

	//添加元素的操作
	public void add(int num) {
		//首先要想更新链表必须现申请一个链表将原来的链表全都copy进来
		Node[] update = new Node[MaxLevel];
		Arrays.fill(update, head);
		Node cur = this.head;//一定要在for循环的外部写因为每一次循环cur的指针都不会回退
	    //然后通过遍历update各个链表，将指针放到插入节点的前一个节点
		for(int i = curLevel - 1; i >= 0; i--) {
			while(cur.next[i]!=null && cur.next[i].val<num) {
				cur=cur.next[i];
			}
			update[i]=cur;//此时就把前一个节点的位置存放在update数组中
		}
		//生成插入元素的随机层数
		int randomlevel = randomLevel();
		//将当前层的层数更新
		this.curLevel = Math.max(this.curLevel,randomlevel);
		//生成要插入的节点
		Node newNode = new Node(num,randomlevel);
		//插入节点
		for(int i=0;i<randomlevel;i++) {
			newNode.next[i]=update[i].next[i];
			update[i].next[i]=newNode;
		}
	}
	//查找元素的操作
	public boolean search(int target) {
		Node cur = this.head;
		for(int i=this.curLevel-1;i>=0;i--) {
			while(cur.next[i]!=null && cur.next[i].val<target) {
				cur=cur.next[i];
			}
		}
		cur = cur.next[0];
		return cur!=null && cur.val==target;
	}
	//删除元素的操作
	public boolean delete(int num) {
		//和之前一样先用一个数组存储要删除的数的每一个的前一个节点
		Node[] update = new Node[MaxLevel];
		Node cur = this.head;
		for(int i=curLevel-1;i>=0;i--) {
			while(cur.next[i]!=null && cur.next[i].val<num) {
				cur=cur.next[i];
			}
			update[i]=cur;
		}
		cur=cur.next[0];
		//如果删除的值不存在时
		if(cur==null||cur.val!=num) {
			return false;
		}
		//开始删除元素，从下向上层层遍历，遇到第一个update的i的相应的值不等于cur时终止
		for(int i = 0;i<curLevel;i++) {
			if(update[i].next[i]!=cur) {
				break;
			}
			//delete
			update[i].next[i]=cur.next[i];
		}
		//如果时删除最上层的节点只有一个要删除的节点则需要将层数进行更新
		if(curLevel>1&&head.next[curLevel-1]==null) {
			curLevel--;
		}
		return true;
	}
	
}
//创建节点类
class Node{
	int val; //当前节点的值
	//当前层中的每一个节点的下一个节点，node.next[i]表示第i层中node节点的下一个节点
	Node[] next;
	public Node(int val,int maxLevel) {
		this.val = val;
		this.next = new Node[maxLevel];
	}
}