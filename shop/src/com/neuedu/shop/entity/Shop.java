package com.neuedu.shop.entity;

public class Shop {

	private Integer id;
	private String name;
	private Integer price;
	private Integer count;
	private Integer type_id;
	
	public Shop() {
		super();
	}
	
	public Shop(Integer id, String name, Integer price, Integer count, Integer type_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.type_id = type_id;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", price=" + price + ", count=" + count + ", type_id=" + type_id
				+ "]";
	}
	
}
