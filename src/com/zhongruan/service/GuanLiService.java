package com.zhongruan.service;

import java.sql.SQLException;
import java.util.List;

import com.zhongruan.domain.House;
import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.User;


public interface GuanLiService {
	public List<House> guanli() throws SQLException;
	public PageBean showGuanLiByPage(PageBean pageBean) throws Exception;
	void deleteHouseMsg(String id) throws SQLException;
	User checkLogin(String name) throws Exception;
	void regist(User user) throws SQLException;
}
