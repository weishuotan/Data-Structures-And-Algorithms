package com.atgugiu.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		//测试三种遍历
		BinaryTree binarytree = new BinaryTree();
		//生成节点
		HeroNode hero1 = new HeroNode(1,"宋江");
		HeroNode hero2 = new HeroNode(2,"吴用");
		HeroNode hero3 = new HeroNode(3,"卢俊义");
		HeroNode hero4 = new HeroNode(4,"林冲");
		HeroNode hero5 = new HeroNode(5,"关胜");
		//手动创建二叉树
		hero1.setLeftNode(hero2);
		hero1.setRightNode(hero3);
		hero3.setRightNode(hero4);
		hero3.setLeftNode(hero5);
		//遍历二叉树
		binarytree.setRoot(hero1);
		System.out.println("前序遍历");
		binarytree.preOrder();
		System.out.println("中序遍历");
		binarytree.infixOrder();
		System.out.println("后序遍历");
		binarytree.postOrder();
		
		//查找节点的测试
		System.out.println("前序遍历查找方式");
		HeroNode resNode1 = binarytree.preOrderSearch(5);
		if(resNode1 != null) {
			System.out.printf("找到了，信息为：no = %d,name = %s\n",resNode1.getNo(),resNode1.getName());;
		}else {
			System.out.println("非常抱歉没有找到");
		}
		
		System.out.println("中序遍历查找方式");
		HeroNode resNode2 = binarytree.infixOrderSearch(5);
		if(resNode2 != null) {
			System.out.printf("找到了，信息为：no = %d,name = %s\n",resNode2.getNo(),resNode2.getName());;
		}else {
			System.out.println("非常抱歉没有找到");
		}
		
		System.out.println("后序遍历查找方式");
		HeroNode resNode3 = binarytree.postOrderSearch(5);
		if(resNode3 != null) {
			System.out.printf("找到了，信息为：no = %d,name = %s\n",resNode3.getNo(),resNode3.getName());;
		}else {
			System.out.println("非常抱歉没有找到");
		}
		
		//删除节点的测试
		System.out.println("删除节点的测试:删除前");
		binarytree.preOrder();
		binarytree.delNode(5);
		System.out.println("删除后：");
		binarytree.preOrder();
	}	
}

//二叉树类
class BinaryTree{
	//需要构建一个根节点
	private HeroNode root;
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
}

//定义节点对象
class HeroNode{
	//声明数据类型
	private int no;
	private String name;
	private HeroNode leftNode;
	private HeroNode rightNode;
	//构造器
	public HeroNode(int no, String name){
		this.no = no;
		this.name = name;
	}
	//为数据类型提供get/set方法
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