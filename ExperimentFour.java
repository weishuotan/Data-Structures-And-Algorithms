package com.atguigu.class_experiment;

public class ExperimentFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d1 = 100;
		//double->int
		int i = (int) d1;
		System.out.println("i = " + i);
		//int->char
		int j = 97;
		char c1 = (char)j;
		System.out.println("j = " + j);
		//int->byte
		int k = 128;
		byte b = (byte) k;
		System.out.println("b = " + b);
		//表达式中进行类型转换
		double d2 = 10;
		double d3 = 12;
		int m = (int)(d2 + d3);
		System.out.println("m = " + m);
		
		int n = (int)d2 + k;
		System.out.println("n = " + n);
		
		//浮点数到整数是通过舍去小数点后面的值得到的，因此会造成精度损失
		int x= (int)55.9;
		int y = (int) - 28.89f;
		System.out.println("x = " + x + "y = " + y);
	}

}
