package com.zhongruan.domain;

public class House {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private Integer price;
	private String address;
	private String link;
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLink() {
		return link;
	}
	@Override
	public String toString() {
		return "House [price=" + price + ", address=" + address + ", link="
				+ link + "]";
	}
	public void setLink(String link) {
		this.link = link;
	}
}
