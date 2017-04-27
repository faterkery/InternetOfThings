package com.tyloo.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.tyloo.modules.member.GroupsService;
import com.tyloo.modules.member.MemberService;
import com.tyloo.modules.member.ModuleService;
import com.tyloo.modules.member.ResourcesService;
import com.tyloo.modules.member.RoleModuleService;
import com.tyloo.modules.member.RoleService;
import com.tyloo.po.AboutUs;
import com.tyloo.po.Groups;
import com.tyloo.po.Member;
import com.tyloo.po.Resources;
import com.tyloo.po.Role;
import com.tyloo.util.DateUtil;
import com.tyloo.util.SecurityUtil;

public class VMUtils {
	private MemberService memberService;
	private ModuleService moduleService;
	private GroupsService groupsService;
	private RoleService roleService;
	private RoleModuleService roleModuleService;
	private ResourcesService resourcesService;

	// 权限模块分类
	public boolean isRoleModuleAccessPri(int roleId, int moduleId) {
		boolean strRole = false;
		String can = moduleService.getRoleModuleAccessPri(roleId, moduleId);
		if (!"n".equals(can)) {
			strRole = true;
		}
		// System.out.println("11111111111"+strRole);
		return strRole;
	}

	public String getRoleModuleAccessPri(int roleId, int moduleId) {
		return moduleService.getRoleModuleAccessPri(roleId, moduleId);
	}



	public List<Member> getMemberList() {
		List<Member> memberList = memberService.getMemberList();
		return memberList;
	}

	public String getGroupsNumber(Integer id) {
		Groups groups = (Groups) groupsService.getObjectByIdFull(Groups.class,
				id);
		return groups == null ? "" : groups.getName();

	}

	public String htmlspecialchars(String str) {
		if (str != null) {
			str = str.replaceAll("&", "&amp;");
			str = str.replaceAll("<", "&lt;");
			str = str.replaceAll(">", "&gt;");
			str = str.replaceAll("\"", "&quot;");
			return str;
		} else {
			return "";
		}
	}

	public static String html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			// 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>}
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			// 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>}
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签
			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签
			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签
			textStr = htmlStr;
		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;// 返回文本字符串
	}

	public static String getRandomNum(int code_len) {
		int count = 0;
		char str[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < code_len) {
			int i = Math.abs(r.nextInt(10));
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}

	public static String encrypt(int istr) {
		return SecurityUtil.encrypt(istr);
	}

	public static String encrypt(String str) {
		return SecurityUtil.encrypt(str);
	}

	public String dateFormate(Date date, String formate) {
		return DateUtil.dateFormate(date, formate);
	}

	public String dateFormateSimple(Date date) {
		return dateFormate(date, "yyyy年M月d日");
	}

	public String dateTimeFormateSimple(Date date) {
		return dateFormate(date, "yyyy-MM-dd HH:mm");
	}

	public String dateTimeFormateSimple(int seconds) {
		Date date = DateUtil.mysqlDate2Date(seconds);
		return dateTimeFormateSimple(date);
	}

	public String dateFormateSimple(int seconds) {
		Date date = DateUtil.mysqlDate2Date(seconds);
		return dateFormate(date, "yyyy年M月d日");
	}

	public String dateFormate(int seconds, String formate) {
		return DateUtil.dateFormate(seconds, formate);
	}

	public String dateFormateHuman(int seconds) {
		return DateUtil.dateFormateHuman(seconds);
	}

	public String dateFormateHuman(Date date) {
		return DateUtil.dateFormateHuman(date);
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	public GroupsService getGroupsService() {
		return groupsService;
	}

	public void setGroupsService(GroupsService groupsService) {
		this.groupsService = groupsService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public RoleModuleService getRoleModuleService() {
		return roleModuleService;
	}

	public void setRoleModuleService(RoleModuleService roleModuleService) {
		this.roleModuleService = roleModuleService;
	}


	public String getRoleNumber(Integer id) {
		Role role = (Role) groupsService.getObjectByIdFull(Role.class, id);
		return role == null ? "" : role.getName();

	}

	public List<Resources> getResourceByType(String type) {
		return resourcesService.getResourceByType(type);
	}

	public ResourcesService getResourcesService() {
		return resourcesService;
	}

	public void setResourcesService(ResourcesService resourcesService) {
		this.resourcesService = resourcesService;
	}
	
	public String getResourceValue(int id) {
		return resourcesService.getResourceValue(id);
	}
	
	/**
	 * java对象转json字符串
	 * @param obj
	 * @return
	 */
	public static String toJsonStr(Object obj)
	{
		JSONObject json = JSONObject.fromObject(obj);
		return json.toString();
		
	}
	
	
	public List<AboutUs> getAboutUsList()
	{
		return memberService.getAboutUsList();
	}


	/**
	 * 保留2位小数
	 * @param number
	 * @return
	 */
	public static String changeBigNumber2String(double number) {
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setGroupingUsed(false);
		return nf.format(number);
	}
	
	public static String getOrderCode() {
		String orderCode = "";
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String time = df.format(date);
		orderCode = String.valueOf(date.getTime());
		orderCode = orderCode.substring(8, 13);
		orderCode = time + orderCode;
		return orderCode;
	}
	
	
	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	public int double2int(double num)
	{
		return (int)num;
		
	}
	
	
	
	
}
