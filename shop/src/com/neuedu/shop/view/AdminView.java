package com.neuedu.shop.view;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.shop.dao.AdminDao;
import com.neuedu.shop.entity.Shop;
import com.neuedu.shop.util.MyBatisUtil;

public class AdminView {
	private static Scanner sc=new Scanner(System.in);
	private static SqlSession session=MyBatisUtil.getSession();
	private static AdminDao adminDao= session.getMapper(AdminDao.class);

	public void showmenu() {
		while(true) {
			Scanner input = new Scanner(System.in);
			System.out.println("1.�����Ʒ");
			System.out.println("2.ɾ����Ʒ");
			System.out.println("3.�޸���Ʒ");
			System.out.println("4.�鿴��Ʒ");
			System.out.println("��ѡ��");
			int index = input.nextInt();
			input.nextLine();
			switch (index) {
			case 1:insertShop();
				
			break;
			case 2:deleteShop();
				
				break;
			case 3:updateShop();
				
				break;
			case 4:selectShop();
				
				break;
			default:System.out.println("������1-4");
				break;
			}
		}
	}
	
	
	private void insertShop() {
		System.out.println("��������ƷID:");
		Integer id=sc.nextInt();
		sc.nextLine();
		System.out.println("��������Ʒ����:");
		String name=sc.nextLine();
		System.out.println("��������Ʒ����:");
		Integer price=sc.nextInt();
		sc.nextLine();
		System.out.println("��������Ʒ����:");
		Integer count=sc.nextInt();
		sc.nextLine();
		System.out.println("��������Ʒ����ID:");
		Integer type_id=sc.nextInt();
		sc.nextLine();
		Shop shop =new Shop(id, name, price, count, type_id);
		int index=adminDao.insertShop(shop);
		if(index!=0) {
			System.out.println("�����Ʒ�ɹ�");
		}else {
			System.out.println("�����Ʒʧ��");
		}
	
	}
	
	private void deleteShop() {
		System.out.println("��������ƷID:");
		Integer id= sc.nextInt();
		sc.nextLine();
		int index=adminDao.deleteShop(id);
		if(index!=0) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
	}
	private void updateShop() {
		System.out.println("��������ƷID:");
		Integer id=sc.nextInt();
		sc.nextLine();
		List<Shop> list=adminDao.selectShops();
		for (Shop shop : list) {
			if(shop.getId()==id) {
				System.out.println("��������Ʒ����:");
				String name=sc.nextLine();
				System.out.println("��������Ʒ����:");
				Integer price=sc.nextInt();
				sc.nextLine();
				System.out.println("��������Ʒ����:");
				Integer count=sc.nextInt();
				sc.nextLine();
				System.out.println("��������Ʒ����ID:");
				Integer type_id=sc.nextInt();
				sc.nextLine();
				shop.setName(name);
				shop.setPrice(price);
				shop.setCount(count);
				shop.setType_id(type_id);
				int index=adminDao.updateShop(shop);
				if(index!=0) {
					System.out.println("��Ϣ�޸ĳɹ�");
				}else {
					System.out.println("��Ϣ�޸�ʧ��");
				}
				
			}
		}
		
	
		
		
		
		
	}
	private void selectShop() {
		List<Shop> list=adminDao.selectShops();
		if(list!=null) {
		for (Shop shop : list) {
			System.out.println(shop);
		}
		}else {
			System.out.println("����̼ұȽ�����û����ƷŶ...");
		}
		
		
		
		
		
	}
	
	
	
	
}
