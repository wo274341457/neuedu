package com.neuedu.shop.entity;

public class Comment {

	private Integer id;
	private Integer member_id;
	private Integer shop_id;
	private String content;
	
	private Shop shop;
	private Member member;
	
	public Comment() {
		super();
	}
	
	public Comment(Integer id, Integer member_id, Integer shop_id, String content) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.shop_id = shop_id;
		this.content = content;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", member_id=" + member_id + ", shop_id=" + shop_id + ", content=" + content
				+ ", shop=" + shop + ", member=" + member + "]";
	}

}
