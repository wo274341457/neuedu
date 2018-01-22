package com.neuedu.shop.dao;

import com.neuedu.shop.entity.User;

public interface UserDao {

	User selectUserByUsername(String username);
	
}
