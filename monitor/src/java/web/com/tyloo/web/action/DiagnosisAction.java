package com.tyloo.web.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.BasePOForm;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.CommonService;
import com.tyloo.modules.member.RecommendService;
import com.tyloo.po.Diagnosis;
import com.tyloo.po.Products;
import com.tyloo.po.Threshold;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.DispatchActions;
import com.tyloo.web.WebHelper;

public class DiagnosisAction extends DispatchActions {
	private static RecommendService recommendService = (RecommendService) ServiceLocator
			.getService("recommendService");

	@Override
	protected Class<Diagnosis> getActionClass() {
		return Diagnosis.class;
	}

	@Override
	protected SearchContext getListSearchContext(WebContext context) {
		SearchContext searchContext = new SearchContext();

		String title = delSearchOption(context, "name");
		if (StringUtils.isNotEmpty(title)) {
			searchContext.addOption(new SearchOption("name",
					"%" + title + "%", SearchOption.Option.like));
		}
		return searchContext;
	}
	
	public String insertProcess(WebContext context) throws ServletException {
	    Object member = WebHelper.getMemberContext(context);
		context.put("menuname", context.getParameter("menuname"));
		if (member == null) {
			return "/admin.html";
		}
		String forword = INSERT_FORWARD;
		if (context.getParameter("insert") != null
				|| context.getParameter("insert2") != null) {
			BasePOForm form = (BasePOForm) context.getForm();

			int id = (Integer) getService()
					.insertObject(form, getActionClass());
			form.setId(id);
			context.put("inserted", true);
		
			context.put("insert", null);
			context.put("insert2", null);
		}
		if (context.getParameter("insert") != null) {
			String fromUrl = context.getParameter("fromUrl");
			if (!StringUtils.isEmpty(fromUrl)) {
				forword = fromUrl;
			} else {
				forword = INSERT_SUCCESS_FORWARD;
			}
		}

		return forword;
	}
	@Override
	protected CommonService getService() {
		return recommendService;
	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return null;
	}
	
	

	
}
