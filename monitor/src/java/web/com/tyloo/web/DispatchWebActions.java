package com.tyloo.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tyloo.fw.Config;
import com.tyloo.fw.orm.Persistent;
import com.tyloo.fw.waf.BasePOForm;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.CommonService;
import com.tyloo.po.ShopUser;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
@SuppressWarnings("unchecked")
public abstract class DispatchWebActions extends DispatchAdminAction {

	public static final String LIST_FORWARD = "list";

	public static final String OWN_LIST_FORWARD = "ownList";

	public static final String UPDATE_FORWARD = "update";

	public static final String DETAIL_FORWARD = "detail";

	public static final String INSERT_FORWARD = "insert";

	public static final String RECYCLE_FORWARD = "recycle";

	public static final String DELETE_FORWARD = "delete";

	public static final String APPROVE_FORWARD = "approve";

	public static final String CUSTOM_FORWARD = null;

	public static final String INSERT_SUCCESS_FORWARD = "insertsuccess";

	public static final String FIELD_MEMBER_ID = "members.id";

	@Override
	public String listProcess(WebContext context) throws ServletException {
	    ShopUser user = WebHelper.getShopUserContext(context);
		context.put("menuname", context.getParameter("menuname"));
		
		context.put("success", context.getParameter("success"));
		if (user == null) {
			return "/shopuser/login.html"; 
		}
		SearchContext searchContext = getListSearchContext(context);
		if (searchContext == null) {
			searchContext = new SearchContext();
		}
		searchContext.setSearchClass(getActionClass());

		doSearch(context, searchContext);
		return LIST_FORWARD;
	}

	/**
	 * ��search
	 * 
	 * @param context
	 */
	protected abstract SearchContext getListSearchContext(WebContext context);

	@SuppressWarnings("unused")
	private SearchOption getPersonalSearchOption(WebContext context) {
	    int memberId = 0;
	    if(StringUtils.isNotEmpty(context.getTempClientValue("familyId")))
	    {
	        memberId = Integer.parseInt(context.getTempClientValue("familyId"));
	    }

		SearchOption option = new SearchOption(FIELD_MEMBER_ID, memberId,
				SearchOption.Option.eqaul);

		return option;
	}

	/**
	 * �õ�action�����class(PO)
	 * 
	 * @return
	 */
	protected abstract Class getActionClass();

	/**
	 * ������
	 * 
	 * @param context
	 * @param orderBy
	 * @param searchContext
	 */
	private void doSearch(WebContext context, SearchContext searchContext) {
		int totalCount = getService().getBizObjCount(searchContext);
		
		
		if (totalCount > 0) {
			int startRow = WebHelper.getStartRow(context, totalCount);

			int ppc = getPerPageCount(context);
			String orderBy = WebHelper.delSearchOption(context, "orderBy");
			List list = getService().getBizObjList(searchContext, orderBy,
					startRow, ppc);

			Pagination pagination = new Pagination(totalCount, startRow, ppc);
			context.put("bizObjList", list);
			context.put("pagination", pagination);
		} else {
			context.put("searchNoResult", true);
		}
	}

	public String delSearchOption(WebContext context, String optionName) {
		String optionValue = context.getParameter(optionName);

		context.put(optionName, optionValue);
		return optionValue;
	}
	
	/**
	 * add by jiangtao
	 * @param context
	 * @param optionName
	 * @return
	 */
	public int delIntSearchOption(WebContext context, String optionName) {
		int optionValue = context.getIntParameter(optionName);

		context.put(optionName, optionValue);
		return optionValue;
	}

	protected int getGetAllListMaxCount() {
		return Config.getInt("getall.maxcount", 500);
	}

	@SuppressWarnings("static-access")
	protected int getPerPageCount(WebContext context) {
		int ppc;
		if (context.getParameter("pageSize") != null
				&& StringUtils.isNumeric(context.getParameter("pageSize"))) {
			ppc = Integer.parseInt(context.getParameter("pageSize"));
			context.setClientValue("pageSize", ppc);
			context.put("pageSize", ppc);
		} else if (!StringUtils.isEmpty(context.getClientValue("pageSize"))
				&& StringUtils.isNumeric(context.getClientValue("pageSize"))) {
			ppc = Integer.parseInt(context.getClientValue("pageSize"));
		} else {
			ppc = this.perPage;
		}

		return ppc;
	}

