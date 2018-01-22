package com.neuedu.shop.view;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.shop.dao.MemberDao;
import com.neuedu.shop.dao.UserDao;
import com.neuedu.shop.entity.Member;
import com.neuedu.shop.entity.User;
import com.neuedu.shop.util.MyBatisUtil;
import com.neuedu.shop.util.Session;

public class ShopView {
	
	public void showmenu() {
		while(true) {
			Scanner input = new Scanner(System.in);
			System.out.println("欢迎使用xxx宝购物");
			System.out.println("1.管理员登录");
			System.out.println("2.用户登录");
			System.out.println("3.用户注册");
			System.out.println("4.退出");
			System.out.println("请选择");
			int index = input.nextInt();
			input.nextLine();
			switch (index) {
			case 1:
				adminLogin();
				break;
			case 2:
				memberLogin();
				break;
			case 3:memberRegister();
				
				break;
			case 4:
				return;
			default:
				break;
			}
		}
	}
	
	/**
	 * 管理员的登录方法
	 */
	private void adminLogin() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名");
		String username = input.nextLine();
		System.out.println("请输入密码");
		String password = input.nextLine();
		SqlSession session = MyBatisUtil.getSession();
		UserDao userDao = session.getMapper(UserDao.class);
		User user = userDao.selectUserByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			new AdminView().showmenu();
		}else {
			System.out.println("登录失败");
		}
	}
	
	private void memberLogin() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名");
		String username = input.nextLine();
		System.out.println("请输入密码");
		String password = input.nextLine();
		
		SqlSession session = MyBatisUtil.getSession();
		MemberDao memberDao = session.getMapper(MemberDao.class);
		Member member = memberDao.selectMemberByUsername(username);
		if (member != null && member.getPassword().equals(password)) {
			//使用session类的map集合记录登录的用户信息
			Session.map.put("member", member);
			new MemberView().showmenu();
		}else {
			System.out.println("登录失败");
		}
	}
	private void memberRegister() {
		while(true) {
		SqlSession session = MyBatisUtil.getSession();
		MemberDao memberDao = session.getMapper(MemberDao.class);
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username = input.nextLine();
		Member member = memberDao.selectMemberByUsername(username);
		if(member!=null) {
			System.out.println("输入的用户名重复");
			
		}else {
			System.out.println("请输入密码:");
			String password = input.nextLine();
			int index=memberDao.insertMember(new Member(null,username,password,5000));
			if(index!=0) {
				System.out.println("用户注册成功...");
			}
			break;
			
		}
		
		}
		
		
	}
	
	
}
