package com.tyloo.fw.waf;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.chain.contexts.ServletActionContext;

import com.tyloo.util.DateUtil;
import com.tyloo.util.NumberUtil;
import com.tyloo.util.SecurityUtil;
import com.tyloo.util.StringUtil;

public class WebContext extends ServletActionContext {
	private ActionForm form;

	private CookieUtil cookieUtil;

	public WebContext(ServletContext servletContext,
			HttpServletRequest newRequest, HttpServletResponse newResponse,
			ActionForm newForm) {
		super(servletContext, newRequest, newResponse);
		this.form = newForm;
		cookieUtil = new CookieUtil(newRequest, newResponse);

	}

	public ActionForm getForm() {
		return form;
	}

	public String getLoginurl() {
		HttpServletRequest request = this.getRequest();
		String query = request.getQueryString();
		String tmp = "";
		if (StringUtil.is_Empty(query)) {
			tmp = StringUtil.urlencoder(request.getRequestURI());
		} else {
			tmp = StringUtil.urlencoder(request.getRequestURI() + "?"
					+ request.getQueryString());
		}
		if (tmp.length() > 0) {
			return "/login.html?goto=" + tmp;
		} else {
			return "/login.html";
		}
	}

	public Object put(String key, Object value) {
		getRequest().setAttribute(key, value);
		return value;
	}

