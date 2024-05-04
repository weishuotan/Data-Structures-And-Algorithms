package com.atguigu.my_set;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class My_Map {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<>();
//		  V put(K key, V value)  -> 添加元素,key唯一,value可重复 -> 如果key重复了,会发生value覆盖
		map.put("1", "12");
		map.put("2", "11");
		map.put("3", "10");
		map.put("4", "9");
		map.put("5", "8");
		map.put("6", "7");
		map.put("1", "12");
		System.out.println(map);
//		  V remove(Object key)  ->根据key删除键值对,返回的是被删除的value
		System.out.println(map.remove("6"));//如果键不存在返回null
		System.out.println(map);
//		  V get(Object key) -> 根据key获取value
		System.out.println(map.get("1"));
//		  boolean containsKey(Object key)  -> 判断集合中是否包含指定的key
		System.out.println(map.containsKey("1"));
		
		
//		  Collection<V> values() -> 获取集合中所有的value,转存到Collection集合中
		Collection<String> collections = map.values();    
		System.out.println(collections);
//		  Set<K> keySet()->将Map中的key获取出来,转存到Set集合中 
		Set<String> set = map.keySet();
		System.out.println(set);
//		  Set<Map.Entry<K,V>> entrySet()->获取Map集合中的键值对,转存到Set集合中
		Set<Map.Entry<String,String>> set2 = map.entrySet();
		System.out.println(set2);
		
		
//		两种遍历方式
		Set<String> set3 = map.keySet();
		for(String key:set3) {
			System.out.println(key+":"+map.get(key));
		}
		
		Set<Map.Entry<String, String>> set4 = map.entrySet();
		for(Map.Entry<String, String> entry : set4) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
	}

}
