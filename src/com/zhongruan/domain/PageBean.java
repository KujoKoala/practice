package com.zhongruan.domain;

import java.util.List;


public class PageBean {
	private List<House> list;
	private Integer pageSize;
	private Integer currPage;
	private Integer totalPage;
	private Integer totalSize;
	@Override
	public String toString() {
		return "PageBean [list=" + list + ", pageSize=" + pageSize
				+ ", currPage=" + currPage + ", totalPage=" + totalPage
				+ ", totalSize=" + totalSize + "]";
	}
	public List<House> getList() {
		return list;
	}
	public void setList(List<House> list) {
		this.list = list;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	
}
