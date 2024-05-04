package com.atguigu.my_set;

import java.util.ArrayList;
import java.util.Iterator;

public class My_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//add方法将元素添加到集合中->尾部(add方法一定能添加成功的,所以我们不用boolean接收返回值)
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println(list);
		//void add(int index, E element) ->在指定索引位置上添加元素
		list.add(2,"5");
		System.out.println(list);//索引是从0开始的，在某个位置上添加值之后，该位置及以后的数往后移一位，值填充到该索引上
		//boolean remove(Object o) ->删除指定的元素,删除成功为true,失败为false
		System.out.println(list.remove("6"));
		//E remove(int index) -> 删除指定索引位置上的元素,返回的是被删除的那个元素
		System.out.println(list.remove(2));
		System.out.println(list);
		//E set(int index, E element) -> 将指定索引位置上的元素,修改成后面的element元素
		list.set(0,"1");
		System.out.println(list);
		//E get(int index) -> 根据索引获取元素
		System.out.println(list.get(0));
		//int size()  -> 获取集合元素个数
		System.out.println(list.size());
		//依次取出arraylist集合中的各个元素
		Iterator<String> iterator = list.iterator();//使用Iterator时需要导包，注意第二个iterator是i
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
