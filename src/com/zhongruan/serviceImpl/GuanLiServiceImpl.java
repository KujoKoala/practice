package com.zhongruan.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.zhongruan.dao.GuanLiDao;
import com.zhongruan.daoImpl.GuanLiDaoImpl;
import com.zhongruan.domain.House;
import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.User;
import com.zhongruan.service.GuanLiService;

public class GuanLiServiceImpl implements GuanLiService {

	@Override
	public List<House> guanli() throws SQLException {
		GuanLiDao guanLiDao = new GuanLiDaoImpl();
		List<House> list = guanLiDao.guanLi();
		return list;
	}

	@Override
	public PageBean showGuanLiByPage(PageBean pageBean) throws Exception {
		Integer count = new GuanLiDaoImpl().findCount();
		PageBean pageBean2 = new GuanLiDaoImpl().showGuanLiByPage(pageBean);
		pageBean2.setTotalSize(count);
		pageBean2.setTotalPage((int) (Math.ceil(count / pageBean2.getPageSize())));
		return pageBean2;
	}

	@Override
	public void deleteHouseMsg(String id) throws SQLException {
		GuanLiDaoImpl guanLiDaoImpl = new GuanLiDaoImpl();
		guanLiDaoImpl.deleteHouseMsg(id);
	}

	@Override
	public User checkLogin(String name) throws Exception {
		GuanLiDaoImpl guanLiDaoImpl = new GuanLiDaoImpl();
		User user = guanLiDaoImpl.checkLogin(name);
		return user;
	}
	@Override
	public void regist(User user) throws SQLException {
		GuanLiDaoImpl guanLiDaoImpl = new GuanLiDaoImpl();
		guanLiDaoImpl.regist(user);
	}
}
