package com.tyloo.modules.member;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tyloo.fw.orm.Persistent;
import com.tyloo.modules.CommonService;
import com.tyloo.po.Products;


public class RecommendService extends CommonService{


	/**
     * 
     * 功能描述:按标题检索
     * @param name
     * @param limitNum
     * @return
     */
    public List<Products> getRecommendByChannel(String name, int start, int end)
    {
       Session session =  dao.getHibernateTemplate().getSessionFactory().openSession();
       String hql = "FROM Recommend WHERE isDeleted=0 and name="+name;
    
       hql = hql+" ORDER BY sortNum ASC";
        Query query = session.createQuery(hql);
        
        if(end>0)
        {
            query.setFirstResult(start);
            query.setMaxResults(end);
        }
        List<Products> recommend = query.list();
        session.close();
        return recommend;
    }

    
	
	
	 public List<Products> getAllRecommend() {
			String hql = "from Recommend where isDeleted=0 order by sortNum desc, id desc";
			List<Products> list1 = dao.find(hql, null);
			return list1;
		}

  }
