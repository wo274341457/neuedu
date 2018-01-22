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
			System.out.println("1.添加商品");
			System.out.println("2.删除商品");
			System.out.println("3.修改商品");
			System.out.println("4.查看商品");
			System.out.println("请选择");
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
			default:System.out.println("请输入1-4");
				break;
			}
		}
	}
	
	
	private void insertShop() {
		System.out.println("请输入商品ID:");
		Integer id=sc.nextInt();
		sc.nextLine();
		System.out.println("请输入商品名称:");
		String name=sc.nextLine();
		System.out.println("请输入商品单价:");
		Integer price=sc.nextInt();
		sc.nextLine();
		System.out.println("请输入商品数量:");
		Integer count=sc.nextInt();
		sc.nextLine();
		System.out.println("请输入商品类型ID:");
		Integer type_id=sc.nextInt();
		sc.nextLine();
		Shop shop =new Shop(id, name, price, count, type_id);
		int index=adminDao.insertShop(shop);
		if(index!=0) {
			System.out.println("添加商品成功");
		}else {
			System.out.println("添加商品失败");
		}
	
	}
	
	private void deleteShop() {
		System.out.println("请输入商品ID:");
		Integer id= sc.nextInt();
		sc.nextLine();
		int index=adminDao.deleteShop(id);
		if(index!=0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	private void updateShop() {
		System.out.println("请输入商品ID:");
		Integer id=sc.nextInt();
		sc.nextLine();
		List<Shop> list=adminDao.selectShops();
		for (Shop shop : list) {
			if(shop.getId()==id) {
				System.out.println("请输入商品名称:");
				String name=sc.nextLine();
				System.out.println("请输入商品单价:");
				Integer price=sc.nextInt();
				sc.nextLine();
				System.out.println("请输入商品数量:");
				Integer count=sc.nextInt();
				sc.nextLine();
				System.out.println("请输入商品类型ID:");
				Integer type_id=sc.nextInt();
				sc.nextLine();
				shop.setName(name);
				shop.setPrice(price);
				shop.setCount(count);
				shop.setType_id(type_id);
				int index=adminDao.updateShop(shop);
				if(index!=0) {
					System.out.println("信息修改成功");
				}else {
					System.out.println("信息修改失败");
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
			System.out.println("这个商家比较懒，没有商品哦...");
		}
		
		
		
		
		
	}
	
	
	
	
}
