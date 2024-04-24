package com.atguigu.class_experiment;

public class ExperimentThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//short与byte的相互转换
//		short b = 19;
//		byte s = (byte)b;
//		System.out.println("s=" + s);
		byte b = 19;
		short s = b;
		System.out.println("s=" + s);
//short和int的相互转换
//		short num = i;
		int i = s;
		System.out.println("i = " + i);
//char和int的相互转换
		char c = 'a';
		int j = c;
		System.out.println("j = " + j);
//int和long的相互转换
		long x = i;
		System.out.println("x = " + x);
//int与float的相互转换
		float f1 = i;
		System.out.println("f1 = " + f1);
//int 和double 的相互转换
		double d1 = i;
		System.out.println("d1 = " + d1);
//long和float的相互转换
		float f2 = x;
		System.out.println("f2 = " + f2);
//long和double的相互转换
		double d2 = x;
		System.out.println("d2 = " + d2);
//float和double的相互转换
		double d3 = f1;
		System.out.println("d3 = " + d3);
	}

}