	public Object get(String key) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}
		return getRequest().getAttribute(key);
	}

	/**
	 * 得到表单中的参数
	 * 
	 * @param response
	 *            The String
	 */
	public String getParameter(String key) {
		return StringUtils.trim(getRequest().getParameter(key));
	}

	/**
	 * 得到表单中的参数
	 * 
	 * @param response
	 *            The String
	 */
	public int getIntParameter(String key) {

		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(getParameter(key))) {
			return -1;
		}
		return NumberUtils.toInt(getParameter(key));
	}

	/**
	 * 得到加密过的表单中的参数
	 * 
	 * @param response
	 *            The String
	 */
	public String getSParameter(String key) {
		String value = StringUtils.trim(SecurityUtil.decrypt(getRequest()
				.getParameter(key)));
		return value;
	}

	/**
	 * 得到加密过的表单中的参数
	 * 
	 * @param response
	 *            The String
	 */
	public int getSIntParameter(String key) {

		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(getParameter(key))) {
			return -1;
		}
		return NumberUtils.toInt(getSParameter(key));
	}

	/**
	 * 得到表单中的参数
	 * 
	 * @param response
	 *            The String[]
	 */
	public String[] getParameterValues(String key) {
		return getRequest().getParameterValues(key);
	}

	/**
	 * 得到表单中的参数
	 * 
	 * @param response
	 *            The String[]
	 */
	public int[] getIntParameterValues(String key) {
		String[] strings = getRequest().getParameterValues(key);
		if (strings != null && strings.length > 0) {
			int l = strings.length;
			int[] ints = new int[l];
			for (int i = 0; i < l; i++) {
				ints[i] = NumberUtils.toInt(strings[i]);
			}
			return ints;
		} else {
			return null;
		}
	}

	/**
	 * 得到表单中的参数
	 * 
	 * @param response
	 *            The String[]
	 */
	public int[] getSIntParameterValues(String key) {
		String[] ints = this.getParameterValues(key);
		int[] sints = null;
		if (ints != null && ints.length > 0) {
			sints = new int[ints.length];
			for (int i = 0; i < ints.length; i++) {
				if (!StringUtils.isEmpty(ints[i])) {
					sints[i] = Integer.parseInt(SecurityUtil.decrypt(ints[i]));
				}
			}
		}
		return sints;
	}

	/**
	 * 得到表单中的参数
	 * 
	 * @param response
	 *            The String[]
	 */
	public Integer[] getIntegerParameterValues(String key) {
		int[] ints = this.getIntParameterValues(key);
		Integer[] integers = null;
		if (ints != null && ints.length > 0) {
			integers = new Integer[ints.length];
			for (int i = 0; i < ints.length; i++) {
				integers[i] = ints[i];
			}
		}
		return integers;
	}

	/**
	 * 得到表单中的参数
	 * 
	 * @param response
	 *            The String
	 */
	public double getDoubleParameter(String key) {

		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(getParameter(key))) {
			return -1;
		}
		return NumberUtils.toDouble(getParameter(key));
	}

	/**
	 * 得到Form中Integer值
	 * 
	 * @param String
	 *            当前参数名
	 * @return int 返回参数值
	 */
	public int getInt(String name) {
		if (StringUtils.isEmpty(name)) {
			return 0;
		}
		return NumberUtils.toInt((String) get(name));
	}

	/**
	 * 得到Form中Integer值
	 * 
	 * @param String
	 *            当前参数名
	 * @return int 返回参数值
	 */
	public int getSInt(String name) {

		int i = -1;
		if (this.get(name) != null) {
			String s = SecurityUtil.decrypt(this.get(name) + "");
			if (!StringUtils.isEmpty(s) && StringUtils.isNumeric(s)) {
				i = Integer.parseInt(s);
			}
		}

		return i;
	}

	public Date getDate(String args) {
		Date date = null;
		String sdate = getParameter(args);
		if (!StringUtils.isEmpty(sdate)) {
			date = DateUtil.getDate(sdate);
		}
		return date;
	}

	public String getSessionId() {
		String sessionid = this.getClientValue("sessionidwww");
		return sessionid;
	}

	public int getCookieMemberId() {
		String session = this.getSessionId();
		if (!StringUtil.is_Empty(session)) {
			return NumberUtil.parseInt(session);
		}
		return 0;
	}

	/**
	 * 
	 * 
	 * @param context
	 *            Description of the Parameter
	 * @param key
	 *            Description of the Parameter
	 * 
	 * @return The clientValue value
	 */
	public String getClientValue(String key) {
		return cookieUtil.getClientValue(key);
	}

	/**
	 * 
	 * 
	 * @param context
	 *            Description of the Parameter
	 * @param key
	 *            Description of the Parameter
	 * 
	 * @return The tempClientValue value
	 */
	public String getTempClientValue(String key) {
		return cookieUtil.getTempClientValue(key);
	}

	public String getTodayClientValue(String key) {
		return cookieUtil.getTodayClientValue(key);
	}

	public void setTodayClientValue(String key, Object value) {
		cookieUtil.setTodayClientValue(key, value);
	}

	public String getOldClientValue(String key) {
		return cookieUtil.getOldClientValue(key);
	}

	public void setOldClientValue(String key, Object value) {
		cookieUtil.setOldClientValue(key, value);
	}

	/**
	 * 
	 * 
	 * @param context
	 *            The new clientValue value
	 * @param key
	 *            The new clientValue value
	 * @param value
	 *            The new clientValue value
	 */
	public void setClientValue(String key, Object value) {
		cookieUtil.setClientValue(key, value);
	}

	// public int getTeamId(){
	// String s = this.getTempClientValue("teamId");
	// if(s != null && StringUtils.isNumeric(s)){
	// return Integer.parseInt(s);
	// }else{
	// return -1;
	// }
	// }
	/**
	 * 
	 * 
	 * @param context
	 *            The new clientValue value
	 * @param key
	 *            The new clientValue value
	 * @param value
	 *            The new clientValue value
	 */
	public void setTempClientValue(String key, Object value) {
		cookieUtil.setTempClientValue(key, value);
	}

	public void saveCookie() {
		cookieUtil.saveCookie();
	}

	public Object[] getKeys() {
		return null;
	}

	@Override
	public boolean containsKey(Object a) {
		return false;
	}

	@Override
	public Object remove(Object key) {
		return null;
	}

}