package com.atguigu.huffmantree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class HuffmanTree {

	public static void main(String[] args) {
		String content = "i like like like java do you like a java";
		byte[] contentBytes = content.getBytes();//字符串的一个方法将字符串转换为byte数组
		//List<Node> nodes = getNodes(contentBytes);
		//System.out.println(nodes);
		System.out.println(createHuffmanTree(getNodes(contentBytes)));
		
		System.out.println(getCodes(createHuffmanTree(getNodes(contentBytes))));
		System.out.println(getCodes(createHuffmanTree(getNodes(contentBytes))));
	}
	//统计各字符的数目
	public static List<Node> getNodes(byte[] contentBytes) {
		//创建ArrayList集合
		ArrayList<Node> nodes = new ArrayList<Node>();
		//遍历Bytes统计每一个byte出现的次数
		Map<Byte,Integer> counts = new HashMap<>();
		for(byte b : contentBytes) {
			Integer count = counts.get(b);
			if(count == null) {
				counts.put(b, 1);
			}else {
				counts.put(b, counts.get(b) + 1);
			}
		}
		//将得到的map转换成为nodes节点
		for(Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}
	//构建哈夫曼树
	public static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size()>1) {
			//排序
			Collections.sort(nodes);
			//取出第一颗最小的二叉树
			Node leftNode = nodes.get(0);
			//取出第二课最小的二叉树
			Node rightNode = nodes.get(1);
			//创建一个新的二叉树
			Node parent = new Node(null,leftNode.value+rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			//将已经处理过的删除
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//将新的二叉树加入到nodes中
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	//构建哈夫曼编码
	//将哈夫曼编码存放在Map<Byte,String>中
	static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
	//生成哈夫曼码表时，需要去拼接路径，定义一个StringBuilder存储某个叶子节点的路径
	static StringBuilder stringBuilder = new StringBuilder();
	//重载getCodes的代码
	public static Map<Byte,String> getCodes(Node Root){
		//处理左子树
		getCodes(Root.left,"0",stringBuilder);
		//处理右子树
		getCodes(Root.right,"1",stringBuilder);
		//返回一个结果
		return huffmanCodes;
	}
	
	public static void getCodes(Node node,String Code,StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(Code);
		//判断node是否为空，如果为空则不进行处理
		if(node != null) {
			//判断该节点是叶子节点还是非叶子节点
			if(node.data == null) {
				//说明是叶子节点，进行递归处理
				getCodes(node.left,"0",stringBuilder2);
				getCodes(node.right,"1",stringBuilder2);
			}else {
				huffmanCodes.put(node.data,stringBuilder2.toString());
			}
		}
	}
	
}
//节点类
class Node implements Comparable<Node>{
	int value;
	Byte data;
	Node left;
	Node right;
	//编一个前序遍历的方法
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	//构造器
	public Node(Byte data,int value) {
		this.value = value;
		this.data = data;
	}
	//编写一个toString方法 
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	//从小到大的排序
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.value-o.value;
	}
}