package com.neuedu.shop.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private static SqlSessionFactory factory;
	
	static {
		factory = new SqlSessionFactoryBuilder().build(
				MyBatisUtil.class.getClassLoader().getResourceAsStream("myBatis.xml"));
	}
	public static SqlSession getSession() {
		//建立sqlsession对象，参数传true的话将自动提交事务
		return factory.openSession(true);
	}
	
}
