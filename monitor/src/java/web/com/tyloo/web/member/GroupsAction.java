package com.tyloo.web.member;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.CommonService;
import com.tyloo.modules.member.GroupsService;
import com.tyloo.po.Groups;
import com.tyloo.po.Member;
import com.tyloo.po.Role;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.DispatchActions;
import com.tyloo.web.WebHelper;

public class GroupsAction extends DispatchActions {
	private static final GroupsService service = (GroupsService) ServiceLocator
			.getService("groupsService");

	@Override
	protected Class getActionClass() {
		return Groups.class;
	}

	@Override
	public String insertProcess(WebContext context) throws ServletException {

		return super.insertProcess(context);
	}

	@Override
	public String updateProcess(WebContext context) throws ServletException {

		return super.updateProcess(context);
	}

	@Override
	protected SearchContext getListSearchContext(WebContext context) {
		SearchContext searchContext = new SearchContext();

		String name = delSearchOption(context, "name");
		if (!StringUtils.isEmpty(name)) {
			searchContext.addOption(new SearchOption("name", "%" + name + "%",
					SearchOption.Option.like));
		}
		return searchContext;
	}

	@Override
	protected CommonService getService() {
		return service;
	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return "groups";
	}

}
