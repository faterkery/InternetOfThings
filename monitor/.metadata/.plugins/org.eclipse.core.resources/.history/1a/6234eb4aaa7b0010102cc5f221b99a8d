package com.renhenet.fw.waf;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionServlet;

@SuppressWarnings("serial")
public class BaseActionServlet extends ActionServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		super.doGet(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		super.doPost(request, response);
	}
}
