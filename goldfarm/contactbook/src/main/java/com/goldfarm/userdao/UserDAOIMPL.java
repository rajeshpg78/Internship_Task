package com.goldfarm.userdao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goldfarm.model.UserDetails;


@Repository("userDAO")
public class UserDAOIMPL implements UserDAO{
	 
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	UserDetails userDetails;
	public UserDAOIMPL(SessionFactory sessionFactory2) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {
		System.out.println("before in back end save");
		
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
		System.out.println("after save");
	}
	@Transactional
	public void delete(String twitterusername) {
		UserDetails userDelete=new UserDetails();
		 userDelete.setTwitterusername(twitterusername);
		 sessionFactory.getCurrentSession().delete(userDelete);
		
	}

	public void edit(String twitterusername) {
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public UserDetails get(String twitterusername) {
	
		String hql = "from UserDetails where twitterusername=" + "'"+twitterusername+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("in back end get method");
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	 
	}
	@Transactional
	public List<UserDetails> list() {
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) sessionFactory.getCurrentSession()
				.createCriteria(UserDetails.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}
	 

}
