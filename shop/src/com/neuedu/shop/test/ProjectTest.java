package com.neuedu.shop.test;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.shop.util.MyBatisUtil;

public class ProjectTest {
	public static void main(String[] args) {
		SqlSession session = MyBatisUtil.getSession();
		System.out.println(session);
	}
}
