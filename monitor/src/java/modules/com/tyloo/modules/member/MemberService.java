package com.tyloo.modules.member;

import java.util.List;

import com.tyloo.modules.CommonService;
import com.tyloo.po.AboutUs;
import com.tyloo.po.Member;

public class MemberService extends CommonService {
	public Member getMemberById(int id) {
		return (Member) dao.load(Member.class, id);
	}

	public List<Member> getMember(){
		String hql="from Member where isDeleted=0";	
		return dao.find(hql, null);
	}
	
	public Member getMemberByNameAndPwd(String loginName, String pwd, int state) {
		String hql = "from Member where  isDeleted=0 and loginName=? and password=? and state = ?";
		return (Member) dao.findSingle(hql, new Object[] { loginName, pwd,
				state });
	}

	
	public Member getMemberByName(String loginName) {
		String hql = "from Member where  isDeleted=0 and loginName=?";
		return (Member) dao.findSingle(hql, new Object[] { loginName });
	}

	public Member getMemberListName(int id) {
		String hql = "from Member m where  m.isDeleted=0 and m.id=?";
		List<Member> member = dao.find(hql, new Object[] { id });
		if (member.size() > 0) {
			return member.get(0);
		} else {
			return null;
		}
	}

	public String getMemberIdByName(String userName) {
		String hql = " from Member where  isDeleted=0 and username=?";
		List<Member> members = (List<Member>) dao.find(hql,
				new Object[] { userName });
		String userIds = "";
		for (Member m : members) {
			userIds += m.getId() + ",";
		}
		if (!userIds.equals(""))
			return userIds.substring(0, userIds.length() - 1);
		else
			return userIds;
	}

	public List<Member> getMemberList() {
		String hql = "from Member where isDeleted=0  order by username";
		return dao.find(hql, null);
	}


	public List<Member> getMemberListByGroupId(int groupId) {
		String hql = "from Member where  isDeleted=0 and groupId=?";
		return dao.find(hql, new Object[] { groupId });
	}

	public Member getLocalMemberByName(String loginName) {
		String hql = "from Member where  isDeleted=0 and loginName=?";
		return (Member) dao.findSingle(hql, new Object[] { loginName });
		
	}


	public Member getMemberByLoginnameAndPwd(String loginName, String pwd) {
		String hql = "from Member where  isDeleted=0 and loginName=? and password=? ";
		return (Member) dao.findSingle(hql, new Object[] { loginName, pwd,});
	}
	
	
	public List<Member> getMemberListByroleId() {
		String hql = "from Member where  isDeleted=0 and roleId=5 order by username";
		return dao.find(hql, null);
	}
	
	
	/**
	 * 根据faq类型获得faq
	 * @param typeid
	 * @return
	 */
	
	public List<AboutUs> getAboutUsList()
	{
		String hql = "from AboutUs where isDeleted=0 order by sortNum desc, id desc";
		return dao.find(hql, null);
	}
	
	
}
