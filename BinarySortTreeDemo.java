package com.atguigu.binarysorttree;

public class BinarySortTreeDemo {

	public static void main(String[] args) {
		int[] arr = {7,3,10,12,5,1,9,2};
		binarySortTree bst = new binarySortTree();
		//创建顺序存储二叉树
		for(int j = 0; j < arr.length; j++) {
			bst.add(new Node(arr[j]));
		}
		//遍历顺序存储二叉树 
		bst.infixList();
		System.out.println();
//		bst.delNode(2);
//		bst.delNode(7);
		bst.delNode(1);
		bst.infixList();
		
	}

}

class binarySortTree{
	private Node Root;
	
	public Node getRoot() {
		return Root;
	}
	
	//添加节点
	public void add(Node node) {
		if(Root == null) {
			Root = node;
		}else {
			Root.add(node);
		}
	}
	
	//前序遍历
	public void infixList() {
		if (Root != null) {
			Root.infixList();
		} else {
			System.out.println("二叉树为空不可bianli");
		}
	}
	//查找目标节点
	public Node search(int value) {
		if(Root == null) {
			return null;
		}else {
			return Root.search(value);
		}
	}
	//查找目标节点的父节点
	public Node searchParent(int value) {
		if(Root == null) {
			return null;
		}else {
			return Root.searchParent(value);
		}
	}
	//删除右子树最小节点
	public Node delMinRightTree(Node node) {
		Node target = node;
		while(target.left != null) {
			target = target.left;
		}
		delNode (target.value);
		return target;
	}
	//删除节点
	public void delNode(int value) {
		//如果Root为空
		if(Root ==null) {
			return;
		}
		//如果Root的左右节点都为空
		if(Root.left == null && Root.right ==null) {
			Root = null;
		}
		//寻找到要删除的最终节点target
		Node target = Root.search(value);
		//寻找要删除节点的父节点
		Node parent = Root.searchParent(value);
		//当删除的是叶子节点时
		if(target.left == null && target.right == null) {
			//判断是父节点的左子节点还是右子节点
			if(parent.left == target) {
				parent.left = null;
			}else if(parent.right == target ){
				parent.right = null;
			}
		}else if(target.left != null && target.right != null) {      //当删除的是有两个子节点的子树时
			Node rightminnode = delMinRightTree(target.right);
			target.value = rightminnode.value;
		}else {     //当删除的是有一个子节点的子树时
			if(target.left != null) {
				if(parent.left == target) {
					parent.left = target.left;
				}else if(parent.right == target) {
					parent.right = target.left;
				}
			}else if(target.right != null) {
				if(parent.left == target) {
					parent.left = target.right;
				}else if(parent.right == target) {
					parent.right = target.right;
				}
			}
		}
	}
	
}


class Node{
	//定义数据类型
	int value;
	Node left;
	Node right;
	//构造器
	public Node(int value) {
		this.value = value;
	}
	//重写toString
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	//搜索该节点
	public Node search(int value) {
		if(this.value == value) {
			return this;
		}else {
			if(this.value > value) {
				return this.left.search(value);
			}else if(this.value <= value) {
				return this.right.search(value);
			}else {
				return null;
			}	
		}
	}
	//搜索该节点的父节点
	public Node searchParent(int value) {
		if((this.left != null && this.left.value == value) || (this.right != null && this.right.value ==value)) {
			return this;
		}else {
			if(this.value > value && this.left != null) {
				return this.left.searchParent(value);
			}else if(this.value <= value && this.right != null) {
				return this.right.searchParent(value);
			}else {
				return null;
			}
		}	
	}
	//添加节点
	public void add(Node node) {
		//判断当前节点是否为空
		if (node == null) {
			return;
		}
		if(node.value < this.value) {
			if(this.left == null) {
				this.left = node; 
			}else {
				this.left.add(node);
			}
		}else if(node.value >= this.value) {
			if(this.right == null) {
				this.right = node;
			}else {
				this.right.add(node);
			}
		}
	}
	//中序遍历
	public void infixList() {
		if(this.left != null) {
			this.left.infixList();
		}
		System.out.println(this);
		if(this.right != null) {
			this.right.infixList();
		}
	}
	
	
}