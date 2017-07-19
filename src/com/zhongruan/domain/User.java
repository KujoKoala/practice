package com.zhongruan.domain;

import java.security.KeyStore.PrivateKeyEntry;

public class User {
	private Integer id;
	private String user;
	private String password;
	private String telephone;
	private String username;
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", password=" + password + ", telephone=" + telephone
				+ ", username=" + username + "]";
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
