package com.tyloo.web.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.CommonService;
import com.tyloo.modules.member.AboutUsService;
import com.tyloo.po.AboutUs;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.DispatchActions;
import com.tyloo.web.WebHelper;
import com.tyloo.web.form.AboutUsForm;

public class AboutUsAction extends DispatchActions {
	private static AboutUsService aboutUsService = (AboutUsService) ServiceLocator
			.getService("aboutUsService");

	@Override
	protected Class<AboutUs> getActionClass() {
		return AboutUs.class;
	}

	@Override
	protected SearchContext getListSearchContext(WebContext context) {
		SearchContext searchContext = new SearchContext();

		String title = delSearchOption(context, "title");
		if (StringUtils.isNotEmpty(title)) {
			searchContext.addOption(new SearchOption("title",
					"%" + title + "%", SearchOption.Option.like));
		}
		
		return searchContext;
	}

	@Override
	protected CommonService getService() {
		return aboutUsService;
	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return null;
	}

	@Override
	public String insertProcess(WebContext context) throws ServletException {
		if (context.getParameter("insert") != null
				|| context.getParameter("insert2") != null) {
			AboutUsForm form = (AboutUsForm) context.getForm();
			String content = context.getParameter("content");
			form.setContent(content);
		}
		return super.insertProcess(context);
	}

	@Override
	public String updateProcess(WebContext context) throws ServletException {
		if (context.getParameter("insert") != null
				|| context.getParameter("insert2") != null) {
			AboutUsForm form = (AboutUsForm) context.getForm();
			String content = context.getParameter("content");
			form.setContent(content);
		}
		return super.updateProcess(context);
	}
	
	public ActionForward updateSortNum(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WebContext context = new WebContext(getServlet().getServletContext(),
				request, response, form);
		context.put("base", context.getRequest().getContextPath());
		WebHelper.putCommonValues(context);
		String temp = getWebMenuType(context);
		if (temp != null) {
			context.put("webMenuType", temp);
		}
		String re = DELETE_FORWARD;
		Object member = WebHelper.getMemberContext(context);
		if (member == null) {
			re = "/admin.html";
			return new ActionForward(re, true);
		}
		int id = context.getIntParameter("sid");
		int sortNum = context.getIntParameter("sortNum");
		aboutUsService.updateSortNum(this.getActionClass(), id, sortNum);
		response.getOutputStream().println("1");
		return null;
	}
	

	
}
