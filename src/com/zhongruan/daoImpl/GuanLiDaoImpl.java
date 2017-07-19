package com.zhongruan.daoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zhongruan.dao.GuanLiDao;
import com.zhongruan.domain.House;
import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.User;
import com.zhongruan.utils.DataSourceUtils;

public class GuanLiDaoImpl implements GuanLiDao {

	@Override
	public List<House> guanLi() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

		List<House> query = qr.query("select * from house",
				new BeanListHandler<>(House.class));

		return query;
	}

	@Test
	public void run() throws SQLException {
		System.out.println(new GuanLiDaoImpl().guanLi());
	}

	@Override
	public PageBean showGuanLiByPage(PageBean pageBean) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		List<House> query = qr.query("select * from house limit ?,?",new BeanListHandler<>(House.class),(pageBean.getCurrPage()-1)*pageBean.getPageSize(),pageBean.getPageSize());
		
		pageBean.setList(query);
		return 	pageBean;
	
	}

	@Override
	public Integer findCount() throws Exception {
		QueryRunner qRunner = new QueryRunner(DataSourceUtils.getDataSource());
		Integer count = (int)(long)qRunner.query("select count(*) from house",new ScalarHandler());

		return count;
	}
	@Override
	public void deleteHouseMsg(String id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		int i = queryRunner.update("delete from house where id = ?",id);
		System.out.println(i);
	}
	@Override
	public User checkLogin(String name) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		User user = queryRunner.query("select * from user where user = ?", new BeanHandler<>(User.class),name);
		return user;
		
	}
	@Override
	public void regist(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		System.out.println(user);
		queryRunner.update("insert into user values(?,?,?,?,?)",user.getId(),user.getUser(),user.getPassword(),user.getTelephone(),user.getUsername());
		
	}
}
