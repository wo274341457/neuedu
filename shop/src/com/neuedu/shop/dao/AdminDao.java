package com.neuedu.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.shop.entity.Shop;

public interface AdminDao {
	List<Shop> selectShops();
	int insertShop(@Param("shop")Shop shop);
	int deleteShop(int id);
	int updateShop(@Param("shop")Shop shop);

}
