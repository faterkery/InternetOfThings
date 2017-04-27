
package com.tyloo.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mr hu
 *
 */
public class FDTimerListener extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public FDTimerListener() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * Initialization of the servlet. <br>  tomcat �����servlet ��servlet������ִ��init����
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ApplicationContext act = new ClassPathXmlApplicationContext("timer-bean.xml");
		System.out.println(sdf.format(new Date())+"start load timer-bean.xml...... ");
	}
}
