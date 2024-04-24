package com.atguigu.class_experiment;

import java.util.Arrays;
import java.util.Scanner;

public class ExperimentTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char name[] = {'谭','炜','烁'};
		System.out.print("谭：");
		System.out.println((int)name[0]);
		System.out.print("炜：");
		System.out.println((int)name[1]);
		System.out.print("烁：");
		System.out.println((int)name[2]);
		
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 8; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int j = 0; j < 4; j++) {
			if(j == 0) {
				System.out.print("   ");
				System.out.print("*");
				System.out.print("   ");
				System.out.println();
			}else if(j == 1) {
				System.out.print("  ");
				System.out.print("***");
				System.out.print("  ");
				System.out.println();
			}else if(j == 2) {
				System.out.print(" ");
				System.out.print("*****");
				System.out.print(" ");
				System.out.println();
			}else {
				System.out.print("*******");
				System.out.println();
			}
		}
		
		for(int i = 0; i < 4; i++) {
			if(i == 0) {
				System.out.println("   *********");
			}else if(i == 1) {
				System.out.println("  ********* ");
			}else if(i == 2) {
				System.out.println(" *********  ");
			}else if(i == 3){
				System.out.println("*********   ");
			}
		}
		
		System.out.println(+5);
		System.out.println(5+6);
		System.out.println(5+'6');
		int num = 56;
		System.out.println("num"+num);
		System.out.println(6+5+"7");
		System.out.println("5"+6+"7");
		System.out.println("5"+'6'+"7");
		System.out.println("5"+'6'+'7');
		//如果是字符与字符串之间的混合的话字符会自动转换为字符串
		//如果是字符与数字之间的混合运算的话字符会变为相应的assic码值
		System.out.println(4 > 9);
		System.out.println(4 < 9);
		System.out.println(4 >= 9);
		System.out.println(4 <= 9);
		System.out.println(4 == 9);
		System.out.println(4 != 9);
		System.out.println((5<9)!=(6==8));
		
		int a = 5;
		System.out.println(a++ + a++);
		System.out.println(a++ + ++a);
		System.out.println(a++ + a++);
		System.out.println(++a + a++);
		System.out.println(++a + ++a);
		
		System.out.println("请输入一个字符串：");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		char[] str1 = str.toCharArray();
		
		for(int i = 0 ;i < str1.length; i++) {
			str1[i] = (char)(str1[i] ^ 8);
		}
		
		System.out.println("加密或后的结果是:");
		System.out.println(new String(str1));
	}
}
