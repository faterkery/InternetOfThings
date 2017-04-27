package com.renhenet.fw.waf;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.renhenet.fw.Config;
import com.renhenet.util.SecurityUtil;
@SuppressWarnings("unchecked")
public class CookieUtil {
	private String COOKIE_CLIENT_DATA = Config.getString(
			"sys.renhe.cookiename", "__renhe_cookie_client_data__");

	private String COOKIE_TODAY_CLIENT_DATA = "__renhe_cookie_TODAY_client_data__";

	private String COOKIE_TEMP_CLIENT_DATA = "__renhe_cookie_temp_client_data__";

	private String COOKIE_OLD_CLIENT_DATA = Config.getString(
			"sys.oldrenhe.cookiename", "wwwrenhenetcom_v");

	private String COOKIE_MODIFIED_FLAG = "updated";

	protected static Log log = LogFactory.getLog(CookieUtil.class);

	private HttpServletRequest request = null;

	private HttpServletResponse response = null;

	public CookieUtil(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	private static final String DOMAIN = Config.getString("sys.domain",
			".renhenet.com");

	public String getClientValue(Object key) {
		return (String) parseCookie(COOKIE_CLIENT_DATA).get(key);
	}

	public String getTempClientValue(Object key) {
		return (String) parseCookie(COOKIE_TEMP_CLIENT_DATA).get(key);
	}

	public String getTodayClientValue(Object key) {
		return (String) parseCookie(COOKIE_TODAY_CLIENT_DATA).get(key);
	}

	public void setTodayClientValue(Object key, Object value) {
		setValue(COOKIE_TODAY_CLIENT_DATA, key, value);
	}

	public String getOldClientValue(Object key) {
		return (String) parseCookie(COOKIE_OLD_CLIENT_DATA).get(key);
	}

	public void setOldClientValue(Object key, Object value) {
		setValue(COOKIE_OLD_CLIENT_DATA, key, value);
	}

	public void setClientValue(Object key, Object value) {
		setValue(COOKIE_CLIENT_DATA, key, value);
	}

	public void setTempClientValue(Object key, Object value) {
		setValue(COOKIE_TEMP_CLIENT_DATA, key, value);
	}

	@SuppressWarnings("unchecked")
	private void setValue(String cookieName, Object key, Object value) {
		HashMap cd = parseCookie(cookieName);
		if (key != null) {
			if (value != null) {
				cd.put(key, value);
			} else {
				cd.remove(key);
			}
		} else {
			return;
		}
		request.setAttribute(cookieName + COOKIE_MODIFIED_FLAG, key);
	}

	public void saveCookie() {
		// log.debug("save all cookie...................");
		save(COOKIE_CLIENT_DATA);
		save(COOKIE_TODAY_CLIENT_DATA);
		save(COOKIE_TEMP_CLIENT_DATA);
		save(COOKIE_OLD_CLIENT_DATA);
	}

	private void save(String cookieName) {
		if (request.getAttribute(cookieName + COOKIE_MODIFIED_FLAG) != null) {
			HashMap cd = (HashMap) request.getAttribute(cookieName);
			String cdString = "";
			for (Iterator e = cd.keySet().iterator(); (e != null)
					&& e.hasNext();) {
				Object key = e.next();
				if ((key != null) && (cd.get(key) != null)) {
					cdString += (key.toString() + "=" + cd.get(key).toString());
					if (e.hasNext()) {
						cdString += "&";
					}
				}
			}
			addCrypticCookie(cookieName, cdString);
			request.setAttribute(cookieName + COOKIE_MODIFIED_FLAG, null);
		}
	}

	@SuppressWarnings("unchecked")
	private HashMap parseCookie(String cookieName) {
		HashMap cd = (HashMap) request.getAttribute(cookieName);
		if (cd != null) {
			return cd;
		}
		String cdString = getCrypticCookie(cookieName);
		cd = new HashMap();
		request.setAttribute(cookieName, cd);
		if (StringUtils.isEmpty(cdString)) {
			return cd;
		}
		String[] keyValue = StringUtils.split(cdString, "&");
		for (int i = 0; (keyValue != null) && (i < keyValue.length); i++) {
			if (keyValue[i] != null) {
				keyValue[i] = keyValue[i].replaceAll("%3D", "=");
				int offset = keyValue[i].indexOf("=");
				if ((offset > 0) && (offset < (keyValue[i].length() - 1))) {
					cd.put(keyValue[i].substring(0, offset), keyValue[i]
							.substring(offset + 1, keyValue[i].length()));
				}
			}
		}
		return cd;
	}

	private void addCrypticCookie(String cookieName, String cookieValue) {
		// System.err.println("cookieValue=" + cookieValue);
		String val = SecurityUtil.encrypt(cookieValue);
		// System.err.println("addCrypticCookie=" + val);
		int age = -1;
		String userDomain = "";
		if (COOKIE_CLIENT_DATA.equals(cookieName)) {
			age = 99999999;
		} else if (COOKIE_TODAY_CLIENT_DATA.equals(cookieName)) {
			age = 24 * 3600;
		} else if (COOKIE_OLD_CLIENT_DATA.equals(cookieName)) {
			userDomain = Config.getString("sys.oldrenhe.domain",
					".renhenet.com");
			age = 99999999;
		} else {
			age = -1;
		}
		addCookie(cookieName, val, age, userDomain);
	}

	@SuppressWarnings("unused")
	private void addCrypticCookie(String cookieName, String cookieValue, int age) {
		String val = SecurityUtil.encrypt(cookieValue);
		addCookie(cookieName, val, age, "");
	}

	@SuppressWarnings("unused")
	private void addCookie(String name, String val, boolean persist) {
		int age = -1;
		if (persist) {
			age = 99999999;
		} else {
			age = -1;
		}
		addCookie(name, val, age, "");
	}

	private void addCookie(String name, String val, int age, String userDomain) {
		Cookie c = new Cookie(name, val);
		c.setMaxAge(age);
		c.setPath("/");
		String domain = DOMAIN;
		if (userDomain.length() > 0) {
			domain = userDomain;
		}
		if (!StringUtils.isEmpty(domain)) {
			int i = domain.indexOf(":");
			if (i >= 0) {
				domain = domain.substring(0, i);
			}
			c.setDomain(domain);
		}

		response.addCookie(c);
	}

	private String getCrypticCookie(String cookieName) {
		String val = getCookieValue(cookieName, null);
		if (val == null) {
			return null;
		}
		return SecurityUtil.decrypt(val);
	}

	private String getCookieValue(String cookieName, String defaultvalue) {
		Cookie[] cookies = null;
		try {
			cookies = request.getCookies();
		} catch (IllegalArgumentException iae) {
			log.error("", iae);
		}
		if ((cookies == null) || (cookies.length == 0)) {
			return defaultvalue;
		}
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookieName.equals(cookie.getName()))
				return (cookie.getValue());
		}
		return (defaultvalue);
	}
}
