package com.atguigu.tree.threadbinarytree;

public class ThreadBinaryTreeDemo {
	public static void main(String[] args) {
		//测试
		HeroNode root = new HeroNode(1,"tom");
		HeroNode node2 = new HeroNode(3,"jack");
		HeroNode node3 = new HeroNode(6,"smith");
		HeroNode node4 = new HeroNode(8,"mary");
		HeroNode node5 = new HeroNode(10,"king");
		HeroNode node6 = new HeroNode(14,"dim");
		root.setLeftNode(node2);
		root.setRightNode(node3);
		node2.setLeftNode(node4);
		node2.setRightNode(node5);
		node3.setLeftNode(node6);
		ThreadBinaryTree threadbinarytree = new ThreadBinaryTree();
		threadbinarytree.setRoot(root);
		threadbinarytree.threadNodes(root);
		//查看十号节点的前驱节点和后继节点
		System.out.println(node5.getLeftNode());
		System.out.println(node5.getRightNode());
		
		//测试遍历线索化二叉树
		System.out.println("测试遍历线索化二叉树");
		threadbinarytree.threadList();
	}
}

//二叉树类
class ThreadBinaryTree{
	//需要构建一个根节点
	private HeroNode root;
	//定义一个前驱节点
	private HeroNode pre = null;
	//接收根节点的方法
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	//前序遍历
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	//中序遍历
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	//后序遍历
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	//前序查找
	public HeroNode preOrderSearch(int heroNo) {
		if(this.root == null) {
			System.out.println("该二叉树为空");
			return null;
		}else {
			return this.root.preOrderSearch(heroNo);
		}
	}
	//中序查找
	public HeroNode infixOrderSearch(int heroNo) {
		if(this.root == null) {
			System.out.println("该二叉树为空");
			return null;
		}else {
			return this.root.infixOrderSearch(heroNo);
		}
	}
	//后序查找
	public HeroNode postOrderSearch(int heroNo) {
		if(this.root == null) {
			System.out.println("该二叉树为空");
			return null;
		}else {
			return this.root.postOrderSearch(heroNo);
		}
	}
	
	//删除节点
	public void delNode(int heroNo) {
		if(root != null) {
			if(root.getNo() == heroNo) {
				root = null;
			}else {
				root.delNode(heroNo);
			}
		}else {
			System.out.println("该二叉树是一个空树");
		}
	}
	
	//线索化二叉树
	public void threadNodes(HeroNode node) {
		if(node == null) {
			return;
		}
		//线索化左子树 
		threadNodes(node.getLeftNode());
		//线索化该节点
		//线索化前驱节点
		if(node.getLeftNode() == null) {
			node.setLeftNode(pre);
			node.setLeftType(1);
		}
		//线索化后继节点
		if(pre != null && pre.getRightNode() == null) {
			pre.setRightNode(node);
			pre.setRightType(1);
		}
		//重置pre
		pre = node;
		//线索化右子树
		threadNodes(node.getRightNode());
	}
	
	//遍历线索二叉树
	public void threadList() {
		HeroNode node = root;
		if(node == null) {
			return;
		}
		while(node!= null) {
			while(node.getLeftType() == 0) {
				node = node.getLeftNode();
			}
			System.out.println(node);
			while(node.getRightType() != 0) {
				node = node.getRightNode();
				System.out.println(node);
			}
			node = node.getRightNode();
		}
	}
	
}

//定义节点对象
class HeroNode{
	//声明数据类型
	private int no;
	private String name;
	private HeroNode leftNode;
	private HeroNode rightNode;
	private int leftType;//leftType=0表示指向的是左子树，leftType=1表示指向前驱节点
	private int rightType;//rightType=0表示指向的是左子树，rightType=1表示指向前驱节点
	//构造器
	public HeroNode(int no, String name){
		this.no = no;
		this.name = name;
	}
	//为数据类型提供get/set方法
	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeroNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(HeroNode leftNode) {
		this.leftNode = leftNode;
	}
	public HeroNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(HeroNode rightNode) {
		this.rightNode = rightNode;
	}
	//为节点提供一个toString的方法
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	//开始书写前序遍历中序遍历和后序遍历
	public void preOrder() {
		//先输出根节点
		System.out.println(this);
		//向左递归
		if(this.leftNode != null) {
			this.leftNode.preOrder();
		}
		//向右递归
		if(this.rightNode != null) {
			this.rightNode.preOrder();
		}
	}
	public void infixOrder() {
		//向左递归
		if(this.leftNode != null) {
			this.leftNode.infixOrder();
		}
		//输出根节点
		System.out.println(this);
		//向右递归
		if(this.rightNode != null) {
			this.rightNode.infixOrder();
		}
	}
	public void postOrder() {
		//向左递归
		if(this.leftNode != null) {
			this.leftNode.postOrder();
		}
		//向右递归
		if(this.rightNode != null) {
			this.rightNode.postOrder();
		}
		// 输出根节点
		System.out.println(this);
	}
	
	//前序遍历查找
	public HeroNode preOrderSearch(int heroNo) {
		//先定义一个空结点
		HeroNode resNode = null;
		//先判断当前节点是不是
		if(heroNo == this.no) {
			return this;
		}
		//向左遍历查找
		if(this.leftNode != null) {
			resNode = this.leftNode.preOrderSearch(heroNo);
		}
		if(resNode != null) {
			return resNode;
		}
		//向右遍历查找
		if(this.rightNode != null) {
			resNode = this.rightNode.preOrderSearch(heroNo);
		}
		if(resNode != null) {
			return resNode;
		}
		return resNode;
	} 
	//中序遍历查找
	public HeroNode infixOrderSearch(int heroNo) {
		//先定义一个空结点
		HeroNode resNode = null;
		//向左遍历查找
		if(this.leftNode != null) {
			resNode = this.leftNode.infixOrderSearch(heroNo);
		}
		if(resNode != null) {
			return resNode;
		}
		// 先判断当前节点是不是
		if (heroNo == this.no) {
			return this;
		}
		//向右遍历查找
		if(this.rightNode != null) {
			resNode = this.rightNode.infixOrderSearch(heroNo);
		}
		if(resNode != null) {
			return resNode;
		}
		return resNode;
	} 
	//后序遍历查找
	public HeroNode postOrderSearch(int heroNo) {
		//先定义一个空结点
		HeroNode resNode = null;
		//向左遍历查找
		if(this.leftNode != null) {
			resNode = this.leftNode.postOrderSearch(heroNo);
		}
		if(resNode != null) {
			return resNode;
		}
		//向右遍历查找
		if(this.rightNode != null) {
			resNode = this.rightNode.postOrderSearch(heroNo);
		}
		if(resNode != null) {
			return resNode;
		}
		// 如果左右子树的节点没有一个是的所以判断当前节点是不是
		if (heroNo == this.no) {
			return this;
		}
		//判断完之后
		return resNode;
	}
	
	//删除节点
	public void delNode(int heroNo) {
		if(this.leftNode != null && this.leftNode.no == heroNo) {
			this.leftNode = null;
			return;
		}
		if(this.rightNode != null && this.rightNode.no == heroNo) {
			this.rightNode = null;
			return;
		}
		if(this.leftNode != null) {
			this.leftNode.delNode(heroNo);
		}
		if(this.rightNode != null) {
			this.rightNode.delNode(heroNo);
		}
	}
	
	
}