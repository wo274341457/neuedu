package com.neuedu.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.shop.entity.Shop;

public interface ShopDao {

	List<Shop> selectShopByTypeID(int type_id);
	
	Shop selectShopById(int id);
	
	int updateShop(@Param("shop") Shop shop);
	
}
