package com.tyloo.web;

import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.tyloo.fw.waf.WebContext;
@SuppressWarnings("unchecked")
public abstract class DispatchAdminAction extends DispatchAction implements
		WebConstants {

	/**
	 * The Class instance of this <code>DispatchAction</code> class.
	 */
	protected Class clazz = this.getClass();

	protected Class[] types = { WebContext.class };

	/**
	 * ���Ƿ��� (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward action(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			String methodName, String contextAction) throws Exception {
		WebContext context = new WebContext(getServlet().getServletContext(),
				request, response, form);
		context.put("base", context.getRequest().getContextPath());  //��ȡ��Ŀ¼
		WebHelper.putCommonValues(context);

		context.put("action", contextAction);

		String temp = getWebMenuType(context);
		if (temp != null) {
			context.put("webMenuType", temp);
		}

		ActionForward forword;
		if (!WebHelper.isSigned(context)) {
			forword = mapping.findForward(LOGIN_FORWARD);
		} else {

			Method method = clazz.getMethod(methodName, types);
			Object args[] = new Object[] { context };
			String af = (String) method.invoke(this, args);
			putArgs(context);
			context.saveCookie();

			if (af.startsWith("/")) {
				forword = new ActionForward(af, true);
			} else {
				forword = mapping.findForward(af);
			}

		}
		
		String showtext = context.getParameter("showtext");
		if (StringUtils.isEmpty(showtext)) {
			showtext = "原料";
		}
		context.put("showtext", showtext);
		
		String topSearch = context.getParameter("topSearch");
		if (StringUtils.isEmpty(topSearch)) {
			topSearch = "1";
		}
		context.put("topSearch", topSearch);
		
		String kword = context.getParameter("kword");
		context.put("kword", kword);
		
		return forword;
	}

	/**
	 * ��һЩ����������context�У����������������
	 * 
	 * @param context
	 */
	public void putArgs(WebContext context) {

	}

	/**
	 * ���Ƿ��� (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return this.action(mapping, form, request, response, "listProcess",
				"list");
	}

	public abstract String listProcess(WebContext context)
			throws ServletException;

	/**
	 * ���Ƿ��� (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return this.action(mapping, form, request, response, "updateProcess",
				"update");
	}

	public abstract String updateProcess(WebContext context)
			throws ServletException;

	/**
	 * ���Ƿ��� (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return this.action(mapping, form, request, response, "detailProcess",
				"detail");
	}

	public abstract String detailProcess(WebContext context)
			throws ServletException;

	/**
	 * ���Ƿ��� (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return this.action(mapping, form, request, response, "insertProcess",
				"insert");
	}

	public abstract String insertProcess(WebContext context)
			throws ServletException;

	/**
	 * ���Ƿ��� (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return this.action(mapping, form, request, response, "deleteProcess",
				"delete");
	}

	public abstract String deleteProcess(WebContext context)
			throws ServletException;

	/**
	 * ���Ƿ��� (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward resume(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return this.action(mapping, form, request, response, "resumeProcess",
				"resume");
	}

	/**
	 * ���Ƿ��� �û��Զ����һЩ��Ϊ
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward customActions(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return this.action(mapping, form, request, response,
				"customActionsProcess", "customActions");
	}

	public abstract String customActionsProcess(WebContext context)
			throws ServletException;

	public abstract String getWebMenuType(WebContext context)
			throws ServletException;

}