	@Override
	public String updateProcess(WebContext context) throws ServletException {
		context.put("menuname", context.getParameter("menuname"));
		ShopUser user = WebHelper.getShopUserContext(context);
		if (user == null) {
			return "/shopuser/login.html"; 
		}
		int id = context.getSIntParameter("sid");
		BasePOForm form = (BasePOForm) context.getForm();

		if (id <= 0) {
			id = form.getId();
		}
		if (context.getParameter("insert") != null
				|| context.getParameter("insert2") != null) {

			getService().updateObject(form, getActionClass());
			context.put("updated", true);
			context.put("success", "true");
		}

		if (context.getParameter("insert") != null) {
			String fromUrl = context.getParameter("fromUrl");
			if (!StringUtils.isEmpty(fromUrl)) {
				return fromUrl;
			}
		}

		Persistent f = getService().getObjectById(
				getActionClass(), id);
		context.put("bizObj", f);
		return UPDATE_FORWARD;

	}

	@Override
	public String detailProcess(WebContext context) throws ServletException {
		context.put("menuname", context.getParameter("menuname"));
		int id = context.getSIntParameter("sid");
		Persistent f = this.getService()
				.getObjectByIdFull(getActionClass(), id);
		context.put("bizObj", f);
		return DETAIL_FORWARD;
	}

	@Override
	public String insertProcess(WebContext context) throws ServletException {
	    ShopUser user = WebHelper.getShopUserContext(context);
	    System.out.println(user+"@@@@@@@@@@");
		context.put("menuname", context.getParameter("menuname"));
		if (user == null) {
			return "/shopuser/login.html"; 
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
	public String deleteProcess(WebContext context) throws ServletException {
	    ShopUser user = WebHelper.getShopUserContext(context);
		context.put("menuname", context.getParameter("menuname"));
		if (user == null) {
			return "/shopuser/login.html"; 
		}
		int id = context.getSIntParameter("sid");
		CommonService commonService = getService();
		String re = DELETE_FORWARD;

//		commonService.delObject(this.getActionClass(), id);
		commonService.delLogicObject(this.getActionClass(), id);
		context.put("delete", true);
		String fromUrl = context.getParameter("fromUrl");
		if (!StringUtils.isEmpty(fromUrl)) {
			return fromUrl;
		} else {
			return re;
		}
	}


	/**
	 * @return  ɾ�����Դ��context�е���Ϣ
	 * @throws Exception
	 */
	public ActionForward showParaDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WebContext context = new WebContext(getServlet().getServletContext(),
				request, response, form);
		context.put("base", context.getRequest().getContextPath());  //��ȡ��Ŀ¼
		WebHelper.putCommonValues(context);
		String temp = getWebMenuType(context);
		if (temp != null) {
			context.put("webMenuType", temp);
		}
		ShopUser user = WebHelper.getShopUserContext(context);
		if (user == null) {
			return mapping.findForward("/index.html");
		}
		int id = context.getSIntParameter("sid");
		CommonService commonService = getService();
		String re = DELETE_FORWARD;
		
		commonService.delObject(this.getActionClass(), id);  
		//commonService.delLogicObject(this.getActionClass(), id);  
		context.put("delete", true);
		
		String fromUrl = context.getParameter("fromUrl");
		if (!StringUtils.isEmpty(fromUrl)) {
			//return fromUrl;
		} else {
			//return re;
		}
		/*ȡlist*/
		SearchContext searchContext = getListSearchContext(context);
		if (searchContext == null) {
			searchContext = new SearchContext();
		}
		searchContext.setSearchClass(getActionClass());

		doSearch(context, searchContext);
		return mapping.findForward("list");
	}
	
	
	@Override
	public String customActionsProcess(WebContext context)
			throws ServletException {
		return CUSTOM_FORWARD;
	}

	/**
	 * �õ�service
	 * 
	 * @return
	 */
	protected abstract CommonService getService();
	
	
	/**
	 * 
	 * description: get the whole request address
	 * @author jiangtao 
	 * @param context
	 * @return
	 */
	protected String getRequestPath(WebContext context)
	{
	    HttpServletRequest request = context.getRequest();
	    String fromUrl = request.getServletPath();
	    System.out.println(fromUrl.toString());
	    String strQuery = request.getQueryString();
	    System.out.println(strQuery);
	    if(fromUrl.indexOf("?")!=-1)
	    {
	        fromUrl = fromUrl + "&";
	    }
	    else
	    {
	        fromUrl = fromUrl + "?";
	    }
	    return fromUrl+strQuery;
	    
	}
}
