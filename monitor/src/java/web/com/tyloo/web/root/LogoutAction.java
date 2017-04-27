package com.tyloo.web.root;

import javax.servlet.ServletException;

import org.jasig.cas.client.util.AssertionHolder;

import com.tyloo.fw.waf.BaseAction;
import com.tyloo.fw.waf.WebContext;

public class LogoutAction extends BaseAction {

	@Override
	public String process(WebContext context) throws ServletException {
		String re = DEFAULT_FORWARD;
		context.getRequest().getSession().invalidate();
		AssertionHolder.setAssertion(null);
//		if (context.getParameter("logoutAddress") != null && !context.getParameter("logoutAddress").equals("")) {
//			String[] logouts = context.getParameter("logoutAddress").split(";");
//			for (String logout :logouts) {
//				//httpClientPost(logout);
//				try {
//					String contextPath = context.getRequest().getContextPath();
//					if (logout.indexOf(contextPath) < 0) {
//						context.getResponse().sendRedirect(logout);
//					}
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		return re;
	}
	
}
