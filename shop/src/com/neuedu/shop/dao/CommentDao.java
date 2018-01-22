package com.neuedu.shop.dao;

import com.neuedu.shop.entity.Comment;

public interface CommentDao {

	Comment selectCommentsByShopid(int shop_id);
	
}
