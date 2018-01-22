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
		//����sqlsession���󣬲�����true�Ļ����Զ��ύ����
		return factory.openSession(true);
	}
	
}
