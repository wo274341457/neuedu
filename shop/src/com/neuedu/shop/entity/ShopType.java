package com.neuedu.shop.entity;

public class ShopType {

	private Integer id;
	private String name;
	
	public ShopType() {
		super();
	}
	
	public ShopType(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Shop_type [id=" + id + ", name=" + name + "]";
	}
	
}
