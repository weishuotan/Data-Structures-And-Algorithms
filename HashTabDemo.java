package hashtable;

import java.util.Scanner;

public class HashTabDemo {

	public static void main(String[] args) {
		//创建hashtable
		HashTable hashTable = new HashTable(7);
		//菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("add:添加雇员");
			System.out.println("list:显示雇员");
			System.out.println("find:查找雇员");
			System.out.println("exit:退出操作");
			key = scanner.next();
			switch(key) {
			case "add":
				System.out.println("输入id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
				String name = scanner.next();
				Emp emp =new Emp(id,name);
				hashTable.add(emp);
				break;
			case "list":
				hashTable.list();
				break;
			case "find":
				System.out.println("输入要查找雇员的工号");
				id = scanner.nextInt();
				hashTable.findEmpById(id);
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			default:
				break;
			}
			
		}
	}

}


//创建hashtable管理多个链表
class HashTable{
	private EmpLinkedList[] empLinkedListArray;
	private int maxSize;//表示该哈希表中最多有多少个单链表
	//构造器
	public HashTable(int maxSize){
		this.maxSize = maxSize;
		//初始化整个数组
		empLinkedListArray = new EmpLinkedList[maxSize];
		//初始化每一个单链表
		for(int i = 0; i < maxSize; i++) {
			empLinkedListArray[i] = new EmpLinkedList();	
		}
	}
	//添加雇员
	public void add(Emp emp) {
		int empLinkedListNo = hashFun(emp.id);
		empLinkedListArray[empLinkedListNo].add(emp);
	}
	//遍历所有单链表
	public void list() {
		for(int i = 0; i < maxSize; i++){
			empLinkedListArray[i].list();
		}
	}
	//根据输入的id查找该雇员
	public void findEmpById(int id) {
		int empLinkedListNo = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedListNo].findEmp(id);
		if(emp == null) {
			System.out.println("没有找到");
		}else {
			System.out.printf("在第%d条链表中找到编号为%d的雇员\n",empLinkedListNo + 1,id);
		}
	}
	//散列函数
	public int hashFun(int no) {
		return no % maxSize;
	}
}

//创建员工单链表以及定义单链表中的操作
class EmpLinkedList{
	Emp head = null;  //头指针,指向当前链表中的第一个雇员
	//雇员的相关操作
	//添加雇员
	public void add(Emp emp) {
		//定义一个辅助指针来遍历当前链表
		Emp temp = head;
		//如果当前链表为空
		if(head == null) {
			head = emp;
			return;
		}
		while(true) {
			if(temp.next == null) {
				temp.next = emp;
			}	
			temp = temp.next;
		}
	}
	//遍历链表的雇员信息
	public void list() {
		if(head == null) {
			System.out.println("该链表为空");
		}
		System.out.print("该链表的信息为：");
		//定义一个辅助指针
		Emp temp = head;
		while(temp != null) {
			System.out.printf("=>id=%d name=%s\t",temp.id,temp.name);
			temp = temp.next;
		}
		System.out.println();
	}
	//根据id查找雇员
	public Emp findEmp(int no) {
		//如果该单链表信息为空
		if(head == null) {
			System.out.println("该链表为空");
			return null;
		}
		Emp temp = head;  //辅助指针
		while(true) {
			if(temp.id == no) {
				break;
			}
			if(temp.next == null) {
				temp = null;
				break;
			}
			//第一个if必须在第二个if的前面
			temp = temp.next;
		}
		return temp;
	}
}

//为员工创造一个类
class Emp{
	public int id;
	public String name;
	public Emp next;
	//构造器
	public Emp(int id, String name){
		super();
		this.id = id;
		this.name = name;
	}
}