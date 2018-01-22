package com.neuedu.shop.view;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.shop.dao.CommentDao;
import com.neuedu.shop.dao.OrderDao;
import com.neuedu.shop.dao.ShopDao;
import com.neuedu.shop.dao.ShopTypeDao;
import com.neuedu.shop.entity.Comment;
import com.neuedu.shop.entity.Member;
import com.neuedu.shop.entity.Order;
import com.neuedu.shop.entity.Shop;
import com.neuedu.shop.entity.ShopType;
import com.neuedu.shop.util.MyBatisUtil;
import com.neuedu.shop.util.Session;

public class MemberView {

	public void showmenu() {
		while(true) {
		Scanner input = new Scanner(System.in);
		System.out.println("1.��Ʒ���");
		System.out.println("2.�鿴����");
		System.out.println("3.��Ʒ����");
		System.out.println("4.������һ���˵�");
		System.out.println("��ѡ��:");
		int index = input.nextInt();
		input.nextLine();
		switch (index) {
		case 1:
			checkType();
			break;
		case 2:checkOrder();
			
			break;
		case 3:
			System.out.println("�����ڴ�");
			break;
		case 4:new ShopView().showmenu();;
			break;
		default:System.out.println("����������1-4");
			
		}
		}
	}
	
	/**
	 * �鿴��Ʒ��𷽷�
	 */
	private void checkType() {
		Scanner input = new Scanner(System.in);
		SqlSession session = MyBatisUtil.getSession();
		ShopTypeDao shopTypeDao = session.getMapper(ShopTypeDao.class);
		List<ShopType> list = shopTypeDao.selectShopTypes();
		for (ShopType shopType : list) {
			System.out.println(shopType);
		}
		System.out.println("������idѡ��");
		int type_id = input.nextInt();
		input.nextLine();
		ShopDao shopDao = session.getMapper(ShopDao.class);
		List<Shop> shopList = shopDao.selectShopByTypeID(type_id);
		if (shopList.size() > 0) {
			for (Shop shop : shopList) {
				System.out.println(shop);
			}
			System.out.println("��ѡ����Ʒ");
			//������Ʒid
			int shop_id = input.nextInt();
			input.nextLine();
			//���������id�������Ʒ����
			Shop shop = shopDao.selectShopById(shop_id);
			System.out.println("1.��Ӷ���");
			System.out.println("2.�鿴����");
			System.out.println("3.����");
			System.out.println("��ѡ��:");
			int index = input.nextInt();
			input.nextLine();
			switch (index) {
			case 1:
				//1.�����ݿ����һ����������
				Member member = (Member)Session.map.get("member");
				OrderDao orderDao = session.getMapper(OrderDao.class);
				orderDao.insertOrder(new Order(null, member.getId(), shop.getId(), "δ֧��"));
				//2.���-1
				shop.setCount(shop.getCount() - 1);
				shopDao.updateShop(shop);
				break;
			case 2:
				//��ѯ���۱�,������Ʒid��
				CommentDao commentDao = session.getMapper(CommentDao.class);
				Comment comment = commentDao.selectCommentsByShopid(shop_id);
				System.out.println(comment);
				break;
			case 3:
				return;
			default:
				break;
			}
		}else {
			System.out.println("����Ʒ");
		}
	}
	
	private void checkOrder() {
		SqlSession session = MyBatisUtil.getSession();
		OrderDao orderDao = session.getMapper(OrderDao.class);
		List<Order> list=orderDao.selectOrders();
		for (Order order : list) {
			System.out.println(order);
		}
	
	}
	private void searchGoods() {
		
		
		
		
		
		
	}
	
	
	
	
	
}
