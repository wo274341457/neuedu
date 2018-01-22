package com.neuedu.shop.entity;

public class Order {

	private Integer id;
	private Integer member_id;
	private Integer shop_id;
	private String state;
	
	public Order() {
		super();
	}
	
	public Order(Integer id, Integer member_id, Integer shop_id, String state) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.shop_id = shop_id;
		this.state = state;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", member_id=" + member_id + ", shop_id=" + shop_id + ", state=" + state + "]";
	}

}
