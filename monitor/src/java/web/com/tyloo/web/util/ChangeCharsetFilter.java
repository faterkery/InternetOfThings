package com.tyloo.web.util;

import java.io.IOException;
import javax.servlet.*;

public class ChangeCharsetFilter implements Filter {

	protected String encoding = null;// ///要制定的编码，在web.xml中配置

	protected FilterConfig filterConfig = null;

	public void destroy() {

		this.encoding = null;
		this.filterConfig = null;

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		if (request.getCharacterEncoding() == null) {
			String encoding = getEncoding();// //得到指定的编码名字
			if (encoding != null)
				request.setCharacterEncoding(encoding);// //设置request的编码
		}

		chain.doFilter(request, response);// /有机会执行下一个filter

	}

	public void init(FilterConfig filterConfig) throws ServletException {

		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");// /得到在web.xml中配置的编码
	}

	protected String getEncoding() {

		return (this.encoding);// /得到指定的编码

	}

}
