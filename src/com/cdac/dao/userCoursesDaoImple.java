package com.cdac.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Courses;
import com.cdac.dto.User;
@Repository
public class userCoursesDaoImple implements userCourseDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void insertData(final Courses c, final User u) {
		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Set<User>u1 = new HashSet<User>();
				u1.add(u);
				Set<Courses> c1 = new HashSet<Courses>();
				c1.add(c);
				u.setCourses(c1);
				c.setUser(u1);
				session.save(u);
				session.save(c);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
			
		});
		
	}

	@Override
	public List<Courses> SelectCourses(Courses c, User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
