package com.atguigu.class_experiment;

import java.util.Scanner;

public class ExperimentOne {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int score = scanner.nextInt();
//		int grade = (int) score / 10;
//		switch (grade) {
//		case 10:
//		case 9:
//			System.out.println("优");
//			break;
//		case 8:
//			System.out.println("良");
//			break;
//		case 7:
//			System.out.println("中");
//			break;
//		case 6:
//			System.out.println("及格");
//			break;
//		case 5:
//		case 4:
//		case 3:
//		case 2:
//		case 1:
//		case 0:
//			System.out.println("不及格");
//			break;
//		default:
//			System.out.println("输入数据有误");
//			break;
//		}
		
//		Scanner scanner = new Scanner(System.in);
//		int score = scanner.nextInt();
//		if(score>=90 && score <=100) {
//			System.out.println("优秀");
//		}else if(score>=80 && score<90) {
//			System.out.println("良好");
//		}else if(score >= 70 && score < 80) {
//			System.out.println("中");
//		}else if(score >= 60 && score < 70) {
//			System.out.println("及格");
//		}else {
//			System.out.println("不及格");
//		}
		
		System.out.println("请输入会员积分：");
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		System.out.print("该会员享受的折扣是：");
		if(score>=8000) {
			System.out.println("0.6");
		}else if(score>=4000 && score < 8000) {
			System.out.println("0.7");
		}else if(score>=2000 && score < 4000) {
			System.out.println("0.8");
		}else if(score<2000) {
			System.out.println("0.9");
		}
		
	}
}
