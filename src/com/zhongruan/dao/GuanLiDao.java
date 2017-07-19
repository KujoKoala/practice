package com.zhongruan.dao;

import java.sql.SQLException;
import java.util.List;

import com.zhongruan.domain.House;
import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.User;

public interface GuanLiDao {
	public List<House> guanLi() throws SQLException;

	PageBean showGuanLiByPage(PageBean pageBean) throws Exception;

	Integer findCount() throws Exception;

	void deleteHouseMsg(String id) throws SQLException;

	User checkLogin(String name) throws SQLException;

	void regist(User user) throws SQLException;
}
