package com.tyloo.modules.member;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tyloo.fw.orm.Persistent;
import com.tyloo.modules.CommonService;
import com.tyloo.po.AboutUs;


public class AboutUsService extends CommonService{

    /**
     * 
     * 功能描述:按标题检索
     * @param title
     * @param limitNum
     * @return
     */
    public List<AboutUs> getAboutUsByChannel(String title, int start, int end)
    {
       Session session =  dao.getHibernateTemplate().getSessionFactory().openSession();
       String hql = "FROM AboutUs WHERE isDeleted=0 and title="+title;
    
       hql = hql+" ORDER BY sortNum ASC";
        Query query = session.createQuery(hql);
        
        if(end>0)
        {
            query.setFirstResult(start);
            query.setMaxResults(end);
        }
        List<AboutUs> aboutus = query.list();
        session.close();
        return aboutus;
    }
    
    
	public void updateSortNum(Class actionClass, int id, int sortNum) 
	{
		Persistent pp = this.getObjectById(actionClass, id);
		((AboutUs) pp).setSortNum(sortNum);
		dao.update(pp);
	}
	
	
	public List<AboutUs> getAllAboutUs() {
		String hql = "from AboutUs where isDeleted=0 order by sortNum desc, id desc";
		List<AboutUs> list = dao.find(hql, null);
		return list;
	}

}
