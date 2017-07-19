package com.zhongruan.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		@SuppressWarnings("rawtypes")
		Class clazzClass = this.getClass();

		String m = request.getParameter("method");
		if (m == null) {
			m = "index";
		}
		try {
			@SuppressWarnings("unchecked")
			Method method = clazzClass.getMethod(m, HttpServletRequest.class,
					HttpServletResponse.class);
			String string = (String) method.invoke(this, request, response);

			if (string != null) {
				request.getRequestDispatcher(string).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/WEB-INF/jsp/index.jsp";
	}
}
