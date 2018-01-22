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
			System.out.println("��ӭʹ��xxx������");
			System.out.println("1.����Ա��¼");
			System.out.println("2.�û���¼");
			System.out.println("3.�û�ע��");
			System.out.println("4.�˳�");
			System.out.println("��ѡ��");
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
	 * ����Ա�ĵ�¼����
	 */
	private void adminLogin() {
		Scanner input = new Scanner(System.in);
		System.out.println("�������û���");
		String username = input.nextLine();
		System.out.println("����������");
		String password = input.nextLine();
		SqlSession session = MyBatisUtil.getSession();
		UserDao userDao = session.getMapper(UserDao.class);
		User user = userDao.selectUserByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			new AdminView().showmenu();
		}else {
			System.out.println("��¼ʧ��");
		}
	}
	
	private void memberLogin() {
		Scanner input = new Scanner(System.in);
		System.out.println("�������û���");
		String username = input.nextLine();
		System.out.println("����������");
		String password = input.nextLine();
		
		SqlSession session = MyBatisUtil.getSession();
		MemberDao memberDao = session.getMapper(MemberDao.class);
		Member member = memberDao.selectMemberByUsername(username);
		if (member != null && member.getPassword().equals(password)) {
			//ʹ��session���map���ϼ�¼��¼���û���Ϣ
			Session.map.put("member", member);
			new MemberView().showmenu();
		}else {
			System.out.println("��¼ʧ��");
		}
	}
	private void memberRegister() {
		while(true) {
		SqlSession session = MyBatisUtil.getSession();
		MemberDao memberDao = session.getMapper(MemberDao.class);
		Scanner input = new Scanner(System.in);
		System.out.println("�������û���:");
		String username = input.nextLine();
		Member member = memberDao.selectMemberByUsername(username);
		if(member!=null) {
			System.out.println("������û����ظ�");
			
		}else {
			System.out.println("����������:");
			String password = input.nextLine();
			int index=memberDao.insertMember(new Member(null,username,password,5000));
			if(index!=0) {
				System.out.println("�û�ע��ɹ�...");
			}
			break;
			
		}
		
		}
		
		
	}
	
	
}
