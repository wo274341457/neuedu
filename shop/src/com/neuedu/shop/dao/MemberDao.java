package com.neuedu.shop.dao;

import org.apache.ibatis.annotations.Param;

import com.neuedu.shop.entity.Member;

public interface MemberDao {

	Member selectMemberByUsername(String username);
	int insertMember(@Param ("member")Member member);
	
}
