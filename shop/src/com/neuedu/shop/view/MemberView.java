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
		System.out.println("1.商品类别");
		System.out.println("2.查看订单");
		System.out.println("3.商品搜索");
		System.out.println("4.返回上一级菜单");
		System.out.println("请选择:");
		int index = input.nextInt();
		input.nextLine();
		switch (index) {
		case 1:
			checkType();
			break;
		case 2:checkOrder();
			
			break;
		case 3:
			System.out.println("敬请期待");
			break;
		case 4:new ShopView().showmenu();;
			break;
		default:System.out.println("请重新输入1-4");
			
		}
		}
	}
	
	/**
	 * 查看商品类别方法
	 */
	private void checkType() {
		Scanner input = new Scanner(System.in);
		SqlSession session = MyBatisUtil.getSession();
		ShopTypeDao shopTypeDao = session.getMapper(ShopTypeDao.class);
		List<ShopType> list = shopTypeDao.selectShopTypes();
		for (ShopType shopType : list) {
			System.out.println(shopType);
		}
		System.out.println("请输入id选择");
		int type_id = input.nextInt();
		input.nextLine();
		ShopDao shopDao = session.getMapper(ShopDao.class);
		List<Shop> shopList = shopDao.selectShopByTypeID(type_id);
		if (shopList.size() > 0) {
			for (Shop shop : shopList) {
				System.out.println(shop);
			}
			System.out.println("请选择商品");
			//输入商品id
			int shop_id = input.nextInt();
			input.nextLine();
			//根据输入的id查出来商品对象
			Shop shop = shopDao.selectShopById(shop_id);
			System.out.println("1.添加订单");
			System.out.println("2.查看评论");
			System.out.println("3.返回");
			System.out.println("请选择:");
			int index = input.nextInt();
			input.nextLine();
			switch (index) {
			case 1:
				//1.向数据库插入一条订单数据
				Member member = (Member)Session.map.get("member");
				OrderDao orderDao = session.getMapper(OrderDao.class);
				orderDao.insertOrder(new Order(null, member.getId(), shop.getId(), "未支付"));
				//2.库存-1
				shop.setCount(shop.getCount() - 1);
				shopDao.updateShop(shop);
				break;
			case 2:
				//查询评论表,根据商品id查
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
			System.out.println("无商品");
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
