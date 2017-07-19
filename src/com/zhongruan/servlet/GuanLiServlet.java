package com.zhongruan.servlet;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.deploy.LoginConfig;
import org.apache.commons.beanutils.BeanUtils;

import com.zhongruan.domain.House;
import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.User;
import com.zhongruan.service.GuanLiService;
import com.zhongruan.serviceImpl.GuanLiServiceImpl;

import sun.rmi.transport.proxy.HttpReceiveSocket;

public class GuanLiServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String guanLi(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean();

		int currPage = Integer.parseInt(request.getParameter("currPage"));
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(3);

		GuanLiService guanLiService = new GuanLiServiceImpl();

		pageBean = guanLiService.showGuanLiByPage(pageBean);

		// request.setAttribute("list", list);

		request.setAttribute("pageBean", pageBean);

		return "/WEB-INF/jsp/guanli.jsp";
	}

	public String deleteHouseMsg(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");

		GuanLiServiceImpl guanLiServiceImpl = new GuanLiServiceImpl();
		try {
			guanLiServiceImpl.deleteHouseMsg(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/guanli?method=guanLi&currPage=1";
	}

	public String fabu(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/jsp/fabu.htm";
	}

	public String exit(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		return "/WEB-INF/jsp/login.htm";
	}

	public String xiugai(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/jsp/details.htm";
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/jsp/login.jsp";
	}

	public String regist(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/jsp/regist.jsp";
	}

	public String checkLogin(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		GuanLiServiceImpl guanLiServiceImpl = new GuanLiServiceImpl();
		User user = null;
		try {
			user = guanLiServiceImpl.checkLogin(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user == null) {
			return login(request, response);
		} else {
			if (password.equals(user.getPassword())) {
				request.getSession().setAttribute("user", user);
				return "/WEB-INF/jsp/list.jsp";

			} else {
				return login(request, response);
			}
		}
	}

	public String checkRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User();
		Map<String, String[]> parameterMap = request.getParameterMap();
		BeanUtils.populate(user, parameterMap);
		
		GuanLiServiceImpl guanLiServiceImpl = new GuanLiServiceImpl();
		guanLiServiceImpl.regist(user);
		return login(request, response);
	}
}
