package com.neuedu.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.shop.entity.Order;

public interface OrderDao {

	int insertOrder(@Param("order") Order order);
	List<Order> selectOrders();
	
}
