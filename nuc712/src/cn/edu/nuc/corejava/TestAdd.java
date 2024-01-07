package cn.edu.nuc.corejava;

import java.util.Scanner;

public class TestAdd {
	public static void main(String[] args) {
		//1. 用户输入数据,接收键盘数据
		Scanner sc = new Scanner(System.in);
		System.out.println("请您输入律师姓名：");
		String lawyername = sc.next();//接收键盘数据
		System.out.println("请您输入律师性别：");
		String gender = sc.next();//接收键盘数据
		System.out.println("请您输入律师籍贯：");
		String nation = sc.next();//接收键盘数据
		System.out.println("请您输入律师学校：");
		String school = sc.next();//接收键盘数据
		//2. 创建对象	
		LawyerDao lawyerDao = new LawyerDao();
		//3. 对象调用方法
		int flag = lawyerDao.addLawyer(lawyername, gender, nation, school);
		//4. 给用户提示
		if (flag == 0) {
			System.out.println("添加失败！");
		} else {
			System.out.println("添加成功.....");
		}
	}
}




