package com.neuedu.shop.entity;

public class Member {

	private Integer id;
	private String username;
	private String password;
	private Integer money;
	
	public Member() {
		super();
	}
	
	public Member(Integer id, String username, String password, Integer money) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.money = money;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", password=" + password + ", money=" + money + "]";
	}
	
}
